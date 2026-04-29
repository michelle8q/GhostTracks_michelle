/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.org.ghosttracks.builders;

import itson.org.ghosttracks.entidades.DatosPago;
import itson.org.ghosttracks.entidades.Pedido;
import itson.org.ghosttracks.entidades.ProductoPedido;
import itson.org.ghosttracks.enums.EstadoPedido;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author cinca
 */
public interface IPedidoBuilder {
    PedidoBuilder idCliente(Long idCliente); 


    public PedidoBuilder productos(List<ProductoPedido> productos);

    public PedidoBuilder subtotal(Double subtotal); 

    public PedidoBuilder total(Double total);
    
    public PedidoBuilder datosPago(DatosPago pago);

    public PedidoBuilder costoEnvio(Double envio);

    public PedidoBuilder folio(String folio);

    public PedidoBuilder fecha(LocalDateTime fecha); 

    public PedidoBuilder estado(EstadoPedido estado); 
            
    public Pedido build(); 
}
