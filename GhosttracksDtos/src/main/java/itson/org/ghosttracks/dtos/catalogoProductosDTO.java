/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.dtos;

/**
 *
 * @author cinca
 */
public class CatalogoProductosDTO {
    private Long idProducto;
    private String nombre;
    private String artista;
    private GeneroDTO genero;
    private TipoDTO tipo;
    private int stock;
    
    public CatalogoProductosDTO() {
        
    }

    public CatalogoProductosDTO(Long idProducto, String nombre, String artista, GeneroDTO genero, TipoDTO tipo, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.tipo = tipo;
        this.stock = stock;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public GeneroDTO getGenero() {
        return genero;
    }

    public void setGenero(GeneroDTO genero) {
        this.genero = genero;
    }

    public TipoDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoDTO tipo) {
        this.tipo = tipo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
