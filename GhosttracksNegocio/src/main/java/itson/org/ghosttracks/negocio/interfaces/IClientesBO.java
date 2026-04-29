/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.org.ghosttracks.negocio.interfaces;

import itson.org.ghosttracks.dtos.ClienteDTO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;

/**
 *
 * @author cinca
 */
public interface IClientesBO {
    ClienteDTO obtenerClientePorId(Long idCliente) throws NegocioException;
    
    ClienteDTO buscarPorNombre(String nombre) throws NegocioException;
}
