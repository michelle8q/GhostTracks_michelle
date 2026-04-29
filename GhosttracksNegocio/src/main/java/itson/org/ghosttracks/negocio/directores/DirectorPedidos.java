/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.directores;

import itson.org.ghosttracks.builders.IPedidoBuilder;
import itson.org.ghosttracks.entidades.DatosPago;
import itson.org.ghosttracks.entidades.Pedido;
import itson.org.ghosttracks.entidades.ProductoPedido;
import java.util.List;

/**
 *
 * @author cinca
 */
public class DirectorPedidos {
    private IPedidoBuilder builder;

    public DirectorPedidos(IPedidoBuilder builder) {
        this.builder = builder;
    }

    public Pedido construirPedidoRapido(Long idCliente, List<ProductoPedido> productos, String folio, DatosPago pago, Double costoEnvio) {
        return builder.idCliente(idCliente)
                      .productos(productos)
                      .folio(folio)
                      .datosPago(pago)
                      .costoEnvio(costoEnvio)
                      .build();
    }
}

