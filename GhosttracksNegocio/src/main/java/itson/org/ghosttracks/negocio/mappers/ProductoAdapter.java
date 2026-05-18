/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.mappers;

import itson.org.ghosttracks.dtos.GeneroDTO;
import itson.org.ghosttracks.dtos.ImagenDTO;
import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.dtos.TipoDTO;
import itson.org.ghosttracks.entidades.Genero;
import itson.org.ghosttracks.entidades.ImagenProducto;
import itson.org.ghosttracks.entidades.Producto;
import itson.org.ghosttracks.enums.TipoProducto; 

/**
 *
 * @author cinca
 * 
 * Se utilizo Adapter para convertir objetos de dominio en DTO y viceversa
 * para adaptar la informacion.
 * 
 */
public class ProductoAdapter {
    public static Producto toEntity(ProductoDTO producto){
        
        return new Producto(
                producto.getNombre(),
                toEntityImagen(producto.getImgProducto()),
                toEntityTipo(producto.getTipoProducto()),
                producto.getArtista(),
                toEntityGenero(producto.getGenero()),
                producto.getSetlist(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getEstado());
            }
    
    public static TipoProducto toEntityTipo(TipoDTO tipo) {
        if (tipo == null || tipo.getNombreTipo() == null) {
            return null;
        }
        return TipoProducto.valueOf(tipo.getNombreTipo().toUpperCase());
    }
    
    public static Genero toEntityGenero(GeneroDTO genero) {
        if (genero == null || genero.getNombreGenero() == null) {
            return null;
        }
        return new Genero(genero.getNombreGenero());
    }
    
     public static ImagenProducto toEntityImagen(ImagenDTO imagen) {
        if (imagen == null || imagen.getRuta() == null) {
            return null;
        }
        return new ImagenProducto(imagen.getRuta());
    }
    
    
    public static ProductoDTO toDTO(Producto producto){
        
        return new ProductoDTO(
                producto.getIdProducto(),
                producto.getNombre(),
                toDTOImagen(producto.getImgProducto()),
                toDTOTipo(producto.getTipo()),
                producto.getArtista(),
                toDTOGenero(producto.getGenero()),
                producto.getSetlist(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getEstado());
            }
    
    

    public static TipoDTO toDTOTipo(TipoProducto tipo) {
        if (tipo == null) {
            return null;
        }

        return new TipoDTO(tipo.name());
    }
    
    public static GeneroDTO toDTOGenero(Genero genero) {
        if (genero == null) {
            return null;
        }

        return new GeneroDTO(genero.getNombreGenero());
    }
    
    public static ImagenDTO toDTOImagen(ImagenProducto img) {
        if (img == null) {
            return null;
        }

         return new ImagenDTO(img.getRuta());
    }
}