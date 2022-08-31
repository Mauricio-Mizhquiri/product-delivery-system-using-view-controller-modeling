
package trabajofinal.modelo;
import java.util.ArrayList;

public class Producto {
    private String nombre;
    private String peso;
    private String volumen;
    private ArrayList<CaracteristicaEspecial> caracteristicasEspeciales;
    private String TipoUnidad;

    public Producto(String nombre, String peso,String volumen, ArrayList<CaracteristicaEspecial> caracteristicasEspeciales, String TipoUnidad) {
        this.nombre = nombre;
        this.peso = peso;
        this.volumen = volumen;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
        this.TipoUnidad=TipoUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public ArrayList<CaracteristicaEspecial> getCaracteristicasEspeciales() {
        return caracteristicasEspeciales;
    }

    public void setCaracteristicasEspeciales(ArrayList<CaracteristicaEspecial> caracteristicasEspeciales) {
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    public String getTipoUnidad() {
        return TipoUnidad;
    }

    public void setTipoUnidad(String TipoUnidad) {
        this.TipoUnidad = TipoUnidad;
    }
    
    
}
