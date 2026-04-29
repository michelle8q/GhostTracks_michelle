/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.mappers;


import itson.org.ghosttracks.builders.PedidoBuilder;
import itson.org.ghosttracks.dtos.ItemCarritoDTO;
import itson.org.ghosttracks.dtos.PedidoDTO;
import itson.org.ghosttracks.entidades.Pedido;
import itson.org.ghosttracks.entidades.ProductoPedido;
import itson.org.ghosttracks.enums.EstadoPedido;
import itson.org.ghosttracks.enums.EstadoPedidoDTO;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author cinca
 */
public class PedidoAdapter {
    
    public static PedidoDTO toDTO(Pedido pedido) {
        
        PedidoDTO dto = new PedidoDTO();
        
        dto.setIdPedido(pedido.getIdPedido());
        dto.setCostoEnvio(pedido.getCostoEnvio());
        dto.setFechaPedido(pedido.getFechaPedido());
        dto.setSubtotal(pedido.getSubtotal());
        dto.setTotal(pedido.getTotal());
        dto.setIdCliente(pedido.getIdCliente());
        dto.setEstado(EstadoPedidoDTO.valueOf(pedido.getEstado().name()));
        dto.setFolio(pedido.getFolio());
        
        
        List<ItemCarritoDTO> items = new ArrayList<>();
        
        for(ProductoPedido productoPedido: pedido.getProductosPedido()) {
            items.add(ProductoPedidoAdapter.toDTO(productoPedido));
            
        }
        
        dto.setProductos(items);
        return dto;
    }
    
    public static Pedido toEntity(PedidoDTO dto) {

        List<ProductoPedido> productos = new ArrayList<>();
        
        for(ItemCarritoDTO item: dto.getProductos()) {
            productos.add(ProductoPedidoAdapter.toEntity(item));
            
        }
        
        return new PedidoBuilder()
            .idCliente(dto.getIdCliente())
            .productos(productos)
            .subtotal(dto.getSubtotal())
            .total(dto.getTotal())
            .costoEnvio(dto.getCostoEnvio())
            .folio(dto.getFolio())
            
            .build();
    }
    
    
}

