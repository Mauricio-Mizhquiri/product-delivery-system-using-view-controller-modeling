
package trabajofinal.modelo;

import java.util.ArrayList;

public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private Ciudad ciudad;
    private String pesoMaximo;
    private String volumenMaximo;
    private ArrayList<CaracteristicaEspecial> caracteristicasEspeciales;

    public Vehiculo(String placa, String marca, String modelo, Ciudad ciudad, String pesoMaximo, String volumenMaximo, ArrayList<CaracteristicaEspecial> caracteristicasEspeciales) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ciudad = ciudad;
        this.pesoMaximo = pesoMaximo;
        this.volumenMaximo = volumenMaximo;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(String pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public String getVolumenMaximo() {
        return volumenMaximo;
    }

    public void setVolumenMaximo(String volumenMaximo) {
        this.volumenMaximo = volumenMaximo;
    }

    public ArrayList<CaracteristicaEspecial> getCaracteristicasEspeciales() {
        return caracteristicasEspeciales;
    }

    public void setCaracteristicasEspeciales(ArrayList<CaracteristicaEspecial> caracteristicasEspeciales) {
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }
    
    public boolean tieneCaracteristica(CaracteristicaEspecial caracteristica) {
        if (this.caracteristicasEspeciales != null && !this.caracteristicasEspeciales.isEmpty()) {
            for (CaracteristicaEspecial caracteristicaEspecial : this.caracteristicasEspeciales){
                if (caracteristicaEspecial.equals(caracteristica)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean tieneTodasLasCaracteristicas(ArrayList<CaracteristicaEspecial> caracteristicas) {
        return this.caracteristicasEspeciales.containsAll(caracteristicas);
    }
    
    public boolean tieneCapacidad(int volumen, int peso) {
        return Integer.valueOf(this.volumenMaximo) >= volumen && Integer.valueOf(this.pesoMaximo) >= peso;
    }
    
}
