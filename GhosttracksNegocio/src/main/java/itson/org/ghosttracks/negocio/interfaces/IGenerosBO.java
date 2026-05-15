/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.org.ghosttracks.negocio.interfaces;

import itson.org.ghosttracks.dtos.GeneroDTO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author cinca
 */
public interface IGenerosBO {
    List<GeneroDTO> obtenerGeneros() throws NegocioException;
    GeneroDTO obtenerTipoPorId(Long id) throws NegocioException;
}
