/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.mappers;

import itson.org.ghosttracks.dtos.TipoDTO;
import itson.org.ghosttracks.entidades.TipoProducto;

/**
 *
 * @author cinca
 */
public class TipoProductoAdapter {
    public static TipoProducto toEntity(TipoDTO tipo) { 
        return new TipoProducto(
                tipo.getIdTipo(),
                tipo.getNombreTipo()
        );           
    }
    
    public static TipoDTO toDTO(TipoProducto tipo) { 
        return new TipoDTO(
                tipo.getIdTipo(),
                tipo.getNombreTipo()
        );           
    }
}
