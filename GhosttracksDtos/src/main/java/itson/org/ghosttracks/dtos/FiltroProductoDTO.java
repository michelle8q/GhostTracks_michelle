/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.dtos;

/**
 *
 * @author cinca
 */
public class FiltroProductoDTO {
    private String nombre;
    private String artista;
    private GeneroDTO genero;
    private SucursalDTO sucursal;
    private TipoDTO tipo;
    
    public FiltroProductoDTO() {
        
    }

    public FiltroProductoDTO(String nombre, String artista, GeneroDTO genero, SucursalDTO sucursal, TipoDTO tipo) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.sucursal = sucursal;
        this.tipo = tipo;
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

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    public TipoDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoDTO tipo) {
        this.tipo = tipo;
    }
    
    
}
