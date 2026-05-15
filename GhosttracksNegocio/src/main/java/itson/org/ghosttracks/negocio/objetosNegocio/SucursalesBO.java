/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.objetosNegocio;

import itson.ghosttracks.interfaces.IPersistencia;
import itson.org.ghosttracks.dtos.SucursalDTO;
import itson.org.ghosttracks.entidades.Sucursal;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import itson.org.ghosttracks.fachadas.PersistenciaFachada;
import itson.org.ghosttracks.negocio.interfaces.ISucursalesBO;
import itson.org.ghosttracks.negocio.mappers.SucursalAdapter;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cinca
 */
public class SucursalesBO implements ISucursalesBO {
    IPersistencia persistencia;

    public SucursalesBO() {
       persistencia = PersistenciaFachada.getInstance();
    }

    @Override
    public List<SucursalDTO> obtenerTodos() throws NegocioException {
        try {
            List<Sucursal> productosEntidad = persistencia.obtenerSucursales();
            List<SucursalDTO> sucursalesDTO = new ArrayList<>();

            for (Sucursal sucursal : productosEntidad) {
               SucursalDTO dto = SucursalAdapter.toDTO(sucursal);
               sucursalesDTO.add(dto);
            }
            
            return sucursalesDTO;
            
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar el catálogo de productos: " + e.getMessage());
        }
    }

    @Override
    public SucursalDTO obtenerSucursalPorId(Long id) throws NegocioException {

        try {
            Sucursal sucursalDominio = persistencia.obtenerSucursalPorId(id);
            return SucursalAdapter.toDTO(sucursalDominio);

        } catch (PersistenciaException e) {
            throw new NegocioException("No pudimos recuperar la información del producto: " + e.getMessage());
        }
    }
}
