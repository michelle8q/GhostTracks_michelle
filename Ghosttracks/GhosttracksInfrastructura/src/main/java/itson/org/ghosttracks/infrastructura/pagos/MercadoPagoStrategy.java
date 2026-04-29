/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.infrastructura.pagos;

import itson.org.ghosttracks.negocio.objetosNegocio.pagos.IPagoStrategy;

/**
 *
 * @author cinca
 */
public class MercadoPagoStrategy implements IPagoStrategy {
    @Override
    public void procesarPago(Double monto) {
        System.out.println("$" + monto + "mediante mercado pago.");
    }
}
