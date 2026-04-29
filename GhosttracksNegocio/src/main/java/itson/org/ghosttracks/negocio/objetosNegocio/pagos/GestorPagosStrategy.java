/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.objetosNegocio.pagos;

/**
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
