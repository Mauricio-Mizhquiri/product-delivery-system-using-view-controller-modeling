/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.modelo;

import java.util.ArrayList;

public class Contenedor {

    private String direccion;
    private String telefono;
    private ArrayList<Ciudad> oficinas;

    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Ciudad> ciudades;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Conductor> conductores;
    private ArrayList<Viaje> viajes;
    private ArrayList<CaracteristicaEspecial> caracteristicasEspeciales;
    private ArrayList<Transaccion> transacciones;

    public Contenedor() {
        this.clientes = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.ciudades = new ArrayList<>();
        this.oficinas = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.conductores = new ArrayList<>();
        this.viajes = new ArrayList<>();
        this.caracteristicasEspeciales = new ArrayList<>();
        this.transacciones = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public ArrayList<Ciudad> getEmpresas() {
        return oficinas;
    }

    public void setEmpresas(ArrayList<Ciudad> empresas) {
        this.oficinas = empresas;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Conductor> getConductores() {
        return this.conductores;
    }

    public void setConductores(ArrayList<Conductor> conductores) {
        this.conductores = conductores;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Transaccion> getTransacciones() {
        return this.transacciones;
    }

    public void setContrato(ArrayList<Transaccion> contrato) {
        this.transacciones = contrato;
    }

    public ArrayList<Viaje> getViajes() {
        return this.viajes;
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
    }

    public ArrayList<CaracteristicaEspecial> getCaracteristicasEspeciales() {
        return this.caracteristicasEspeciales;
    }

    public void setCaracteristicasEspeciales(ArrayList<CaracteristicaEspecial> caracteristicasEspeciales) {
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    public void agregarLista(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void agregarLista(Transaccion transaccion) {
        this.transacciones.add(transaccion);
    }

    public void agregarLista(Producto producto) {
        this.productos.add(producto);
    }

    public void agregarLista(Ciudad ciudad) {
        this.ciudades.add(ciudad);
    }

    public void agregarListaOficina(Ciudad empresa) {
        this.oficinas.add(empresa);
    }

    public void agregarLista(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void agregarLista(Conductor conductor) {
        this.conductores.add(conductor);
    }

    public void agregarLista(Viaje viaje) {
        this.viajes.add(viaje);
    }

    public void eliminarLista(CaracteristicaEspecial caracteristica) {
        this.caracteristicasEspeciales.remove(caracteristica);
    }

    public void eliminarLista(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    public void eliminarLista(Producto producto) {
        this.productos.remove(producto);
    }

    public void eliminarLista(Ciudad ciudad) {
        this.ciudades.remove(ciudad);
    }

    public void eliminarLista(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarLista(Conductor conductor) {
        this.conductores.remove(conductor);
    }

    public void eliminarLista(Viaje viaje) {
        this.viajes.remove(viaje);
    }

    public void agregarLista(CaracteristicaEspecial caracteristicaEspecial) {
        this.caracteristicasEspeciales.add(caracteristicaEspecial);
    }

    public ArrayList<Vehiculo> getVehiculosLibres(String fecha) {
        ArrayList<Vehiculo> vehiculos = this.vehiculos;
        if (this.transacciones != null && !this.transacciones.isEmpty()) {
            for (Transaccion transaccion : this.transacciones) {
                vehiculos.removeIf(
                        vehiculo -> transaccion.getVehiculo().equals(vehiculo) || transaccion.getFecha().equalsIgnoreCase(fecha)
                );
            }
        }
        return vehiculos;
    }

    public Vehiculo getVehiculoLibre() {
        return this.vehiculos.get(0);
    }
    
}
