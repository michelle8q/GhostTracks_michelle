package itson.org.ghosttracks.daos;

import itson.org.ghosttracks.entidades.Producto;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import java.util.List;

/**
 *
 * @author emyla
 */
public interface IProductosDAO {
    
    public abstract List<Producto> obtenerProductos() throws PersistenciaException;
    
    public abstract Producto obtenerProductoPorId(Long idProducto) throws PersistenciaException;
    
    public abstract Producto agregarProducto(Producto producto) throws PersistenciaException;
    
    public abstract Producto buscarProductoPorNombre(String nombre) throws PersistenciaException;
    
    public abstract Producto actualizarProducto(Producto producto) throws PersistenciaException;
    
    public abstract Producto eliminarProducto(Producto producto) throws PersistenciaException;
    
}
