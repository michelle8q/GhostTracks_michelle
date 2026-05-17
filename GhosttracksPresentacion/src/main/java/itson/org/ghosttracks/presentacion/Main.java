
package itson.org.ghosttracks.presentacion;

import itson.org.ghosttracks.controladores.Control;



/**
 *
 * @author cinca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VentanaPrincipal ventana = new VentanaPrincipal();
        Control control = Control.getInstancia();
        control.setVentana(ventana);
        control.irLogin();
        ventana.setVisible(true);
        
    }
    
}
