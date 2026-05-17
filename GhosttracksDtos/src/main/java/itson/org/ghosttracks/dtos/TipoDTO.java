/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.dtos;

/**
 *
 * @author cinca
 */
public class TipoDTO {
    private Long idTipo;
    private String nombreTipo;
    
    public TipoDTO() {
        
    }

    public TipoDTO(Long idTipo, String nombreTipo) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
    }

    public TipoDTO(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    
    

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    
    
}
