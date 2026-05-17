package itson.org.ghosttracks.dtos;

import itson.org.ghosttracks.enums.EstadoProducto;
import java.util.List;

/**
 *
 * @author Cinca
 */
public class ProductoDTO {
    
    private Long idProducto;
    private String nombre;
    private String imgProducto;
    private TipoDTO tipoProducto;
    private String artista;
    private GeneroDTO genero;
    private List<String> setlist;
    private Double precio;
    private Integer stock;
    private EstadoProducto estado;

    public ProductoDTO() {
    }

    public ProductoDTO(
            Long idProducto, 
            String nombre, 
            String imgProducto, 
            TipoDTO tipoProducto, 
            String artista, 
            GeneroDTO genero, 
            List<String> setList,
            Double precio, 
            Integer stock, 
            EstadoProducto estado
    ) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.imgProducto = imgProducto;
        this.tipoProducto = tipoProducto;
        this.artista = artista;
        this.genero = genero;
        this.setlist = setList;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
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

    public String getImgProducto() {
        return imgProducto;
    }

    public void setImgProducto(String imgProducto) {
        this.imgProducto = imgProducto;
    }

    public TipoDTO getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoDTO tipoProducto) {
        this.tipoProducto = tipoProducto;
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
    
    
  
}
