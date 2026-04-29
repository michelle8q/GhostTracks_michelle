/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.org.ghosttracks.negocio.interfaces;

import itson.org.ghosttracks.dtos.AdministradorDTO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;

/**
 *
 * @author cinca
 */
public interface IAdministradoresBO {
    AdministradorDTO obtenerAdministradorPorId(Long idEmpleado) throws NegocioException;
    
    AdministradorDTO buscarPorNombre(String nombre) throws NegocioException;
}
