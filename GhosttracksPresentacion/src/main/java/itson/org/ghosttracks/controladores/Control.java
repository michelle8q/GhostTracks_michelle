package itson.org.ghosttracks.controladores;

import itson.org.ghosttracks.dtos.AdministradorDTO;
import java.util.ArrayList;
import java.util.List;

import itson.org.ghosttracks.dtos.CarritoDTO;
import itson.org.ghosttracks.dtos.CatalogoProductosDTO;
import itson.org.ghosttracks.dtos.ClienteDTO;
import itson.org.ghosttracks.dtos.ContactoDTO;
import itson.org.ghosttracks.dtos.DatosPagoDTO;
import itson.org.ghosttracks.dtos.DireccionEntregaDTO;
import itson.org.ghosttracks.dtos.FiltroProductoDTO;
import itson.org.ghosttracks.dtos.PedidoDTO;
import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import itson.org.ghosttracks.presentacion.cliente.PantallaCarrito;
import itson.org.ghosttracks.presentacion.cliente.PantallaInicioCliente;
import itson.org.ghosttracks.presentacion.cliente.PantallaPedidosProceso;
import itson.org.ghosttracks.utilerias.pnlResumenPedido;
import itson.org.ghosttracksventaenlinea.fachada.VentaEnLinea;
import itson.org.ghosttracksventaenlinea.interfaces.IVentaEnLinea;
import itson.org.ghosttracks.negocio.objetosNegocio.pagos.GestorPagosStrategy;
import itson.org.ghosttracks.enums.TipoPago;
import itson.org.ghosttracks.infrastructura.pagos.MercadoPagoStrategy;
import itson.org.ghosttracks.infrastructura.pagos.TarjetaDebitoStrategy;
import itson.org.ghosttracks.presentacion.VentanaPrincipal;
import itson.org.ghosttracks.presentacion.administrador.PantallaVentas;
import itson.org.ghosttracks.presentacion.cliente.PantallaFormularioEntrega;
import itson.org.ghosttracks.presentacion.cliente.PantallaSeguimientoPedido;
import itson.org.ghosttracks.presentacion.cliente.PantallaSeleccionMetodoDePago;
import itson.org.ghosttracks.presentacion.cliente.PantallaVistaProducto;
import itson.org.ghosttracks.presentacion.gestionProductos.PantallaCatalogo;
import itson.org.ghosttracks.presentacion.gestionProductos.PantallaDetallesProducto;
import itson.org.ghosttracks.presentacion.gestionProductos.PantallaFormularioAgregarProducto;
import itson.org.ghosttracks.presentacion.panelLogin;
import itson.org.ghosttracks.utilerias.PanelHeader;
import itson.org.ghosttracks.utilerias.pnlMenuLateral;
import itson.org.ghosttracks.utilerias.pnlMenuLateralAdmin;
import itson.org.ghosttracksgestionproductos.casoUso.GestionProductos;
import itson.org.ghosttracksgestionproductos.interfaces.IGestionProductos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Cinca
 */
public class Control {
    private static Control instancia;
    
    private final IVentaEnLinea ventaFachada;
    private final IGestionProductos gestionProductos;
    private final GestorPagosStrategy gestorPagos;
    private VentanaPrincipal ventana;

    private CarritoDTO carrito;
    private PedidoDTO pedidoDTO;

    private ClienteDTO cliente;
    private AdministradorDTO admin;
    private String rol;
    
    private Control() {
        this.ventaFachada = new VentaEnLinea();
        this.gestionProductos = new GestionProductos();
        this.gestorPagos = new GestorPagosStrategy();
        this.ventana = new VentanaPrincipal();
        this.pedidoDTO = new PedidoDTO();
        this.carrito = new CarritoDTO();
 
    }
    
    public static Control getInstancia() {
        if (instancia == null) {
            instancia = new Control();
        }

        return instancia;
    }
    
    public VentanaPrincipal obtenerVentana() {
        return ventana;
    }
    
    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }
     
    public void irLogin() {
        ventana.limpiarMenuYHeader();
        ControlLogin ctrl = new ControlLogin(this);
        panelLogin vista = new panelLogin(ctrl);
        ventana.cambiarPantalla(vista);
    }
    
   
    public void iniciarSesionClienteExitoso(ClienteDTO cliente) {
        this.cliente = cliente;
        this.rol = "Cliente";
        ventana.fijarMenuLateral(new pnlMenuLateral(this));
        ventana.fijarHeader(new PanelHeader(this, cliente, null, rol));   
    }
       
    public void iniciarSesionAdminExitoso(AdministradorDTO admin) {
        this.admin = admin;
        this.rol = "Administrador";
        ventana.fijarMenuLateral(new pnlMenuLateralAdmin(this));
        ventana.fijarHeader(new PanelHeader(this,null, admin,rol));  
    }
    
     public void irInicioCliente() {
        PantallaInicioCliente vista = new PantallaInicioCliente(this);
        ventana.cambiarPantalla(vista);
    }
     
    public void comenzarProcesoPedido() {
        CarritoDTO carrito = this.carrito;
        this.pedidoDTO = new PedidoDTO();
        this.pedidoDTO.setProductos(carrito.getProductos());
        
        System.out.println("Productos en pedido: " + pedidoDTO.getProductos().size());
        
        procesarPedidoMetodoPago();
    }
    
    public void procesoPedidoEntrega() {
        PantallaFormularioEntrega vista = new PantallaFormularioEntrega(this);
        ventana.cambiarPantalla(vista);
    }
    
    public void procesarPedidoMetodoPago() {
        PantallaSeleccionMetodoDePago vista = new PantallaSeleccionMetodoDePago(this);
        ventana.cambiarPantalla(vista);
    }
    
    public void volverACatalogo() {
        irInicioCliente();
    }
    
    public void mostrarSeguimientoPedido() {
        PantallaSeguimientoPedido vista = new PantallaSeguimientoPedido(this, pedidoDTO);
        ventana.cambiarPantalla(vista);
    }
    
    public void irEditarPago(PedidoDTO pedido) {
        PantallaSeleccionMetodoDePago vista = new PantallaSeleccionMetodoDePago(this);
        ventana.cambiarPantalla(vista);
    }
    
    // Pantallas
    public void llenarTablaCarrito(PantallaCarrito vista){
        vista.llenarTabla(carrito);
    }
    
    public void llenarCatalogo(PantallaInicioCliente vista) {
        try {
            List<ProductoDTO> productos = ventaFachada.obtenerCatalogo();
            vista.cargarCatalogo(productos);
        } catch (Exception ex) {
            mostrarMensaje("Error al llenar el catalogo de productos.", true);
        }
    }
    
    public void mostrarDetalleProducto(ProductoDTO productoSeleccionado) {
        PantallaVistaProducto vista = new PantallaVistaProducto(this, productoSeleccionado);
        ventana.cambiarPantalla(vista);
    }
    

    public void agregarDireccionPedido(DireccionEntregaDTO dto) {
        pedidoDTO.setDireccionEntrega(dto);
    }
    
    public void agregarContactoPedido(ContactoDTO dto) {
        pedidoDTO.setContacto(dto);
    }
    
    public void agregarMetodoPago(DatosPagoDTO dto) {
        pedidoDTO.setDatosPago(dto);
    }
    
    public void procesarPedido() {
        try {   
            DireccionEntregaDTO direccionOriginal = pedidoDTO.getDireccionEntrega();
            ContactoDTO contactoOriginal = pedidoDTO.getContacto();
            DatosPagoDTO datosPagoOriginal = pedidoDTO.getDatosPago();
            
            
             if (datosPagoOriginal != null && datosPagoOriginal.getTipoPago()== TipoPago.STRIPE) {
                gestorPagos.setEstrategia(new TarjetaDebitoStrategy());
            } else {
                gestorPagos.setEstrategia(new MercadoPagoStrategy());
            }
            
            gestorPagos.ejecutarCobro(pedidoDTO.getTotal());
            
            this.pedidoDTO = ventaFachada.confirmarCompra(pedidoDTO);
            pedidoDTO.setDireccionEntrega(direccionOriginal);
            pedidoDTO.setContacto(contactoOriginal);
            pedidoDTO.setDatosPago(datosPagoOriginal);

            mostrarMensaje("Pedido registrado exitosamente.", false);
        } catch (Exception ex) {
            mostrarMensaje("No ha sido posible realizar el pedido.", true);
        }
        
    }
    
    public void agregarProductoCarrito(ProductoDTO producto, Integer cantidad) {
        try {
            ventaFachada.agregarAlCarrito(carrito, producto, cantidad);
        } catch (Exception ex) {
            mostrarMensaje("No ha sido posible agregar el producto al carrito.", true);
        }
    }
    
    public void eliminarProductoCarrito(Long idProducto) {
        try {
            ventaFachada.eliminarDelCarrito(carrito, idProducto);
        } catch (Exception ex) {
            mostrarMensaje("Error al eliminar el producto del carrito.", true);
        }
    }
    
    public void limpiarCarrito(CarritoDTO carrito) {
        try {
            carrito.getProductos();
            ventaFachada.limpiarProductosCarrito(carrito);
            
        } catch (Exception ex) {
            mostrarMensaje("Error al eliminar el carrito.", true);
        }
    }
    
    public void llenarResumenPedido(pnlResumenPedido panel) {
            panel.cargarProductos(this.carrito);
        
    }
    
    
    public ProductoDTO consultarProducto(String nombre) throws NegocioException {
        ProductoDTO prod = ventaFachada.consultarProducto(nombre);
        if (prod != null) {
            mostrarDetalleProducto(prod);
        } else {
            mostrarMensaje("Producto no encontrado: " + nombre, true);
        }
        return prod;
    }
    
    public void obtenerPedidosCliente(PantallaPedidosProceso vista) {
        try {
            List<PedidoDTO> pedidos = ventaFachada.obtenerTodosLosPedidos();
            
            if (pedidos != null && !pedidos.isEmpty()) {
                vista.llenarTablaPedidos(pedidos);
            } else {
                vista.llenarTablaPedidos(new ArrayList<>());
            }
            
        } catch (NullPointerException ex) {
            mostrarMensaje("No hay pedidos disponibles (datos incompletos).", true);
        } catch (Exception ex) {
            mostrarMensaje("Error al cargar los pedidos: " + ex.getMessage(), true);
        }
    }
    
    public void mostrarMensaje(String mensaje, boolean esError) {
        ventana.mostrarMensaje(mensaje, esError);
    }
    
    // Gestion de productos
     public List<CatalogoProductosDTO> listarProductos() throws Exception {
        return gestionProductos.obtenerCatalogoProductosCompleto();
    }
    
    public List<ProductoDTO> filtrarBusqueda(FiltroProductoDTO filtro) throws Exception {
        return gestionProductos.obtenerCatalogoProductosPorFiltro(filtro);
    }
     
    public ProductoDTO obtenerDetallesProductoSeleccionado(Long idProducto) throws Exception {
        return gestionProductos.obtenerDetallesProductoSeleccionado(idProducto);
    }
    
    public ProductoDTO guardarProducto(ProductoDTO producto) throws Exception {
        return gestionProductos.crearProducto(producto);
    }
    
    public ProductoDTO eliminarProducto(ProductoDTO producto) throws Exception {
        return gestionProductos.eliminarProducto(producto);
    }
    
    public void mostrarPantallaCatalogoProductos() {
        PantallaCatalogo vista = new PantallaCatalogo(this);
        ventana.cambiarPantalla(vista);
    }
    
     public void mostrarPantallaDetallesProducto(ProductoDTO producto) {
        PantallaDetallesProducto detalles = new PantallaDetallesProducto(this, producto);
        ventana.cambiarPantalla(detalles);
    }
     
    public void mostrarPantallaFormularioProducto() {
        PantallaFormularioAgregarProducto form = new PantallaFormularioAgregarProducto(this);
        
        ventana.cambiarPantalla(form);
    } 
    
    public void mostrarPantallaEliminarProducto(ProductoDTO producto) {
        int seleccion= JOptionPane.showConfirmDialog(null, "¿Desea eliminar el producto?", "confirmar",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(seleccion== JOptionPane.YES_OPTION) {
            try {
                gestionProductos.eliminarProducto(producto);
                JOptionPane.showMessageDialog(null, "Producto eliminado");
            } catch (Exception ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        }
    }
    
    public void mostrarMensajeErrorStockInsuficiente() {
        JOptionPane.showMessageDialog(null, "El stock del producto es insuficiente.");
    }
    
    public void mostrarMensajeErrorProductoNoEncontrado() {
        JOptionPane.showMessageDialog(null, "Producto no encontrado");
    }
     public void mostrarMensajeErrorProductoExiste() {
        JOptionPane.showMessageDialog(null, "Producto no existe");
    }

    public void mostrarPantallaCarrito() {
        PantallaCarrito vista = new PantallaCarrito(this);
        ventana.cambiarPantalla(vista);    
    }

    public void buscarProductoCatalogo(String nombre) throws NegocioException {
        consultarProducto(nombre);
    }

    public void cerrarSesion() {
        irLogin();    
    }

    public void irPedidosRealizados() {
        PantallaPedidosProceso vista = new PantallaPedidosProceso(this);
        ventana.cambiarPantalla(vista);    
    }

    public void irVentasAdmin() {
        PantallaVentas vista = new PantallaVentas(this);
        ventana.cambiarPantalla(vista);    
    }
    
    public void llenarTablaPedidos(PantallaVentas vista) {
        try {
            List<PedidoDTO> pedidos = ventaFachada.obtenerTodosLosPedidos();
            vista.llenarTabla(pedidos);
            
        } catch (Exception ex) {
            mostrarMensaje("Error al cargar los pedidos: " + ex.getMessage(), true);
        }
    }
    
}
