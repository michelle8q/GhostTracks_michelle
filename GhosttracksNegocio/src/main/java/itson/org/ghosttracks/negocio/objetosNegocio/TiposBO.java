/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.objetosNegocio;

import itson.ghosttracks.interfaces.IPersistencia;
import itson.org.ghosttracks.dtos.TipoDTO;
import itson.org.ghosttracks.entidades.TipoProducto;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import itson.org.ghosttracks.fachadas.PersistenciaFachada;
import itson.org.ghosttracks.negocio.interfaces.ITiposBO;
import itson.org.ghosttracks.negocio.mappers.TipoProductoAdapter;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cinca
 */
public class TiposBO implements ITiposBO{
    IPersistencia persistencia;

    public TiposBO() {
        persistencia = PersistenciaFachada.getInstance();
    }

    @Override
    public List<TipoDTO> obtenerTipos() throws NegocioException {
        try {
            List<TipoProducto> tipoEntidad = persistencia.obtenerTipos();
            List<TipoDTO> tiposDTO = new ArrayList<>();

            for (TipoProducto sucursal : tipoEntidad) {
               TipoDTO dto = TipoProductoAdapter.toDTO(sucursal);
               tiposDTO.add(dto);
            }
            
            return tiposDTO;
            
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar ls lista de tipos: " + e.getMessage());
        }
    }

    @Override
    public TipoDTO obtenerTipoPorId(Long id) throws NegocioException {

        try {
            TipoProducto tipoDominio = persistencia.obtenerTipoPorId(id);
            return TipoProductoAdapter.toDTO(tipoDominio);

        } catch (PersistenciaException e) {
            throw new NegocioException("No pudimos recuperar el tipo: " + e.getMessage());
        }
    }
}
