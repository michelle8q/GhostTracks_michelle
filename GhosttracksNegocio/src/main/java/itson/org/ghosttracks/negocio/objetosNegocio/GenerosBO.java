/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.objetosNegocio;

import itson.ghosttracks.interfaces.IPersistencia;
import itson.org.ghosttracks.dtos.GeneroDTO;
import itson.org.ghosttracks.entidades.Genero;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import itson.org.ghosttracks.fachadas.PersistenciaFachada;
import itson.org.ghosttracks.negocio.interfaces.IGenerosBO;
import itson.org.ghosttracks.negocio.mappers.GeneroAdapter;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cinca
 */
public class GenerosBO implements IGenerosBO{
     IPersistencia persistencia;

    public GenerosBO() {
        persistencia = PersistenciaFachada.getInstance();
    }

    @Override
    public List<GeneroDTO> obtenerGeneros() throws NegocioException {
        try {
            List<Genero> generoEntidad = persistencia.obtenerGeneros();
            List<GeneroDTO> generosDTO = new ArrayList<>();

            for (Genero genero : generoEntidad) {
               GeneroDTO dto = GeneroAdapter.toDTO(genero);
               generosDTO.add(dto);
            }
            
            return generosDTO;
            
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar ls lista de generos: " + e.getMessage());
        }
    }

    @Override
    public GeneroDTO obtenerTipoPorId(Long id) throws NegocioException {

        try {
            Genero generoDominio = persistencia.obtenerGeneroPorId(id);
            return GeneroAdapter.toDTO(generoDominio);

        } catch (PersistenciaException e) {
            throw new NegocioException("No pudimos recuperar el genero: " + e.getMessage());
        }
    }
}
