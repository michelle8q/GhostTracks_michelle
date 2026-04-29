/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.objetosNegocio.pagos;

/**
 * Patron Strategy para manejar los metodos de pago.
 * 
 * @author cinca
 */
public class GestorPagosStrategy {
    
    private IPagoStrategy estrategia;
    
    public void setEstrategia(IPagoStrategy estrategia){
        this.estrategia = estrategia;
    }
    
    public void ejecutarCobro(Double monto) {
        estrategia.procesarPago(monto);
    }
    

}
