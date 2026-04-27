package itson.org.ghosttracks.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cinca
 */
public class CarritoDTO {
    
    private List<ItemCarritoDTO> productos = new ArrayList<>();
    private Double total;
    private Double subtotal;

    public CarritoDTO() {
    }
    
    public void calcularTotalGeneral() {
        this.total = 0.0;
        for (ItemCarritoDTO producto : productos) {
            producto.calcularSubtotal();
            this.total += producto.getSubtotal();
        }
    }


    public CarritoDTO(Double total) {
        this.total = total;
    }

    public List<ItemCarritoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ItemCarritoDTO> productos) {
        this.productos = productos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    } 
    
}
