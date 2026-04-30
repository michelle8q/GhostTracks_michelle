/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.objetosNegocio;

import itson.org.ghosttracks.dtos.CarritoDTO;
import itson.org.ghosttracks.dtos.ItemCarritoDTO;
import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.negocio.interfaces.ICarritoBO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;


/**
 *
 * @author Cinca
 */
public class CarritoBO implements ICarritoBO{
   @Override
    public CarritoDTO agregarProducto(CarritoDTO carrito, ProductoDTO producto, Integer cantidad) throws NegocioException {

        boolean existe = false;
        for (ItemCarritoDTO item : carrito.getProductos()) {
            if (item.getProductoSeleccionado().getIdProducto().equals(producto.getIdProducto())) {
                item.setCantidad(item.getCantidad() + cantidad);
                existe = true;
                break;
            }
        }

        if (!existe) {
            ItemCarritoDTO nuevoItem = new ItemCarritoDTO();
            nuevoItem.setProductoSeleccionado(producto);
            nuevoItem.setCantidad(cantidad);
            
            carrito.getProductos().add(nuevoItem);
        }

        carrito.calcularTotalGeneral();

        return carrito;
    }

    @Override
    public CarritoDTO eliminarProducto(CarritoDTO carrito, Long idProducto) throws NegocioException {

        carrito.getProductos().removeIf(item -> 
            item.getProductoSeleccionado().getIdProducto().equals(idProducto)
        );

        carrito.calcularTotalGeneral();

        return carrito;
    }
    
   @Override
    public CarritoDTO limpiarCarrito(CarritoDTO carrito) throws NegocioException {
 
        carrito.getProductos().clear();

        return carrito;
    }
}
