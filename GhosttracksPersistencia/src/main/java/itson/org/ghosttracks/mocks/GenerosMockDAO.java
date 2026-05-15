/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.mocks;

import java.util.logging.Logger;
import itson.org.ghosttracks.daos.IGenerosDAO;
import itson.org.ghosttracks.entidades.Genero;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cinca
 */
public class GenerosMockDAO implements IGenerosDAO {
    
    private static final Logger LOGGER = Logger.getLogger(GenerosMockDAO.class.getName());
    
    private final List<Genero> bdGeneros;
    
    public GenerosMockDAO() {
        this.bdGeneros = new ArrayList<>();
    }
    
    
    @Override
    public List<Genero> obtenerGeneros() throws PersistenciaException {
        try {
            return new ArrayList<>(bdGeneros);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los generos: " + e.getMessage());
        }
    }
    
    @Override
    public Genero obtenerGeneroPorId(Long idGenero) throws PersistenciaException {
        if (idGenero == null) {
            throw new PersistenciaException("El ID del genero a buscar no puede ser nulo");
        }

        try {
            for (Genero genero : bdGeneros) {
                if (genero.getIdGenero().equals(idGenero)) {
                    return genero;
                }
            }
            throw new PersistenciaException("Genero no encontrado con el ID: " + idGenero);

        } catch (PersistenciaException e) {
            throw e;

        } catch (Exception e) {
            LOGGER.severe("Error crítico e inesperado al buscar el genero por ID: " + e.getMessage());
            throw new PersistenciaException("Error inesperado al intentar buscar el genero.", e);
        }
    }
}
