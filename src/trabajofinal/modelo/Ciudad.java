
package trabajofinal.modelo;

import java.util.ArrayList;

public class Ciudad {
    
    private String nombre;
    private Ubicacion ubicacion;
    private ArrayList<Enlace> ciudadesEnlazadas;

    public Ciudad(String nombre, Ubicacion ubicacion, ArrayList<Enlace> ciudadesEnlazadas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.ciudadesEnlazadas = ciudadesEnlazadas;
    }
    public Ciudad(){};
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }
    
    public int getStringUbicacion() {
        return this.ubicacion.getX() + ',' + this.ubicacion.getY();
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Enlace> getCiudadesEnlazadas() {
        return ciudadesEnlazadas;
    }

    public void setCiudadesEnlazadas(ArrayList<Enlace> ciudadesEnlazadas) {
        this.ciudadesEnlazadas = ciudadesEnlazadas;
    }
    
    public int getStringUbicacionX(){
        return this.ubicacion.getX();
    }
    
    public int getStringUbicacionY(){
        return this.ubicacion.getY();
    }
    public void eliminarLista(Enlace nuevo){
        ciudadesEnlazadas.remove(nuevo);
    }


}
