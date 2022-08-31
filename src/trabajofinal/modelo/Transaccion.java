
package trabajofinal.modelo;

import java.util.ArrayList;
import trabajofinal.modelo.estados.EstadoViaje;

public class Transaccion {
    private Cliente cliente;
    private Ciudad origen;
    private Ciudad destino;
    private String fecha;
    private ArrayList<Pedido> pedidos;
    private String pesoTotal;
    private String volumenTotal;
    private Vehiculo vehiculo;
    private EstadoViaje estado;
    
    
    public Transaccion(Cliente cliente, Ciudad origen, Ciudad destino, String fecha, ArrayList<Pedido> pedidos, Vehiculo vehiculo, String pesoTotal, String volumenTotal) {
        this.cliente = cliente;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.pedidos = pedidos;
        this.vehiculo = vehiculo;
        this.estado = EstadoViaje.pendiente;
        this.pesoTotal = pesoTotal;
        this.volumenTotal = volumenTotal;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Pedido> getProducto() {
        return pedidos;
    }

    public void setProducto(ArrayList<Pedido> producto) {
        this.pedidos = producto;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getEstado() {
        return this.estado.name().toUpperCase();
    }

    public void setEstado(EstadoViaje estado) {
        this.estado = estado;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(String pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public String getVolumenTotal() {
        return volumenTotal;
    }

    public void setVolumenTotal(String volumenTotal) {
        this.volumenTotal = volumenTotal;
    }    
    
    
}
