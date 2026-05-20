/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.mocks;

import itson.org.ghosttracks.daos.ITiposDAO;
import itson.org.ghosttracks.entidades.TipoProducto;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author cinca
 */
public class TiposMockDAO implements ITiposDAO{
   private static final Logger LOGGER = Logger.getLogger(TiposMockDAO.class.getName());
    
    private final List<TipoProducto> bdTipos;
    
    public TiposMockDAO() {
        this.bdTipos = new ArrayList<>();
    }
    
    
    @Override
    public List<TipoProducto> obtenerTipos() throws PersistenciaException {
        try {
            if(bdTipos == null) {
                throw new PersistenciaException("La lista de tipos no existe");
            }
            if(bdTipos.isEmpty()) {
                throw new PersistenciaException("La lista de tipos esta vacia");
            }
            return new ArrayList<>(bdTipos);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los tipos: " + e.getMessage());
        }
    }
    
    @Override
    public TipoProducto obtenerTipoPorId(Long idTipo) throws PersistenciaException {
        if (idTipo == null) {
            throw new PersistenciaException("El ID del tipo a buscar no puede ser nulo");
        }

        try {
            for (TipoProducto tipo : bdTipos) {
                if (tipo.getIdTipo().equals(idTipo)) {
                    return tipo;
                }
            }
            throw new PersistenciaException("Tipo no encontrada con el ID: " + idTipo);

        } catch (PersistenciaException e) {
            throw e;

        } catch (Exception e) {
            LOGGER.severe("Error crítico e inesperado al buscar rl tipo por ID: " + e.getMessage());
            throw new PersistenciaException("Error inesperado al intentar buscar el tipo.", e);
        }
    }
}
