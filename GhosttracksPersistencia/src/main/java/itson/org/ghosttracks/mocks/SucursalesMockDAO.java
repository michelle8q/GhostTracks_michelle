/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.mocks;

import itson.org.ghosttracks.daos.ISucursalesDAO;
import itson.org.ghosttracks.entidades.Sucursal;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author cinca
 */
public class SucursalesMockDAO implements ISucursalesDAO {
    private static final Logger LOGGER = Logger.getLogger(SucursalesMockDAO.class.getName());
    
    private final List<Sucursal> bdSucursales;
    
    public SucursalesMockDAO() {
        this.bdSucursales = new ArrayList<>();
    }
    
    
    @Override
    public List<Sucursal> obtenerSucursales() throws PersistenciaException {
        try {
            return new ArrayList<>(bdSucursales);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener las sucursales: " + e.getMessage());
        }
    }
    
    @Override
    public Sucursal obtenerSucursalPorId(Long idSucursal) throws PersistenciaException {
        if (idSucursal == null) {
            throw new PersistenciaException("El ID de la sucursal  a buscar no puede ser nulo");
        }

        try {
            for (Sucursal Sucursal : bdSucursales) {
                if (Sucursal.getIdSucursal().equals(idSucursal)) {
                    return Sucursal;
                }
            }
            throw new PersistenciaException("Sucursal no encontrada con el ID: " + idSucursal);

        } catch (PersistenciaException e) {
            throw e;

        } catch (Exception e) {
            LOGGER.severe("Error crítico e inesperado al buscar la sucursal por ID: " + e.getMessage());
            throw new PersistenciaException("Error inesperado al intentar buscar el genero.", e);
        }
    }
}
