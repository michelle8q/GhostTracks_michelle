/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.org.ghosttracks.daos;

import itson.org.ghosttracks.entidades.TipoProducto;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import java.util.List;

/**
 *
 * @author cinca
 */
public interface ITiposDAO {
    List<TipoProducto> obtenerTipos() throws PersistenciaException;
    TipoProducto obtenerTipoPorId(Long idTipo) throws PersistenciaException;
}
