/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.objetosNegocio;

import itson.ghosttracks.interfaces.IPersistencia;
import itson.org.ghosttracks.dtos.ClienteDTO;
import itson.org.ghosttracks.entidades.Cliente;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import itson.org.ghosttracks.fachadas.PersistenciaFachada;
import itson.org.ghosttracks.negocio.interfaces.IClientesBO;
import itson.org.ghosttracks.negocio.mappers.ClienteAdapter;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;

/**
 *
 * @author Cinca
 */
public class ClientesBO implements IClientesBO{
   IPersistencia persistencia;

    public ClientesBO() {
        persistencia = PersistenciaFachada.getInstance();
    }

    @Override
    public ClienteDTO obtenerClientePorId(Long idCliente) throws NegocioException {
        try {
            Cliente entidad = persistencia.buscarClientePorId(idCliente);
            return ClienteAdapter.toDTO(entidad);

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener cliente: " + e.getMessage());
        }
    }
        
        @Override
        public ClienteDTO buscarPorNombre(String nombre) throws NegocioException {
            try {
                Cliente clienteDominio = persistencia.buscarClientePorNombre(nombre);
                return ClienteAdapter.toDTO(clienteDominio);               

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener administrador: " + e.getMessage());
        }
    
    }
    
}
