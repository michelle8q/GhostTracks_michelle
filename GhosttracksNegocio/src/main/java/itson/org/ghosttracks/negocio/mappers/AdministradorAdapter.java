/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.mappers;

import itson.org.ghosttracks.dtos.AdministradorDTO;
import itson.org.ghosttracks.entidades.Administrador;

/**
 *
 * @author cinca
 * 
 * Se utilizo Adapter para convertir objetos de dominio en DTO y viceversa
 * para adaptar la informacion.
 * 
 */
public class AdministradorAdapter {
    public static Administrador toEntity(AdministradorDTO admin) {
        return new Administrador(  
            admin.getNombres(),
            admin.getApellidoPaterno(),
            admin.getApellidoMaterno(),
            admin.getCorreo(),
            admin.getContraseña()
        );
    }
    
    public static AdministradorDTO toDTO(Administrador admin) {
        return new AdministradorDTO(
            admin.getIdUsuario(),
            String.valueOf(admin.getIdEmpleado()),
            admin.getNombres(),
            admin.getApellidoPaterno(),
            admin.getApellidoMaterno(),
            admin.getCorreo(),
            admin.getContraseña()
        );
    }
}
