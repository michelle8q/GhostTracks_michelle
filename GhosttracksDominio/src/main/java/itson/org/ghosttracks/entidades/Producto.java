package itson.org.ghosttracks.entidades; 

import itson.org.ghosttracks.enums.EstadoProducto;
import itson.org.ghosttracks.enums.TipoProducto;
import java.util.List;

/**
 * @author cinca
 */
    
public class Producto {
    private Long idProducto; 
    
    private String nombre;
    private ImagenProducto imgProducto;
    private TipoProducto tipoProducto;
    private String artista;
    private Genero genero;
    private List<String> setlist;
    private Double precio;
    private Integer stock;
    private EstadoProducto estado;
    private Sucursal sucursal;

    public Producto() {
        
    }

    public Producto(String nombre, ImagenProducto imgProducto, TipoProducto tipoProducto, String artista, Genero genero, List<String> setlist, Double precio, Integer stock, EstadoProducto estado, Sucursal sucursal) {
        this.nombre = nombre;
        this.imgProducto = imgProducto;
        this.tipoProducto = tipoProducto;
        this.artista = artista;
        this.genero = genero;
        this.setlist = setlist;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.sucursal = sucursal;
    }

    public Producto(Long idProducto, String nombre, ImagenProducto imgProducto, TipoProducto tipoProducto, String artista, Genero genero, List<String> setlist, Double precio, Integer stock, EstadoProducto estado, Sucursal sucursal) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.imgProducto = imgProducto;
        this.tipoProducto = tipoProducto;
        this.artista = artista;
        this.genero = genero;
        this.setlist = setlist;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.sucursal = sucursal;
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

    public ImagenProducto getImgProducto() {
        return imgProducto;
    }

    public void setImgProducto(ImagenProducto imgProducto) {
        this.imgProducto = imgProducto;
    }

    public TipoProducto getTipo() {
        return tipoProducto;
    }

    public void setTipo(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<String> getSetlist() {
        return setlist;
    }

    public void setSetlist(List<String> setlist) {
        this.setlist = setlist;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }


    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    

}