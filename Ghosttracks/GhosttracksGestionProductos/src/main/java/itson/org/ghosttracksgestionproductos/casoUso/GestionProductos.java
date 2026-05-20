/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracksgestionproductos.casoUso;

import itson.org.ghosttracks.dtos.CatalogoProductosDTO;
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
import java.util.ArrayList;
import java.util.List;

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
    public Boolean validarProductoExistente(ProductoDTO producto) throws NegocioException {
        try {
            List<ProductoDTO> productos = productosBO.obtenerTodos();
            for (ProductoDTO productoGuardado : productos) {
                if (productoGuardado.getNombre().equalsIgnoreCase(producto.getNombre())) {
                    
                    if (productoGuardado.getArtista().equalsIgnoreCase(producto.getArtista())) {
                    return true;
                }
            }
        }
        } catch (NegocioException ex) {
            throw new NegocioException("Error al obtener los productos: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Boolean validarPrecioProducto(Float precioProducto) throws NegocioException {
        if(precioProducto == null) {
            throw new NegocioException("El precio no debe estar vacio.");
        }
        
        if(precioProducto <= 0) {
            throw new NegocioException("El precio debe ser mayor a 0.");
        }
        
        return true;
    }

    @Override
    public Boolean validarNombreProducto(String nombreProducto) throws NegocioException {
        if(nombreProducto == null || nombreProducto.trim().isEmpty()) {
            throw new NegocioException("El nombre del producto no debe estar vacio.");
        }
        
        if(nombreProducto.length() > 50) {
            throw new NegocioException("El nombre del producto no puede tener cmas de 50 caracteres");
        }
        
        return true;
    }

    @Override
    public Boolean validarArtistaProducto(String artistaProducto) throws NegocioException {
        if(artistaProducto == null || artistaProducto.trim().isEmpty()) {
            throw new NegocioException("El artista del producto no debe estar vacio.");
        }
        
        if(artistaProducto.length() > 30) {
            throw new NegocioException("El nombre del artista no puede tener mas de 30 caracteres");
        }
        
        return true;
    }

    @Override
    public Boolean validarStockInicialProducto(Integer stock) throws NegocioException {
        if(stock == null) {
            throw new NegocioException("El stock no debe estar vacio.");
        }
        
        if(stock <= 0) {
            throw new NegocioException("El stock debe ser mayor a 0.");
        }
        
        return true;
    }
    
    @Override
    public Boolean validarGeneroProducto(GeneroDTO genero) throws NegocioException {
        if(genero == null) {
           throw new NegocioException("El genero no puede estar vacio");
        }
        
        return true;
    }
    
    @Override
    public Boolean validarTipoProducto(TipoDTO tipo) throws NegocioException {
        if(tipo == null) {
           throw new NegocioException("El tipo no puede estar vacio");
        }
       
        return true;
    }

    @Override
    public List<CatalogoProductosDTO> obtenerCatalogoProductosPorFiltro(FiltroProductoDTO filtro) throws NegocioException {
        try {
            List<ProductoDTO> productos = productosBO.obtenerTodos();
            List<CatalogoProductosDTO> catalogo = new ArrayList<>();
            for (ProductoDTO producto : productos) {
                boolean existe = false;
                if(filtro == null) {
                    existe = true;
                }
                if (!existe && producto.getNombre().toLowerCase().contains(filtro.getNombre().toLowerCase())) {
                    existe = true;
                    }
                if (!existe &&producto.getArtista().toLowerCase().contains(filtro.getArtista().toLowerCase())) {
                        existe = true;
                    }
                if (!existe && producto.getGenero().getNombreGenero().toLowerCase().contains(filtro.getGenero().getNombreGenero().toLowerCase())) {
                        existe = true;
                    }
                if (!existe && producto.getTipoProducto().getNombreTipo().toLowerCase().contains(filtro.getTipo().getNombreTipo().toLowerCase())) {
                        existe = true;
                    }
                
                if (existe) {
                   CatalogoProductosDTO catalogoDTO = new CatalogoProductosDTO();
                   catalogoDTO.setIdProducto(producto.getIdProducto());
                   catalogoDTO.setNombre(producto.getNombre());
                   catalogoDTO.setArtista(producto.getArtista());
                   catalogoDTO.setStock(producto.getStock());

                    GeneroDTO genero = new GeneroDTO();
                    if(producto.getGenero() != null) {
                        genero.setNombreGenero(producto.getGenero().getNombreGenero());
                        catalogoDTO.setGenero(genero);
                    }
            
                    TipoDTO tipo = new TipoDTO();
                    if(producto.getTipoProducto() != null) {
                        tipo.setNombreTipo(producto.getTipoProducto().getNombreTipo());
                        catalogoDTO.setTipo(tipo);
                    }
                    catalogo.add(catalogoDTO);
                }  
            } 
            
            return catalogo;
        } catch (NegocioException e) {
            throw new NegocioException("Error al obtener productos filtrados: " + e.getMessage());
        }
        
     }
    
    
    @Override
    public ProductoDTO actualizarProducto(ProductoDTO producto) throws NegocioException {
        validarNombreProducto(producto.getNombre());
        validarArtistaProducto(producto.getArtista());
        validarPrecioProducto(producto.getPrecio().floatValue());
        //validarStockProducto(producto.getStock());
        validarGeneroProducto(new GeneroDTO(producto.getGenero().getNombreGenero()));
        validarTipoProducto(new TipoDTO(producto.getTipoProducto().getNombreTipo()));
        
        return productosBO.actualizarProducto(producto);
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO producto) throws NegocioException {
        if (validarProductoExistente(producto)) {
            throw new NegocioException("El producto ya existe");
        }
        
        validarNombreProducto(producto.getNombre());
        validarArtistaProducto(producto.getArtista());
        validarPrecioProducto(producto.getPrecio().floatValue());
        //validarStockProducto(producto.getStock());
        validarGeneroProducto(new GeneroDTO(producto.getGenero().getNombreGenero()));
        validarTipoProducto(new TipoDTO(producto.getTipoProducto().getNombreTipo()));
        
        return productosBO.crearProducto(producto);
    }
    
    @Override
    public ProductoDTO eliminarProducto(ProductoDTO producto) throws NegocioException {
        if (producto == null) {
            throw new NegocioException("No se puede eliminar un producto nulo.");
        }
        return productosBO.eliminarProducto(producto);
    }

    @Override
    public ProductoDTO obtenerDetallesProductoSeleccionado(Long idProducto) throws NegocioException {
        if (idProducto == null) {
            throw new NegocioException("El ID del producto a buscar no puede ser nulo");
        }
        return productosBO.obtenerProductoPorId(idProducto);
    }

    @Override
    public List<GeneroDTO> obtenerGeneros() throws NegocioException {
        List<GeneroDTO> generos= generosBO.obtenerGeneros();
        if(generos == null) {
                throw new NegocioException("La lista de generos no existe");
        }
        if(generos.isEmpty()) {
           throw new NegocioException("La lista de generos esta vacia");
        }
             
        return  generos;
    }

    @Override
    public List<SucursalDTO> obtenerSucursales() throws NegocioException {
        List<SucursalDTO> sucursales = sucursalesBO.obtenerTodos();
        if(sucursales == null) {
                throw new NegocioException("La lista de sucursales no existe");
        }
        if(sucursales.isEmpty()) {
           throw new NegocioException("La lista de generos esta vacia");
        }
        
        return sucursales;

    }
    
    @Override
    public SucursalDTO obtenerSucursalSeleccionada(Long idSucursal) throws NegocioException {
        if(idSucursal == null) {
          throw new NegocioException("La sucursal seleccionada no existe");
        }
        
        return sucursalesBO.obtenerSucursalPorId(idSucursal);
    }

    @Override
    public List<TipoDTO> obtenerTipos() throws NegocioException {
        List<TipoDTO> tipos= tiposBO.obtenerTipos();
        if(tipos == null) {
                throw new NegocioException("La lista de tipos no existe");
        }
        if(tipos.isEmpty()) {
           throw new NegocioException("La lista de tipos esta vacia");
        }
             
        return tipos;

    }
    
     @Override
     public Integer obtenerStockPorSucursal(Long idProducto, Long idSucursal) throws NegocioException {
        try {
            ProductoDTO producto = productosBO.obtenerProductoPorId(idProducto);
            if(producto.getSucursal() != null && producto.getSucursal().getIdSucursal().equals(idSucursal)) { 
                return producto.getStock();
            }  
        } catch (NegocioException ex) {
            throw new NegocioException("Error al obtener el producto: " + ex.getMessage());
        }
        return 0;
     }
}
