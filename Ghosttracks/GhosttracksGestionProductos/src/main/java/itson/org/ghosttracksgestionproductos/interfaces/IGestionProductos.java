/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.org.ghosttracksgestionproductos.interfaces;

import itson.org.ghosttracks.dtos.CatalogoProductosDTO;
import itson.org.ghosttracks.dtos.FiltroProductoDTO;
import itson.org.ghosttracks.dtos.GeneroDTO;
import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.dtos.SucursalDTO;
import itson.org.ghosttracks.dtos.TipoDTO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author cinca
 */
public interface IGestionProductos {
    Boolean validarProductoExistente(ProductoDTO producto);
   
    Boolean validarPrecioProducto(float precioProducto);
    
    Boolean validarNombreProducto(String nombreProducto);
  
    Boolean validarArtistaProducto(String artistaProducto);
  
    Boolean validarStockInicialProducto(int Stock);
  
    List<ProductoDTO> obtenerCatalogoProductosPorFiltro(FiltroProductoDTO filtro) throws NegocioException;
    
    List<CatalogoProductosDTO> obtenerCatalogoProductosCompleto() throws NegocioException;
 
    ProductoDTO actualizarProducto (ProductoDTO producto) throws NegocioException ;
 
    ProductoDTO crearProducto (ProductoDTO producto) throws NegocioException;
    
    ProductoDTO eliminarProducto(ProductoDTO producto) throws NegocioException;
     
    ProductoDTO obtenerDetallesProductoSeleccionado (Long idProducto) throws NegocioException;
   
    List<GeneroDTO> obtenerGeneros () throws NegocioException;
    
    List<SucursalDTO> obtenerSucursales() throws NegocioException;
     

    List<TipoDTO> obtenerTipos() throws NegocioException;
    
    Integer obtenerStockPorSucursal(Long idProducto, Long idSucursal) throws NegocioException;
    
    SucursalDTO obtenerSucursalSeleccionada(Long idSucursal) throws NegocioException;
        
     
}
