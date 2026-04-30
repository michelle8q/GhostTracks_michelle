/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracksventaenlinea.interfaces;

import itson.org.ghosttracks.dtos.AdministradorDTO;
import itson.org.ghosttracks.dtos.CarritoDTO;
import itson.org.ghosttracks.dtos.ClienteDTO;
import itson.org.ghosttracks.dtos.PedidoDTO;
import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.enums.EstadoPedidoDTO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author nafbr
 */
public interface IVentaEnLinea {

    List<ProductoDTO> obtenerCatalogo() throws Exception;

    ProductoDTO consultarDetalleProducto(Long id) throws Exception;

    ClienteDTO consultarPerfilCliente(Long idCliente, String nombre) throws Exception;
    
    AdministradorDTO consultarPerfilAdministrador(Long idEmpleado, String nombre) throws Exception;
    
    CarritoDTO agregarAlCarrito(CarritoDTO carritoActual, ProductoDTO producto, Integer cantidad) throws Exception;
    
    PedidoDTO confirmarCompra(PedidoDTO pedido) throws Exception;
    
    PedidoDTO actualizarEstadoPedido(Long idPedido, EstadoPedidoDTO nuevoEstado) throws Exception;
    
    CarritoDTO eliminarDelCarrito(CarritoDTO carrito, Long idProducto) throws Exception;
    
    List<PedidoDTO> obtenerTodosLosPedidos() throws Exception;
    
    void calcularTotalesPedido(PedidoDTO pedidoDto);
    
    ProductoDTO consultarProducto(String nombre) throws NegocioException;
    
    CarritoDTO limpiarProductosCarrito(CarritoDTO carrito) throws NegocioException;
 
}
