
package itson.org.ghosttracks.controladores;

import itson.org.ghosttracks.dtos.AdministradorDTO;
import itson.org.ghosttracks.dtos.ClienteDTO;
import itson.org.ghosttracks.dtos.PedidoDTO;
import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import itson.org.ghosttracks.presentacion.VentanaPrincipal;
import itson.org.ghosttracks.presentacion.administrador.PantallaVentasProcesarAdmin;
import itson.org.ghosttracks.presentacion.administrador.PantallaVentas;
import itson.org.ghosttracks.presentacion.cliente.PantallaCarrito;
import itson.org.ghosttracks.presentacion.cliente.PantallaFormularioContacto;
import itson.org.ghosttracks.presentacion.cliente.PantallaFormularioEntrega;
import itson.org.ghosttracks.presentacion.cliente.PantallaInicioCliente;
import itson.org.ghosttracks.presentacion.cliente.PantallaSeguimientoPedido;
import itson.org.ghosttracks.presentacion.cliente.PantallaSeleccionMetodoDePago;
import itson.org.ghosttracks.presentacion.cliente.PantallaVistaProducto;
import itson.org.ghosttracks.presentacion.panelLogin;
import itson.org.ghosttracks.utilerias.PanelHeader;
import itson.org.ghosttracks.utilerias.pnlMenuLateral;
import itson.org.ghosttracks.utilerias.pnlMenuLateralAdmin;

/**
 *
 * @author Cinca
 */
public class Navegador {

    private final VentanaPrincipal ventana;
    private final ControlVentaEnLinea ctrlVentaLinea;
    private ClienteDTO cliente;
    private AdministradorDTO admin;
    private String rol;


    public Navegador(VentanaPrincipal ventana) {
        this.ctrlVentaLinea = new ControlVentaEnLinea(this);
        this.ventana = ventana;
        cliente = null;
    }
    
    public void irLogin() {
        ventana.limpiarMenuYHeader();
        ControlLogin ctrl = new ControlLogin(this);
        panelLogin vista = new panelLogin(ctrl);
        ventana.cambiarPantalla(vista);
    }
    
    // Paneles cliente
    
    public void iniciarSesionClienteExitoso(ClienteDTO cliente) {
        this.cliente = cliente;
        this.rol = "Cliente";
        ventana.fijarMenuLateral(new pnlMenuLateral(this));
        ventana.fijarHeader(new PanelHeader(this, cliente, null, rol));   
    }
    
    public void irInicioCliente() {
        PantallaInicioCliente vista = new PantallaInicioCliente(ctrlVentaLinea);
        ventana.cambiarPantalla(vista);
    }
    
    public void irVistaProducto(ProductoDTO producto) {
        PantallaVistaProducto vista = new PantallaVistaProducto(ctrlVentaLinea, producto);
        ventana.cambiarPantalla(vista);
    }
    
    public void irCarrito() {
        PantallaCarrito vista = new PantallaCarrito(ctrlVentaLinea);
        ventana.cambiarPantalla(vista);
    }
    
    // Paneles Pedido
    
    public void irFormularioContacto() {
        PantallaFormularioContacto vista = new PantallaFormularioContacto(ctrlVentaLinea);
        ventana.cambiarPantalla(vista);
    }
    
    public void irFormularioEntrega() {
        PantallaFormularioEntrega vista = new PantallaFormularioEntrega(ctrlVentaLinea);
        ventana.cambiarPantalla(vista);
    }
    
    public void irSeleccionMetodoPago() {
        PantallaSeleccionMetodoDePago vista = new PantallaSeleccionMetodoDePago(ctrlVentaLinea);
        ventana.cambiarPantalla(vista);
    }
    
   
    public void irSeguimientoPedido(PedidoDTO pedido) {
        PantallaSeguimientoPedido vista = new PantallaSeguimientoPedido(ctrlVentaLinea, pedido);
        ventana.cambiarPantalla(vista);
    }
    
    public void irSeguimientoPedido() {
        ctrlVentaLinea.mostrarSeguimientoPedido();
    }
    
    public void buscarProductoCatalogo(String buscar) throws NegocioException {
        ctrlVentaLinea.consultarProducto(buscar);
    }
    
    // Paneles admin
    
    public void iniciarSesionAdminExitoso(AdministradorDTO admin) {
        this.admin = admin;
        this.rol = "Administrador";
        
        ventana.fijarMenuLateral(new pnlMenuLateralAdmin(this));
        ventana.fijarHeader(new PanelHeader(this, null, admin, rol));
    }
    
    public void irVentasAdmin() {
        ControladorVentasAdmin ctrl = new ControladorVentasAdmin(this);
        PantallaVentas vista = new PantallaVentas(ctrl);
        ventana.cambiarPantalla(vista);
    }
    
    public void irProcesarPedidoAdmin() {
        ControladorVentasAdmin ctrl = new ControladorVentasAdmin(this);
        PantallaVentasProcesarAdmin vista = new PantallaVentasProcesarAdmin(ctrl);
        ventana.cambiarPantalla(vista);
    }
    
    public void cerrarSesion() {
        irLogin();
    }
    
    public void mostrarMensaje(String mensaje, boolean esError) {
        ventana.mostrarMensaje(mensaje, esError);
    }
    
}
