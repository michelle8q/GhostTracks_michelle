/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.mappers;

import itson.org.ghosttracks.dtos.DireccionSucursalDTO;
import itson.org.ghosttracks.dtos.SucursalDTO;
import itson.org.ghosttracks.entidades.Direccion;
import itson.org.ghosttracks.entidades.Sucursal;

/**
 *
 * @author cinca
 */
public class SucursalAdapter {
    public static Sucursal toEntity(SucursalDTO sucursal) {
        return new Sucursal (
                toEntityDireccion(sucursal.getDireccion()),
                sucursal.getTelefono(),
                sucursal.getNombre());
    }
    
    public static Direccion toEntityDireccion(DireccionSucursalDTO direccion) {  
        return new Direccion(
                direccion.getCalle(), 
                direccion.getColonia(),
                direccion.getNumero(),
                direccion.getCiudad(),
                direccion.getCodigoPostal(), 
                direccion.getEstado());
    }
    
    public static Sucursal toDTO(Sucursal sucursal) {
        return new Sucursal (
                toDTODireccion(sucursal.getDireccion()),
                sucursal.getTelefono(),
                sucursal.getNombre());
    }
    
    public static Direccion toDTODireccion(Direccion direccion) {  
        return new Direccion(
                direccion.getCalle(), 
                direccion.getColonia(),
                direccion.getNumero(),
                direccion.getCiudad(),
                direccion.getCodigoPostal(), 
                direccion.getEstado());
    }
}
