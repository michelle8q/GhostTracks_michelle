/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.org.ghosttracks.daos;

import itson.org.ghosttracks.entidades.Genero;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import java.util.List;

/**
 *
 * @author cinca
 */
public interface IGenerosDAO {
    List<Genero> obtenerGeneros() throws PersistenciaException;
    Genero obtenerGeneroPorId(Long idGenero) throws PersistenciaException;
}
