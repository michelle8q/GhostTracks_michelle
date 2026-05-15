/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.mappers;

import itson.org.ghosttracks.dtos.GeneroDTO;
import itson.org.ghosttracks.entidades.Genero;

/**
 *
 * @author cinca
 */
public class GeneroAdapter {
      public static Genero toEntity(GeneroDTO genero) { 
        return new Genero(
                genero.getIdGenero(),
                genero.getNombreGenero()
        );           
    }
    
    public static GeneroDTO toDTO(Genero genero) { 
        return new GeneroDTO(
                genero.getIdGenero(),
                genero.getNombreGenero()
        );           
    }
}
