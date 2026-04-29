/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.builders;

import itson.org.ghosttracks.entidades.DatosPago;
import itson.org.ghosttracks.entidades.Pedido;
import itson.org.ghosttracks.entidades.ProductoPedido;
import itson.org.ghosttracks.enums.EstadoPedido;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementacion de builder para crear pedidos completos y 
 * facilitar su construccion.
 * 
 * @author cinca
 * 
 */
public class PedidoBuilder implements IPedidoBuilder {
    private Pedido pedido;
    
    public PedidoBuilder() {
        this.pedido = new Pedido();
    }
    
    @Override
    public PedidoBuilder idCliente(Long idCliente) {
        pedido.setIdCliente(idCliente);
        return this;
    }
    @Override
    public PedidoBuilder productos(List<ProductoPedido> productos) {
        pedido.setProductosPedido(productos);
        return this;
    }
    @Override
    public PedidoBuilder subtotal(Double subtotal) {
        pedido.setSubtotal(subtotal);
        return this;
    }
    @Override
    public PedidoBuilder total(Double total) {
        pedido.setTotal(total);
        return this;
    }
    @Override
    public PedidoBuilder costoEnvio(Double envio) {
        pedido.setCostoEnvio(envio);
        return this;
    }
    @Override
    public PedidoBuilder folio(String folio) {
        pedido.setFolio(folio);
        return this;
    }
    @Override
    public PedidoBuilder fecha(LocalDateTime fecha) {
        pedido.setFechaPedido(fecha);
        return this;
    }
    @Override
    public PedidoBuilder estado(EstadoPedido estado) {
        pedido.setEstado(estado);
        return this;
    }
    
    @Override
    public PedidoBuilder datosPago(DatosPago pago) {
        pedido.setDatosPago(pago);
        return this;
    }
    
        
    @Override
    public Pedido build() {
        return pedido;
    }

    
}