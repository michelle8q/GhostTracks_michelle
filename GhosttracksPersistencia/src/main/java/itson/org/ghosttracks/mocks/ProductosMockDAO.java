package itson.org.ghosttracks.mocks;

import itson.org.ghosttracks.daos.IProductosDAO;
import itson.org.ghosttracks.entidades.Genero;
import itson.org.ghosttracks.entidades.ImagenProducto;
import itson.org.ghosttracks.entidades.Producto;
import itson.org.ghosttracks.entidades.Sucursal;
import itson.org.ghosttracks.enums.EstadoProducto;
import itson.org.ghosttracks.enums.TipoProducto;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cinca
 */
public class ProductosMockDAO implements IProductosDAO {
    private SucursalesMockDAO sucursal;

    private static final Logger LOGGER = Logger.getLogger(ProductosMockDAO.class.getName());
    
    private static List<Producto> productosDB;
    private Long contadorId = 1L;

    public ProductosMockDAO() {
        this.sucursal = new SucursalesMockDAO();
        this.productosDB = new ArrayList<>();
        cargarDatosDummy();
 
    }

    /**
     * Carga de datos iniciales adaptada a ProductoDTO
     */
    private void cargarDatosDummy() {
        try {
            Sucursal sucursal1 = sucursal.obtenerSucursalPorId(1L);
        
        
        Producto producto1 = new Producto(
                1L,                       
                "Abbey Road",             
                new ImagenProducto("C:\\Users\\cinca\\Downloads\\abbey_road.jpg"),         
                TipoProducto.VINILO,       
                "The Beatles",            
                new Genero("Rock"),                   
                Arrays.asList("Come Together", "Something", "Maxwell's Silver Hammer", "Oh! Darling", "Octopus's Garden", "I Want You", "Here Comes the Sun"), // setlist
                650.00,                  
                15,                       
                EstadoProducto.DISPONIBLE,
                sucursal1     
        );
        
        this.productosDB.add(producto1);
        contadorId++;

        Producto producto2 = new Producto(
                2L, 
                "Thriller", 
                new ImagenProducto("C:\\Users\\cinca\\Downloads\\thriller.jpg"), 
                TipoProducto.CD,         
                "Michael Jackson", 
                new Genero("Pop"), 
                Arrays.asList("Wanna Be Startin' Somethin'", "Baby Be Mine", "The Girl Is Mine", "Thriller", "Beat It", "Billie Jean", "Human Nature"),
                350.00, 
                20, 
                EstadoProducto.DISPONIBLE,
                sucursal1
        );
        this.productosDB.add(producto2);
        contadorId++;

        Producto producto3 = new Producto(
                3L, 
                "The Dark Side of the Moon", 
                 new ImagenProducto("C:\\Users\\cinca\\Downloads\\dark_side.webp"), 
                TipoProducto.CASSETTE,    
                "Pink Floyd", 
                new Genero("Rock Progresivo"), 
                Arrays.asList("Speak to Me", "Breathe (In the Air)", "On the Run", "Time", "The Great Gig in the Sky", "Money", "Us and Them"), 
                200.00, 
                5, 
                EstadoProducto.DISPONIBLE,
                sucursal1
        );
        this.productosDB.add(producto3);
        contadorId++;
        
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductosMockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Producto> obtenerProductos() throws PersistenciaException {
        try {
            return new ArrayList<>(this.productosDB);
        } catch (Exception e) {
            LOGGER.severe("Error crítico e inesperado al intentar obtener todos los productos" + e.getMessage());
            throw new PersistenciaException("Ocurrió un error al consultar el catálogo de productos.", e);
        }
    }
    
    @Override
    public Producto obtenerProductoPorId(Long idProducto) throws PersistenciaException {
        if (idProducto == null) {
            throw new PersistenciaException("El ID del producto a buscar no puede ser nulo");
        }

        try {
            for (Producto producto : productosDB) {
                if (producto.getIdProducto().equals(idProducto)) {
                    return producto;
                }
            }
            throw new PersistenciaException("Producto no encontrado con el ID: " + idProducto);

        } catch (PersistenciaException e) {
            throw e;

        } catch (Exception e) {
            LOGGER.severe("Error crítico e inesperado al buscar el producto por ID: " + e.getMessage());
            throw new PersistenciaException("Error inesperado al intentar buscar el producto.", e);
        }
    }
    
    

    @Override
    public Producto agregarProducto(Producto nuevoProducto) throws PersistenciaException {
        if (nuevoProducto == null) {
            throw new PersistenciaException("No se puede agregar un producto nulo.");
        }
        if (nuevoProducto.getNombre() == null || nuevoProducto.getNombre().trim().isEmpty()) {
            throw new PersistenciaException("El producto debe tener un nombre válido.");
        }
        
        if (nuevoProducto.getArtista() == null || nuevoProducto.getArtista().trim().isEmpty()) {
            throw new PersistenciaException("El producto debe tener un artista válido.");
        }
        
        if (nuevoProducto.getPrecio() <= 0) {
           throw new PersistenciaException("El producto debe tener un precio válido.");
        }
        

        try {
            Producto nuevaEntidad = new Producto(
            contadorId++, 
            nuevoProducto.getNombre(),
            nuevoProducto.getImgProducto(),
            nuevoProducto.getTipo(),
            nuevoProducto.getArtista(),
            nuevoProducto.getGenero(),
            nuevoProducto.getSetlist(),
            nuevoProducto.getPrecio(),
            nuevoProducto.getStock(),
            nuevoProducto.getEstado(),
            nuevoProducto.getSucursal()
        );

        this.productosDB.add(nuevaEntidad);
        return nuevaEntidad;
            
        } catch (Exception e) {
            LOGGER.severe("Error crítico e inesperado al intentar agregar un nuevo producto" + e.getMessage());
            throw new PersistenciaException("No se pudo guardar el producto debido a un error interno.", e);
        }
    }
    
    @Override
    public Producto buscarProductoPorNombre(String nombre) throws PersistenciaException {
        if (nombre == null) {
            throw new PersistenciaException("El nombre del producto a buscar no puede ser nulo");
        }

        try {
            for (Producto producto : productosDB) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    return producto;
                }
            }
            throw new PersistenciaException("Producto no encontrado con el nombre: " + nombre);

        } catch (PersistenciaException e) {
            throw e;

        } catch (Exception e) {
            LOGGER.severe("Error crítico e inesperado al buscar el producto por nombre: " + e.getMessage());
            throw new PersistenciaException("Error inesperado al intentar buscar el producto.", e);
        }     
    
    }
    
    @Override
    public Producto actualizarProducto(Producto producto) throws PersistenciaException {
         if (producto == null) {
            throw new PersistenciaException("No se puede agregar un producto nulo.");
        }
         
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new PersistenciaException("El producto debe tener un nombre valido.");
        }
        
        if (producto.getArtista() == null || producto.getArtista().trim().isEmpty()) {
            throw new PersistenciaException("El producto debe tener un artista valido.");
        }
        
        if (producto.getPrecio() <= 0) {
           throw new PersistenciaException("El producto debe tener un precio valido.");
        }
        
        try {
            for(int i = 0; i  < productosDB.size(); i++) {
                Producto productoActual = productosDB.get(i);
                if(productoActual.getIdProducto().equals(producto.getIdProducto())) {  
                    productosDB.set(i, producto);  
                    return producto;
                }
            }
            
            throw new PersistenciaException("No se encontro el producto con id: " + producto.getIdProducto());

        } catch (PersistenciaException e) {
            throw e;
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar: " + e.getMessage());
        }
    }
        
    
    @Override
    public Producto eliminarProducto(Producto producto) throws PersistenciaException {
         if (producto == null) {
            throw new PersistenciaException("No se puede eliminar un producto nulo.");
        }
         try {
            for(int i = 0; i  < productosDB.size(); i++) {
                Producto productoActual = productosDB.get(i);
                
                if(productoActual.getIdProducto().equals(producto.getIdProducto())) {
                    Producto eliminado = productosDB.remove(i);
                    return eliminado;
                }
            }
            throw new PersistenciaException("No se encontro el producto");

        } catch (PersistenciaException e) {
            throw e;
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar: " + e.getMessage());
        }
    }
}
