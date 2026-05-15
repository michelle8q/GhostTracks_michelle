/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.controladores;

import itson.org.ghosttracks.dtos.FiltroProductoDTO;
import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.presentacion.gestionProductos.PantallaCatalogo;
import itson.org.ghosttracks.presentacion.gestionProductos.PantallaDetallesProducto;
import itson.org.ghosttracks.presentacion.gestionProductos.PantallaFormularioAgregarProducto;
import itson.org.ghosttracksgestionproductos.fachada.GestionProductos;
import itson.org.ghosttracksgestionproductos.interfaces.IGestionProductos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author cinca
 */
public class ControlGestionProductos {
    
    private final IGestionProductos gestionProductosFachada;
    private final Navegador navegador;
    
    public ControlGestionProductos(Navegador navegador) {
        this.gestionProductosFachada = new GestionProductos();
        this.navegador = navegador;
    }
    

    public List<ProductoDTO> listarProductos() throws Exception {
        return gestionProductosFachada.obtenerCatalogoProductos(new FiltroProductoDTO());
    }
    
    public List<ProductoDTO> filtrarBusqueda(FiltroProductoDTO filtro) throws Exception {
        return gestionProductosFachada.obtenerCatalogoProductos(filtro);
    }
     
    public ProductoDTO obtenerDetallesProductoSeleccionado(Long idProducto) throws Exception {
        return gestionProductosFachada.obtenerDetallesProductoSeleccionado(idProducto);
    }
    
    public ProductoDTO guardarProducto(ProductoDTO producto) throws Exception {
        return gestionProductosFachada.crearProducto(producto);
    }
    
    public void mostrarPantallaCatalogoProductos() {
        PantallaCatalogo catalogo = new PantallaCatalogo();
        
        catalogo.setVisible(true);
    }
    
     public void mostrarPantallaDetallesProducto() {
        PantallaDetallesProducto detalles = new PantallaDetallesProducto();
        
        detalles.setVisible(true);
    }
    public void mostrarPantallaFormularioProducto() {
        PantallaFormularioAgregarProducto form = new PantallaFormularioAgregarProducto();
        
        form.setVisible(true);
    } 
    
    public void mostrarPantallaEliminarProducto(ProductoDTO producto) {
        return;
    }
    
    public void mostrarMensajeErrorStockInsuficiente() {
        JOptionPane.showMessageDialog(null,"El producto ya existe.");
    }
    
    public void mostrarMensajeErrorProductoNoEncontrado() {
        JOptionPane.showMessageDialog(null, "Producto no encontrado");
    }
     public void mostrarMensajeErrorProductoExiste() {
        JOptionPane.showMessageDialog(null, "Producto no existe");
    }
}
