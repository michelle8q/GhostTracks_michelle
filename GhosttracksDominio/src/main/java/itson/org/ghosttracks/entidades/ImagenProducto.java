/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.entidades;

/**
 *
 * @author cinca
 */
public class ImagenProducto {
    private Long idImagen;
    private String ruta;

    public ImagenProducto(Long idImagen, String ruta) {
        this.idImagen = idImagen;
        this.ruta = ruta;
    }

    public ImagenProducto(String ruta) {
        this.ruta = ruta;
    }

    public Long getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Long idImagen) {
        this.idImagen = idImagen;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
}
