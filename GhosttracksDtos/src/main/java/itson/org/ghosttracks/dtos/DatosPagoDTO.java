package itson.org.ghosttracks.dtos;

import itson.org.ghosttracks.enums.TipoPago;
import java.time.LocalDateTime;

/**
 *
 * @author cinca
 */
public class DatosPagoDTO {
    
    private Long idTarjeta;
    private String titularTarjeta;
    private String numeroTrajeta;
    private LocalDateTime fechaExpiracion;
    private String cvv;
    private TipoPago tipoPago;

    public DatosPagoDTO() {
    }

    public DatosPagoDTO(
            String titularTarjeta, 
            String numeroTrajeta, 
            LocalDateTime fechaExpiracion, 
            String cvv
    ) {
        this.titularTarjeta = titularTarjeta;
        this.numeroTrajeta = numeroTrajeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
    }

    public DatosPagoDTO(Long idTarjeta, String titularTarjeta, String numeroTrajeta, LocalDateTime fechaExpiracion, String cvv, TipoPago tipoPago) {
        this.idTarjeta = idTarjeta;
        this.titularTarjeta = titularTarjeta;
        this.numeroTrajeta = numeroTrajeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
        this.tipoPago = tipoPago;
    }

    public Long getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }

    public String getNumeroTrajeta() {
        return numeroTrajeta;
    }

    public void setNumeroTrajeta(String numeroTrajeta) {
        this.numeroTrajeta = numeroTrajeta;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    
    
}
