/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.mappers;

import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.entidades.Producto;

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
                producto.getImgProducto(),
                producto.getTipoProducto(),
                producto.getArtista(),
                producto.getGenero(),
                producto.getSetlist(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getEstado());
            }
    
    public static ProductoDTO toDTO(Producto producto){
        
        return new ProductoDTO(
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getImgProducto(),
                producto.getTipo(),
                producto.getArtista(),
                producto.getGenero(),
                producto.getSetlist(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getEstado());
            }
        
    
}
