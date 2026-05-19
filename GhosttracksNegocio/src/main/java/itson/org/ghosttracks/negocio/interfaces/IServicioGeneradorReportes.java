/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.org.ghosttracks.negocio.interfaces;

import itson.org.ghosttracks.dtos.CatalogoProductosDTO;
import java.util.List;

/**
 *
 * @author cinca
 */
public interface IServicioGeneradorReportes {
    void generarInformeProductos(List<CatalogoProductosDTO> productos);
}
