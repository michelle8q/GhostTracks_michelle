package itson.org.ghosttracksventaenlinea.fachada;

import itson.org.ghosttracks.dtos.AdministradorDTO;
import itson.org.ghosttracks.dtos.CarritoDTO;
import itson.org.ghosttracks.dtos.ClienteDTO;
import itson.org.ghosttracks.dtos.ItemCarritoDTO;
import itson.org.ghosttracks.dtos.PedidoDTO;
import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.enums.EstadoPedidoDTO;
import itson.org.ghosttracks.negocio.interfaces.IAdministradoresBO;
import itson.org.ghosttracks.negocio.interfaces.ICarritoBO;
import itson.org.ghosttracks.negocio.interfaces.IClientesBO;
import itson.org.ghosttracks.negocio.interfaces.IPedidosBO;
import itson.org.ghosttracks.negocio.interfaces.IProductosBO;
import itson.org.ghosttracks.negocio.objetosNegocio.AdministradoresBO;
import itson.org.ghosttracks.negocio.objetosNegocio.CarritoBO;
import itson.org.ghosttracks.negocio.objetosNegocio.ClientesBO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import itson.org.ghosttracks.negocio.objetosNegocio.PedidosBO;
import itson.org.ghosttracks.negocio.objetosNegocio.ProductosBO;
import itson.org.ghosttracksventaenlinea.interfaces.IVentaEnLinea;
import java.util.List;

/**
 *
 * @author nafbr
 */
    public class VentaEnLineaFachada implements IVentaEnLinea{
    private final IPedidosBO pedidosBO;
    private final IProductosBO productosBO;
    private final IClientesBO clientesBO;
    private final ICarritoBO carritoBO;
    private final IAdministradoresBO administradorBO;

    public VentaEnLineaFachada() {
        this.productosBO = new ProductosBO();
        this.clientesBO = new ClientesBO();
        this.carritoBO = new CarritoBO();
        this.pedidosBO = new PedidosBO();
        this.administradorBO = new AdministradoresBO();
    }

    @Override
    public List<ProductoDTO> obtenerCatalogo() throws Exception {
        return productosBO.obtenerTodos();
    }

    @Override
    public ProductoDTO consultarDetalleProducto(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new NegocioException("El ID de producto proporcionado no es válido.");
        }
        return productosBO.obtenerProductoPorId(id);
    }
    
    @Override
    public ClienteDTO consultarPerfilCliente(Long idCliente, String nombre) throws Exception {
        if (idCliente == null) {
            throw new NegocioException("Administrador no encontrado");
        
        }
        if (nombre == null) {
            throw new NegocioException("Cliente no encontrado");
        
        }
        return clientesBO.obtenerClientePorId(idCliente);
    }
    
    @Override
    public AdministradorDTO consultarPerfilAdministrador(Long idEmpleado, String nombre) throws Exception {
        if (idEmpleado == null) {
            throw new NegocioException("Administrador no encontrado");
        
        }
        if (nombre == null) {
            throw new NegocioException("Administrador no encontrado");
        
        }
        return administradorBO.obtenerAdministradorPorId(idEmpleado);
    }
    
    @Override
    public CarritoDTO agregarAlCarrito(CarritoDTO carritoActual, ProductoDTO producto, Integer cantidad) throws Exception {
        if (carritoActual == null) {
            carritoActual = new CarritoDTO();
        }
        
        if (producto == null || cantidad == null || cantidad <= 0) {
            throw new NegocioException("Producto o cantidad inválidos al intentar agregar al carrito.");
        }
        
        if (producto.getStock() == null || cantidad > producto.getStock()) {
            throw new NegocioException("No hay suficiente stock para el producto: " + producto.getNombre());
        }
        
        return carritoBO.agregarProducto(carritoActual, producto, cantidad);
    }
    
    @Override
    public CarritoDTO eliminarDelCarrito(CarritoDTO carrito, Long idProducto) throws Exception {
        if (carrito == null || carrito.getProductos().isEmpty()) {
            throw new NegocioException("No hay productos en el carrito para eliminar.");
        }
         
        return carritoBO.eliminarProducto(carrito, idProducto);
    }
    
    @Override
    public void calcularTotalesPedido(PedidoDTO pedidoDto) {
        double subtotal = 0.0;

        for (ItemCarritoDTO item : pedidoDto.getProductos()) {
            double subtot = item.getCantidad() *item.getProductoSeleccionado().getPrecio();
            item.setSubtotal(subtot);
            subtotal += subtot;
        }

        double envio = 150.0;
        double total = subtotal + envio;
        pedidoDto.setSubtotal(subtotal);
        pedidoDto.setCostoEnvio(envio);
        pedidoDto.setTotal(total);
    }
  
    @Override
    public PedidoDTO confirmarCompra(PedidoDTO pedidoDto) throws Exception {
        if (pedidoDto == null || pedidoDto.getProductos() == null || pedidoDto.getProductos().isEmpty()) {
            throw new NegocioException("No se puede procesar un pedido vacío.");
        }
        
        calcularTotalesPedido(pedidoDto);
        
        return pedidosBO.generarPedido(pedidoDto);
    }
    
    @Override
        public PedidoDTO actualizarEstadoPedido(Long idPedido, EstadoPedidoDTO nuevoEstado) throws Exception {
        if (idPedido == null || idPedido <= 0) {
            throw new NegocioException("El ID del pedido no es válido.");
        }
        
        if (nuevoEstado == null) {
            throw new NegocioException("Debe proporcionar un estado válido para actualizar.");
        }
        
        return pedidosBO.actualizarEstadoPedido(idPedido, nuevoEstado);
    }
        
    @Override
    public List<PedidoDTO> obtenerTodosLosPedidos() throws Exception {
        return pedidosBO.obtenerTodosLosPedidos();
    }
    
    @Override
    public ProductoDTO consultarProducto(String nombre) throws NegocioException {
        if (nombre == null || nombre.trim().isEmpty()) {
            return null;
        }
        
        return productosBO.buscarProductoPorNombre(nombre.trim());
    }

    
}
