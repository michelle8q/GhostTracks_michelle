/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.objetosNegocio;

import itson.org.ghosttracks.daos.IAdministradoresDAO;
import itson.org.ghosttracks.dtos.AdministradorDTO;
import itson.org.ghosttracks.entidades.Administrador;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import itson.org.ghosttracks.mocks.AdministradoresMockDAO;
import itson.org.ghosttracks.negocio.interfaces.IAdministradoresBO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;

/**
 *
 * @author cinca
 */
public class AdministradoresBO implements IAdministradoresBO{
    
    private final IAdministradoresDAO administradoresDAO;

    public AdministradoresBO() {
        this.administradoresDAO = new AdministradoresMockDAO();
    }

    @Override
    public AdministradorDTO obtenerAdministradorPorId(Long idEmpleado) throws NegocioException {
        try {
            Administrador entidad = administradoresDAO.buscarPorId(idEmpleado);
            AdministradorDTO dto = new AdministradorDTO();
            
            dto.setIdUsuario(entidad.getIdUsuario());
            dto.setNombres(entidad.getNombres());
            dto.setApellidoPaterno(entidad.getApellidoPaterno());
            dto.setApellidoMaterno(entidad.getApellidoMaterno());
            dto.setCorreo(entidad.getCorreo());
            dto.setContraseña(entidad.getContraseña()); 

            return dto;

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener administrador: " + e.getMessage());
        }
    }
    
    @Override
    public AdministradorDTO buscarPorNombre(String nombre) throws NegocioException {
        try {
            Administrador entidad = administradoresDAO.buscarPorNombre(nombre);
            AdministradorDTO dto = new AdministradorDTO();
            
            dto.setIdUsuario(entidad.getIdUsuario());
            dto.setNombres(entidad.getNombres());
            dto.setApellidoPaterno(entidad.getApellidoPaterno());
            dto.setApellidoMaterno(entidad.getApellidoMaterno());
            dto.setCorreo(entidad.getCorreo());
            dto.setContraseña(entidad.getContraseña()); 

            return dto;

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener administrador: " + e.getMessage());
        }
    }
}
