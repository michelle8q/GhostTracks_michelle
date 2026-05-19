package itson.org.ghosttracks.test;

import itson.org.ghosttracks.entidades.Direccion;
import itson.org.ghosttracks.entidades.Genero;
import itson.org.ghosttracks.entidades.ImagenProducto;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import itson.org.ghosttracks.entidades.Producto;
import itson.org.ghosttracks.entidades.Sucursal;
import itson.org.ghosttracks.enums.EstadoProducto;
import itson.org.ghosttracks.enums.TipoProducto;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import itson.org.ghosttracks.mocks.ProductosMockDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pruebas unitarias para ProductosMockDAO.
 * @author emyla
 */
public class ProductosMockDAOTest {
    
    private ProductosMockDAO dao;

    @BeforeEach
    public void init() {
        this.dao = new ProductosMockDAO();
    }

    public ProductosMockDAOTest() {
    }

    @Test
    public void testObtenerTodosHappyPath() {
        // Ejecución
        assertDoesNotThrow(() -> {
            List<Producto> listaProductos = dao.obtenerProductos();
            
            // Verificación
            assertNotNull(listaProductos);
            assertEquals(3, listaProductos.size()); 
        });
    }

    @Test
    public void testBuscarPorIdHappyPath() {
        // Setup
        Long idProductoBuscado = 1L; 
        
        // Ejecución 
        assertDoesNotThrow(() -> {
            Producto producto = dao.obtenerProductoPorId(idProductoBuscado);
            
            // Verificación
            assertNotNull(producto);
            assertEquals(idProductoBuscado, producto.getIdProducto());
            assertEquals("Abbey Road", producto.getNombre());
        });
    }

    @Test
    public void testBuscarPorIdNoExiste() {
        // Setup
        Long idProductoFake = 99L; 
        
        // Ejecución y Verificación
        assertThrows(PersistenciaException.class, () -> {
            dao.obtenerProductoPorId(idProductoFake);
        });
    }

    @Test
    public void testBuscarPorIdNulo() {
        // Setup
        Long idNulo = null;
        
        // Ejecución y Verificación
        assertThrows(PersistenciaException.class, () -> {
            dao.obtenerProductoPorId(idNulo);
        });
    }

    @Test
    public void testAgregarHappyPath() {
        // Setup
        Producto nuevoProducto = new Producto(
                null, 
                "Random Access Memories", 
                new ImagenProducto("ram.jpg"), 
                TipoProducto.VINILO, 
                "Daft Punk", 
                new Genero("Electronic"), 
                new ArrayList<>(Arrays.asList("Give Life Back to Music", "Get Lucky")), 
                550.00, 
                10, 
                EstadoProducto.DISPONIBLE,
                new Sucursal(new Direccion("Morelos", "Norte","456", "Hermosillo",  "83100", "Sonora"),
                "6629876543",
                "Ghosttracks Norte")
        );
        
        // Ejecución
        assertDoesNotThrow(() -> {
            Producto productoGuardado = dao.agregarProducto(nuevoProducto);
            
            // Verificación
            assertNotNull(productoGuardado.getIdProducto());
            assertEquals(4L, productoGuardado.getIdProducto()); 
            assertEquals(nuevoProducto.getNombre(), productoGuardado.getNombre());
            
            // Verificamos que se añadió a la lista general
            assertEquals(4, dao.obtenerProductos().size());
        });
    }

    @Test
    public void testAgregarProductoNulo() {
        // Setup
        Producto productoNulo = null; // El input ahora es DTO
        
        // Ejecución y Verificación
        assertThrows(PersistenciaException.class, () -> {
            dao.agregarProducto(productoNulo);
        });
    }

    @Test
    public void testAgregarProductoNombreVacio() {
        // Setup
        // Creamos un DTO inválido para probar la validación de negocio
        Producto productoInvalido = new Producto(
                null, 
                "", // Nombre vacío intencionalmente
                new ImagenProducto("img.jpg"), 
                TipoProducto.CD, 
                "Artista", 
                new Genero("Pop"), 
                new ArrayList<>(), 
                100.00, 
                5, 
                EstadoProducto.DISPONIBLE,
                new Sucursal(new Direccion("Miguel Alemán","Centro","123","Ciudad Obregón","85000", "Sonora"),
                "6441234567","Ghosttracks Centro")
        );
        
        // Ejecución y Verificación
        assertThrows(PersistenciaException.class, () -> {
            dao.agregarProducto(productoInvalido);
        });
    }
}