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

    List<ProductoDTO> obtenerCatalogo() throws NegocioException;

    ProductoDTO consultarDetalleProducto(Long id) throws NegocioException;

    ClienteDTO consultarPerfilCliente(Long idCliente, String nombre) throws NegocioException;
    
    AdministradorDTO consultarPerfilAdministrador(Long idEmpleado, String nombre) throws NegocioException;
    
    CarritoDTO agregarAlCarrito(CarritoDTO carritoActual, ProductoDTO producto, Integer cantidad) throws NegocioException;
    
    PedidoDTO confirmarCompra(PedidoDTO pedido) throws NegocioException;
    
    PedidoDTO actualizarEstadoPedido(Long idPedido, EstadoPedidoDTO nuevoEstado) throws NegocioException;
    
    CarritoDTO eliminarDelCarrito(CarritoDTO carrito, Long idProducto) throws NegocioException;
    
    List<PedidoDTO> obtenerTodosLosPedidos() throws NegocioException;
    
    void calcularTotalesPedido(PedidoDTO pedidoDto);
    
    ProductoDTO consultarProducto(String nombre) throws NegocioException;
    
    CarritoDTO limpiarProductosCarrito(CarritoDTO carrito) throws NegocioException;
 
}
