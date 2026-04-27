/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.mappers;

import itson.org.ghosttracks.dtos.ItemCarritoDTO;
import itson.org.ghosttracks.entidades.ProductoPedido;

/**
 *
 * @author cinca
 */
class ProductoPedidoAdapter {

    public static ProductoPedido toEntity(ItemCarritoDTO item) {
        ProductoPedido entidad = new ProductoPedido();

        entidad.setCantidadProducto(item.getCantidad());
        entidad.setPrecioVendido(item.getProductoSeleccionado().getPrecio());
        entidad.setProducto(ProductoAdapter.toEntity(item.getProductoSeleccionado()));
        entidad.setImporteTotal(item.getSubtotal());
        

        return entidad;
    }

    public static ItemCarritoDTO toDTO(ProductoPedido productoPedido) {
        ItemCarritoDTO dto = new ItemCarritoDTO();

        dto.setCantidad(productoPedido.getCantidadProducto());
        dto.setProductoSeleccionado(ProductoAdapter.toDTO(productoPedido.getProducto()));
        dto.setSubtotal(productoPedido.getImporteTotal());

        return dto;
    
    }
    
}
