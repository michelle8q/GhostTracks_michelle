/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.fachadas;

import itson.ghosttracks.interfaces.IPersistencia;
import itson.org.ghosttracks.daos.IAdministradoresDAO;
import itson.org.ghosttracks.daos.IClientesDAO;
import itson.org.ghosttracks.daos.IGenerosDAO;
import itson.org.ghosttracks.daos.IPedidosDAO;
import itson.org.ghosttracks.daos.IProductosDAO;
import itson.org.ghosttracks.daos.ISucursalesDAO;
import itson.org.ghosttracks.daos.ITiposDAO;
import itson.org.ghosttracks.entidades.Administrador;
import itson.org.ghosttracks.entidades.Cliente;
import itson.org.ghosttracks.entidades.Genero;
import itson.org.ghosttracks.entidades.Pedido;
import itson.org.ghosttracks.entidades.Producto;
import itson.org.ghosttracks.entidades.Sucursal;
import itson.org.ghosttracks.entidades.TipoProducto;
import itson.org.ghosttracks.enums.EstadoPedido;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import itson.org.ghosttracks.mocks.FactoryDAO;
import itson.org.ghosttracks.mocks.MockDAOFactory;
import java.util.List;

/**
 *
 * @author cinca
 */
public class PersistenciaFachada implements IPersistencia {
    
    private static PersistenciaFachada instance; 
    private final FactoryDAO factory;
    
    private IProductosDAO productoDao;
    private ISucursalesDAO sucursalDao;
    private IGenerosDAO generoDao;
    private ITiposDAO tiposDao;
    private IPedidosDAO pedidosDao;
    private IClientesDAO clientesDao;
    private IAdministradoresDAO adminDao; 

    private PersistenciaFachada() {
        this.factory = new MockDAOFactory();
        this.productoDao = factory.crearProductosDAO();
        this.sucursalDao = factory.crearSucursalesDAO();
        this.generoDao = factory.crearGenerosDAO();
        this.tiposDao = factory.crearTiposDAO();
        this.pedidosDao = factory.crearPedidosDAO();
        this.clientesDao = factory.crearClientesDAO();
        this.adminDao = factory.crearAdministradoresDAO();
    }
    
    public static PersistenciaFachada getInstance() {
        if(instance==null) {
            instance =new PersistenciaFachada();
        }
        return instance;
    }
    

    @Override
    public Producto agregarProducto(Producto producto) throws PersistenciaException {
        
        try {
            return productoDao.agregarProducto(producto);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }

    }
    @Override
    public Producto actualizarProducto(Producto producto) throws PersistenciaException{
        try {
            return productoDao.actualizarProducto(producto);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }
 
    }
    @Override
    public Producto eliminarProducto(Producto producto) throws PersistenciaException{
        try {
            return productoDao.eliminarProducto(producto);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }
  
    }
    @Override
    public Producto obtenerProductoPorId(Long idProducto) throws PersistenciaException{
        try {
            return productoDao.obtenerProductoPorId(idProducto);
        } catch (PersistenciaException ex) {
             throw new PersistenciaException("El error fue" + ex.getMessage());
        }
        
    }
    @Override
    public List<Producto> obtenerProductos() throws PersistenciaException {
        try {
            return productoDao.obtenerProductos();
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }
      
        
    }
    
    @Override
    public Producto buscarProductoPorNombre(String nombre) throws PersistenciaException {
          try {
            return productoDao.buscarProductoPorNombre(nombre);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }
    }
    
    @Override
    public Sucursal obtenerSucursalPorId(Long idProducto)throws PersistenciaException {
        try {
            return sucursalDao.obtenerSucursalPorId(idProducto);
        } catch (PersistenciaException ex) {
             throw new PersistenciaException("El error fue" + ex.getMessage());
        }        
    }
    
    @Override
    public List<Sucursal> obtenerSucursales() throws PersistenciaException {
        try {
            return sucursalDao.obtenerSucursales();
        } catch (PersistenciaException ex) {
             throw new PersistenciaException("El error fue" + ex.getMessage());
        }
        
    }
    
    @Override
    public Genero obtenerGeneroPorId(Long idGenero)throws PersistenciaException {
        try {
            return generoDao.obtenerGeneroPorId(idGenero);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }
      
        
    }
    @Override
    public List<Genero> obtenerGeneros() throws PersistenciaException {
        try {
            return generoDao.obtenerGeneros();
        } catch (PersistenciaException ex) {
             throw new PersistenciaException("El error fue" + ex.getMessage());
        }
     
        
    }
    
    @Override
    public TipoProducto obtenerTipoPorId(Long IdTipo) throws PersistenciaException {
        try {
            return tiposDao.obtenerTipoPorId(IdTipo);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }
      
        
    }
    
    @Override
    public List<TipoProducto> obtenerTipos() throws PersistenciaException {
        try {
            return tiposDao.obtenerTipos();
        } catch (PersistenciaException ex) {
             throw new PersistenciaException("El error fue" + ex.getMessage());
        }
        
    }
    
    @Override
    public Pedido guardarPedido(Pedido pedido) throws PersistenciaException {
        pedidosDao.guardarPedido(pedido);
        return pedido;
    }
    
    @Override
    public Pedido actualizarEstado(Long idPedido, EstadoPedido nuevoEstado) throws PersistenciaException {
        try {
            return pedidosDao.actualizarEstado(idPedido, nuevoEstado);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }

    }
    
    @Override
    public List<Pedido> consultarTodos() throws PersistenciaException {
        try {
            return pedidosDao.consultarTodos();
        } catch (PersistenciaException ex) {
          throw new PersistenciaException("El error fue" + ex.getMessage());
        }
     
    }
    @Override
    public Cliente buscarClientePorNombre(String nombre) throws PersistenciaException {
        try {
            return clientesDao.buscarPorNombre(nombre);
        } catch (PersistenciaException ex) {
             throw new PersistenciaException("El error fue" + ex.getMessage());
        }
  
    }
    @Override
    public Cliente buscarClientePorId(Long idCliente) throws PersistenciaException {
        try {
            return clientesDao.buscarPorId(idCliente);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }
  
    }
    
    @Override
    public Administrador buscarAdminPorId(Long idUsuario) throws PersistenciaException {
        try {
            return adminDao.buscarPorId(idUsuario);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }
      
        
    }
    
    @Override
    public Administrador buscarPorIdEmpleado(Long idEmpleado) throws PersistenciaException {
        try {
            return adminDao.buscarPorIdEmpleado(idEmpleado);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }
     
        
    }
    
    @Override
    public Administrador buscarAdminPorNombre(String nombre) throws PersistenciaException {
        try {
            return adminDao.buscarPorNombre(nombre);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("El error fue" + ex.getMessage());
        }
        
    }
}
