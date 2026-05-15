/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.org.ghosttracks.daos;

import itson.org.ghosttracks.entidades.Sucursal;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import java.util.List;

/**
 *
 * @author cinca
 */
public interface ISucursalesDAO {
    List<Sucursal> obtenerSucursales() throws PersistenciaException;
    Sucursal obtenerSucursalPorId(Long idSucursal) throws PersistenciaException;
}
