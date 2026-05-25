package Gestor.import_tdf.service.impl;

import Gestor.import_tdf.dto.CrearVentaRequest;
import Gestor.import_tdf.dto.PagoVentaRequest;
import Gestor.import_tdf.dto.ProductoVentaRequest;
import Gestor.import_tdf.entity.*;
import Gestor.import_tdf.enums.EstadoStock;
import Gestor.import_tdf.enums.Moneda;
import Gestor.import_tdf.repository.*;
import Gestor.import_tdf.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta buscarPorId(Long id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    @Override
    public Venta crearVenta(CrearVentaRequest request) {

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Vendedor vendedor = vendedorRepository.findById(request.getVendedorId())
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));

        Venta venta = new Venta();
        venta.setFecha(request.getFecha());
        venta.setCliente(cliente);
        venta.setVendedor(vendedor);
        venta.setCotizacionDolar(request.getCotizacionDolar());
        venta.setObservacion(request.getObservacion());

        BigDecimal totalVenta = BigDecimal.ZERO;
        BigDecimal gananciaTotal = BigDecimal.ZERO;

        for (ProductoVentaRequest productoRequest : request.getProductos()) {

            System.out.println(productoRequest.getProductoId());

            Producto producto = productoRepository.findById(productoRequest.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            if (producto.getStock() == null || producto.getStock() <= 0) {
                throw new RuntimeException("Producto sin stock");
            }

            BigDecimal precioVenta = productoRequest.getPrecioVentaPesos();
            BigDecimal costoPesos = producto.getPrecioCostoPesos();
            BigDecimal gananciaPesos = precioVenta.subtract(costoPesos);

            BigDecimal gananciaUsd = gananciaPesos.divide(
                    request.getCotizacionDolar(),
                    2,
                    RoundingMode.HALF_UP
            );

            DetalleVenta detalle = new DetalleVenta();
            detalle.setVenta(venta);
            detalle.setProducto(producto);
            detalle.setPrecioVentaPesos(precioVenta);
            detalle.setPrecioCostoUsd(producto.getPrecioCostoUsd());
            detalle.setPrecioCostoPesos(costoPesos);
            detalle.setGananciaPesos(gananciaPesos);
            detalle.setGananciaUsd(gananciaUsd);

            venta.getDetalles().add(detalle);

            producto.setStock(producto.getStock() - 1);
            productoRepository.save(producto);

            totalVenta = totalVenta.add(precioVenta);
            gananciaTotal = gananciaTotal.add(gananciaPesos);
        }

        for (PagoVentaRequest pagoRequest : request.getPagos()) {

            PagoVenta pago = new PagoVenta();
            pago.setVenta(venta);
            pago.setMetodoPago(pagoRequest.getMetodoPago());
            pago.setMoneda(pagoRequest.getMoneda());
            pago.setMonto(pagoRequest.getMonto());
            pago.setCotizacionUsada(pagoRequest.getCotizacionUsada());

            BigDecimal montoConvertidoPesos;

            if (pagoRequest.getMoneda() == Moneda.PESOS) {
                montoConvertidoPesos = pagoRequest.getMonto();
            } else {
                montoConvertidoPesos = pagoRequest.getMonto().multiply(pagoRequest.getCotizacionUsada());
            }

            pago.setMontoConvertidoPesos(montoConvertidoPesos);

            venta.getPagos().add(pago);
        }

        venta.setTotalVentaPesos(totalVenta);
        venta.setGananciaTotalPesos(gananciaTotal);

        return ventaRepository.save(venta);
    }
}
