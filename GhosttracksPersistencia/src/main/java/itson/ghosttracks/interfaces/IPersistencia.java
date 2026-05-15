/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.ghosttracks.interfaces;

import itson.org.ghosttracks.entidades.Administrador;
import itson.org.ghosttracks.entidades.Cliente;
import itson.org.ghosttracks.entidades.Genero;
import itson.org.ghosttracks.entidades.Pedido;
import itson.org.ghosttracks.entidades.Producto;
import itson.org.ghosttracks.entidades.Sucursal;
import itson.org.ghosttracks.entidades.TipoProducto;
import itson.org.ghosttracks.enums.EstadoPedido;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import java.util.List;

/**
 *
 * @author cinca
 */
public interface IPersistencia {
    Producto agregarProducto(Producto producto) throws PersistenciaException;
    
    Producto actualizarProducto(Producto producto) throws PersistenciaException;
     
    Producto eliminarProducto(Producto producto) throws PersistenciaException;
        
   
    Producto obtenerProductoPorId(Long idProducto) throws PersistenciaException;
        
    Producto buscarProductoPorNombre(String nombre) throws PersistenciaException;
    
    List<Producto> obtenerProductos() throws PersistenciaException;
        
      
    Sucursal obtenerSucursalPorId(Long idProducto) throws PersistenciaException;
        
    List<Sucursal> obtenerSucursales() throws PersistenciaException;
        
     
    Genero obtenerGeneroPorId(Long idGenero) throws PersistenciaException;
        
       
    List<Genero> obtenerGeneros() throws PersistenciaException;
        
       
    TipoProducto obtenerTipoPorId(Long IdTipo) throws PersistenciaException;
       
       
    List<TipoProducto> obtenerTipos() throws PersistenciaException;
    
    Pedido guardarPedido(Pedido pedido) throws PersistenciaException;
    
    Pedido actualizarEstado(Long idPedido, EstadoPedido nuevoEstado) throws PersistenciaException;
    
    List<Pedido> consultarTodos() throws PersistenciaException;
    
    Cliente buscarClientePorNombre(String nombre) throws PersistenciaException;
    
    Cliente buscarClientePorId(Long idCliente) throws PersistenciaException;
    
    Administrador buscarAdminPorId(Long idUsuario) throws PersistenciaException;
    
    Administrador buscarPorIdEmpleado(Long idEmpleado) throws PersistenciaException;
    
    Administrador buscarAdminPorNombre(String nombre) throws PersistenciaException;
}
