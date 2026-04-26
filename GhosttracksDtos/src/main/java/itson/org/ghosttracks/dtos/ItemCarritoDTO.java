package itson.org.ghosttracks.dtos;

/**
 *
 * @author emy
 */
public class ItemCarritoDTO {
    
    private ProductoDTO productoSeleccionado;
    private Integer cantidad;
    private Double subtotal;

    public ItemCarritoDTO() {
    }

    
    public ItemCarritoDTO(ProductoDTO productoSeleccionado, Integer cantidad) {
        this.productoSeleccionado = productoSeleccionado;
        this.cantidad = cantidad;
    }
    
    public Double calcularSubtotal() {
        if (this.productoSeleccionado != null && this.productoSeleccionado.getPrecio() != null && this.cantidad != null) {
            this.subtotal = this.productoSeleccionado.getPrecio() * this.cantidad;
        }
        
        return 0.0;
    }

    public ProductoDTO getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(ProductoDTO productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
    
}
