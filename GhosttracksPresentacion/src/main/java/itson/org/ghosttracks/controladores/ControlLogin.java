
package itson.org.ghosttracks.controladores;

import itson.org.ghosttracks.dtos.AdministradorDTO;
import itson.org.ghosttracks.dtos.ClienteDTO;

/**
 *
 * @author cinca
 */
public class ControlLogin {
    
    private Control controlador;

    public ControlLogin(Control controlador) {
        this.controlador = controlador;
    }
    
    public void loginCliente(String nombre) {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNombres(nombre);
        
        controlador.iniciarSesionClienteExitoso(cliente);
        controlador.irInicioCliente();
    }
    
    public void loginAdmin(String nombre) {
        AdministradorDTO admin = new AdministradorDTO();
        admin.setNombres(nombre);
        
        controlador.iniciarSesionAdminExitoso(admin);  
        controlador.irVentasAdmin();
    }
    
}
