/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.infrastructura.servicioGeneradorReportes;

import itson.org.ghosttracks.dtos.CatalogoProductosDTO;
import itson.org.ghosttracks.negocio.interfaces.IServicioGeneradorReportes;
import java.io.InputStream;
import java.util.List;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author cinca
 */
public class GeneradorReportes implements IServicioGeneradorReportes {
    @Override
    public void generarInformeProductos(List<CatalogoProductosDTO> productos) {
        try {
            JRBeanCollectionDataSource datos = new JRBeanCollectionDataSource(productos);
            InputStream reporte = getClass().getResourceAsStream("/reportes/ReporteProductos.jasper");
            JasperPrint reporteLleno = JasperFillManager.fillReport(reporte, null, datos);
            JasperViewer.viewReport(reporteLleno,false);

        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
