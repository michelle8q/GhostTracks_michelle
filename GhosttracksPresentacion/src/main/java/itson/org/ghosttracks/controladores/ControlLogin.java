
package itson.org.ghosttracks.controladores;

import itson.org.ghosttracks.dtos.AdministradorDTO;
import itson.org.ghosttracks.dtos.ClienteDTO;

/**
 *
 * @author cinca
 */
public class ControlLogin {
    
    private Navegador navegador;

    public ControlLogin(Navegador navegador) {
        this.navegador = navegador;
    }
    
    public void loginCliente(String nombre) {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNombres(nombre);
        
        navegador.iniciarSesionClienteExitoso(cliente);
        navegador.irInicioCliente();
    }
    
    public void loginAdmin(String nombre) {
        AdministradorDTO admin = new AdministradorDTO();
        admin.setNombres(nombre);
        
        navegador.iniciarSesionAdminExitoso(admin);  
        navegador.irVentasAdmin();
    }
    
}
