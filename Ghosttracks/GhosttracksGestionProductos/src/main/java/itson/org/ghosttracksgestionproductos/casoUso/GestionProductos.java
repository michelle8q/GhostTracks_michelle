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
                if (productoGuardado.getNombre().equalsIgnoreCase(producto.getNombre()) && 
                        productoGuardado.getArtista().equalsIgnoreCase(producto.getArtista())) {
                    return true;
                }
            }

        } catch (NegocioException ex) {
            throw new NegocioException("Error al obtener los productos: " + ex.getMessage());
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
    public List<ProductoDTO> obtenerCatalogoProductosPorFiltro(FiltroProductoDTO filtro) throws NegocioException {
        try {
            List<ProductoDTO> productos = productosBO.obtenerTodos();
            if (filtro == null) {
                return productos;
            }
            List<ProductoDTO> productosConFiltro = new ArrayList<>();
            for (ProductoDTO producto : productos) {
                boolean existe = false;

                if (filtro.getNombre() != null && !filtro.getNombre().trim().isEmpty()) {
                    if (producto.getNombre() != null && producto.getNombre().toLowerCase().contains(filtro.getNombre().toLowerCase())) {
                        existe = true;
                    }
                }

                if (!existe && filtro.getArtista() != null && !filtro.getArtista().trim().isEmpty()) {
                    if (producto.getArtista() != null && producto.getArtista().toLowerCase().contains(filtro.getArtista().toLowerCase())) {
                        existe = true;
                    }
                }

                if (!existe && filtro.getGenero() != null) {
                    if (producto.getGenero() != null && producto.getGenero().getNombreGenero().toLowerCase().contains(filtro.getGenero().getNombreGenero().toLowerCase())) {
                        existe = true;
                    }
                }
                if (!existe && filtro.getTipo() != null) {
                    if (producto.getTipoProducto()!= null && producto.getTipoProducto().getNombreTipo().toLowerCase().contains(filtro.getTipo().getNombreTipo().toLowerCase())) {
                        existe = true;
                    }
                }
                
                if (existe) {
                    productosConFiltro.add(producto);
                }
                
            }
            
            return productosConFiltro;

        } catch (NegocioException e) {
            throw new NegocioException("Error al obtener productos filtrados: " + e.getMessage());
        }
    }
    @Override
    public List<CatalogoProductosDTO> obtenerCatalogoProductosCompleto() throws NegocioException {
        List<ProductoDTO> productos = productosBO.obtenerTodos();
        List<CatalogoProductosDTO> catalogo = new ArrayList<>();

        for (ProductoDTO producto : productos) {
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
        return catalogo;
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO producto) throws NegocioException {
        return productosBO.actualizarProducto(producto);
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO producto) throws NegocioException {
        if (validarProductoExistente(producto)) {
            throw new NegocioException("El producto ya existe");
        }
        return productosBO.crearProducto(producto);
    }
    
    @Override
    public ProductoDTO eliminarProducto(ProductoDTO producto) throws NegocioException {
        return productosBO.eliminarProducto(producto);
    }

    @Override
    public ProductoDTO obtenerDetallesProductoSeleccionado(Long idProducto) throws NegocioException {
        return productosBO.obtenerProductoPorId(idProducto);
    }

    @Override
    public List<GeneroDTO> obtenerGeneros() throws NegocioException {
        return generosBO.obtenerGeneros();
    }

    @Override
    public List<SucursalDTO> obtenerSucursales() throws NegocioException {
        return sucursalesBO.obtenerTodos();

    }
    
    @Override
    public SucursalDTO obtenerSucursalSeleccionada(Long idSucursal) throws NegocioException {
        return sucursalesBO.obtenerSucursalPorId(idSucursal);
    }

    @Override
    public List<TipoDTO> obtenerTipos() throws NegocioException {
        return tiposBO.obtenerTipos();
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
