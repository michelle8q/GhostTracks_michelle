/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracksgestionproductos.fachada;

import itson.org.ghosttracks.dtos.FiltroProductoDTO;
import itson.org.ghosttracks.dtos.GeneroDTO;
import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.dtos.SucursalDTO;
import itson.org.ghosttracks.dtos.TipoDTO;
import itson.org.ghosttracks.negocio.interfaces.IGenerosBO;
import itson.org.ghosttracks.negocio.interfaces.IProductosBO;
import itson.org.ghosttracks.negocio.interfaces.ISucursalesBO;
import itson.org.ghosttracks.negocio.interfaces.ITiposBO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import itson.org.ghosttracks.negocio.objetosNegocio.GenerosBO;
import itson.org.ghosttracks.negocio.objetosNegocio.ProductosBO;
import itson.org.ghosttracks.negocio.objetosNegocio.SucursalesBO;
import itson.org.ghosttracks.negocio.objetosNegocio.TiposBO;
import itson.org.ghosttracksgestionproductos.interfaces.IGestionProductos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cinca
 */
public class GestionProductos implements IGestionProductos {

    private final IProductosBO productosBO;
    private final ISucursalesBO sucursalesBO;
    private final ITiposBO tiposBO;
    private final IGenerosBO generosBO;
    
    public GestionProductos() {
        this.productosBO = new ProductosBO();
        this.sucursalesBO = new SucursalesBO();
        this.tiposBO = new TiposBO();
        this.generosBO = new GenerosBO();
        
    }
    @Override
    public Boolean validarProductoExistente(ProductoDTO producto) {
        try {
            List<ProductoDTO> productos = productosBO.obtenerTodos();
            for (ProductoDTO productoGuardado : productos) {
                if (productoGuardado.getNombre().equalsIgnoreCase(producto.getNombre()) || productoGuardado.getArtista().equalsIgnoreCase
                    (producto.getArtista())) {
                    return true;
                }
            }
           
        } catch (NegocioException ex) {
            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public Boolean validarPrecioProducto(float precioProducto) {  
        return precioProducto > 0;
        
    }
    
    @Override
    public Boolean validarNombreProducto(String nombreProducto) {
        
        return (nombreProducto != null || !nombreProducto.trim().isEmpty());    
    }  
    @Override
    public Boolean validarArtistaProducto(String artistaProducto) {
        return (artistaProducto != null || !artistaProducto.trim().isEmpty());    
    }
    
    @Override
    public Boolean validarStockInicialProducto(int stock) {
        return stock >= 0;    
    }
    
    @Override
    public List<ProductoDTO> obtenerCatalogoProductos(FiltroProductoDTO filtro) {
        
        return null;
        
    }
    
    @Override
    public ProductoDTO actualizarProducto (ProductoDTO producto) throws Exception {
        return productosBO.actualizarProducto(producto);   
    }
    
    @Override
    public ProductoDTO crearProducto (ProductoDTO producto) throws Exception {
        if (validarProductoExistente(producto)) {
            throw new NegocioException("El producto ya existe");
        }
        return productosBO.crearProducto(producto);    
    }
    
    @Override
    public ProductoDTO obtenerDetallesProductoSeleccionado (Long idProducto) {
   
        return null;     
    }
    
    @Override
    public List<GeneroDTO> obtenerGeneros () throws Exception{
        return generosBO.obtenerGeneros();    
    }
    
    @Override
    public List<SucursalDTO> obtenerSucursales () throws Exception {
        return sucursalesBO.obtenerTodos();
           
    }
    
    @Override
    public List<TipoDTO> obtenerTipos() throws Exception { 
        return tiposBO.obtenerTipos();
    }
}
