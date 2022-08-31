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
public class Enlace {
    private Ciudad ciudad;
    private int tiempoDeViaje; // Minutos

    public Enlace(Ciudad ciudad, int tiempoDeViaje) {
        this.ciudad = ciudad;
        this.tiempoDeViaje = tiempoDeViaje;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public int getTiempoDeViaje() {
        return tiempoDeViaje;
    }

    public void setTiempoDeViaje(int tiempoDeViaje) {
        this.tiempoDeViaje = tiempoDeViaje;
    }
    
    
}
