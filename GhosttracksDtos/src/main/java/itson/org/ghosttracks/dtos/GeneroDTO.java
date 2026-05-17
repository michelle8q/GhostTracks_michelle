/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.dtos;

/**
 *
 * @author cinca
 */
public class GeneroDTO {
    private Long idGenero;
    private String nombreGenero;
    
    public GeneroDTO () {
        
    }
    public GeneroDTO(Long idGenero, String nombreGenero) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
    }

    public GeneroDTO(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
    
    

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero.toString();
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero.toString();
    }
    
    @Override
    public String toString() {
        return nombreGenero;
    }
}
