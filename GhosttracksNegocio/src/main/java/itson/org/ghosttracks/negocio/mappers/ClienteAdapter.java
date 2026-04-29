/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.mappers;

import itson.org.ghosttracks.dtos.ClienteDTO;
import itson.org.ghosttracks.dtos.DireccionClienteDTO;
import itson.org.ghosttracks.entidades.Cliente;
import itson.org.ghosttracks.entidades.Direccion;

/**
 *
 * @author cinca
 * 
 * Se utilizo Adapter para convertir objetos de dominio en DTO y viceversa
 * para adaptar la informacion.
 * 
 */
public class ClienteAdapter {
    
    public static Cliente toEntity(ClienteDTO cliente) {   
        return new Cliente(
                cliente.getTelefono(), 
                toEntityDireccion(cliente.getDireccion()), 
                Long.MIN_VALUE, 
                cliente.getNombres(), 
                cliente.getApellidoPaterno(), 
                cliente.getApellidoMaterno(), 
                cliente.getCorreo(), 
                cliente.getContraseña());
        
    }
    
    public static Direccion toEntityDireccion(DireccionClienteDTO direccion) {  
        return new Direccion(
                direccion.getCalle(), 
                direccion.getColonia(),
                direccion.getNumero(),
                direccion.getCiudad(),
                direccion.getCodigoPostal(), 
                direccion.getEstado());
    }
    
    public static ClienteDTO toDTO(Cliente cliente){ 
        return new ClienteDTO(
                cliente.getTelefono(),
                toDTODireccion(cliente.getDireccion()),
                cliente.getIdUsuario(),
                cliente.getNombres(),
                cliente.getApellidoPaterno(),
                cliente.getApellidoMaterno(),
                cliente.getCorreo(),
                cliente.getContraseña());
    }
    
    public static DireccionClienteDTO toDTODireccion(Direccion direccion) {
        return new DireccionClienteDTO(
                direccion.getCalle(),
                direccion.getNumero(),
                direccion.getColonia(),
                direccion.getCodigoPostal(),
                direccion.getCiudad(),
                direccion.getEstado());         
    }
}
