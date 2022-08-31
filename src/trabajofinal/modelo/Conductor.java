/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.modelo;

/**
 *
 * @author paulc
 */
public class Conductor {    
      private String nombre;
      private String cedula;
      private Ciudad ciudad;

    public Conductor(String nombre, String cedula, Ciudad ciudad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.ciudad = ciudad;
    }

    public String getCedula() {
        return cedula;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
      
    
      
}
