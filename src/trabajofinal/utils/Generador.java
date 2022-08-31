/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.utils;

import java.util.ArrayList;
import trabajofinal.modelo.CaracteristicaEspecial;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Cliente;
import trabajofinal.modelo.Conductor;
import trabajofinal.modelo.Contenedor;
import trabajofinal.modelo.Enlace;
import trabajofinal.modelo.Producto;
import trabajofinal.modelo.Ubicacion;
import trabajofinal.modelo.Vehiculo;

/**
 *
 * @author paulc
 */
public class Generador {

    public static void generarDatos(Contenedor contenedor) {
        contenedor.agregarLista(new Ciudad("CUENCA", new Ubicacion(40, 20), new ArrayList<>()));
        contenedor.agregarLista(new Ciudad("QUITO", new Ubicacion(60, 80), new ArrayList<>()));
        contenedor.agregarLista(new Ciudad("GUAYAQUIL", new Ubicacion(30, 30), new ArrayList<>()));
        contenedor.agregarLista(new Ciudad("LOJA", new Ubicacion(40, 10), new ArrayList<>()));
        contenedor.agregarLista(new Ciudad("AMBATO", new Ubicacion(50, 50), new ArrayList<>()));
        ArrayList<Enlace> enlaceAux = new ArrayList<>();
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(2), 205));
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(4), 339));
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(3), 219));
        contenedor.getCiudades().get(0).getCiudadesEnlazadas().add(enlaceAux.get(0));//Enlaces a cuenca
        contenedor.getCiudades().get(0).getCiudadesEnlazadas().add(enlaceAux.get(1));
        enlaceAux.clear();
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(0), 219));
        contenedor.getCiudades().get(3).getCiudadesEnlazadas().add(enlaceAux.get(0));//Enlaces a loja
        enlaceAux.clear();
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(4), 316));
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(0), 205));
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(1), 439));
        contenedor.getCiudades().get(2).getCiudadesEnlazadas().add(enlaceAux.get(0));//Enlaces a guayaquil
        contenedor.getCiudades().get(2).getCiudadesEnlazadas().add(enlaceAux.get(1));
        enlaceAux.clear();
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(4), 145));
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(2), 439));
        contenedor.getCiudades().get(1).getCiudadesEnlazadas().add(enlaceAux.get(0));//Enlaces a quito
        contenedor.getCiudades().get(1).getCiudadesEnlazadas().add(enlaceAux.get(1));
        enlaceAux.clear();
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(0), 339));
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(1), 145));
        enlaceAux.add(new Enlace(contenedor.getCiudades().get(2), 316));
        contenedor.getCiudades().get(4).getCiudadesEnlazadas().add(enlaceAux.get(0));//Enlaces ambato
        contenedor.getCiudades().get(4).getCiudadesEnlazadas().add(enlaceAux.get(1));
        contenedor.getCiudades().get(4).getCiudadesEnlazadas().add(enlaceAux.get(2));
        enlaceAux.clear();

        contenedor.agregarLista(new Cliente(new ArrayList<>(), false, "JOSE", "AV. DE LAS AMERICAS", "072480261", "jose@gmail.com"));
        contenedor.getClientes().get(0).getCiudad().add(contenedor.getCiudades().get(0));
        contenedor.getClientes().get(0).getCiudad().add(contenedor.getCiudades().get(1));

        contenedor.agregarLista(new Cliente(new ArrayList<>(), false, "RAUL", "MALL DEL RIO", "074088882", "raul@gmail.com"));
        contenedor.getClientes().get(1).getCiudad().add(contenedor.getCiudades().get(2));
        contenedor.getClientes().get(1).getCiudad().add(contenedor.getCiudades().get(3));

        contenedor.agregarLista(new Cliente(new ArrayList<>(), false, "KARLA", "PUENTE ROTO", "072480596", "karla@gmail.com"));
        contenedor.getClientes().get(2).getCiudad().add(contenedor.getCiudades().get(4));
        contenedor.getClientes().get(2).getCiudad().add(contenedor.getCiudades().get(0));

        contenedor.agregarLista(new Cliente(new ArrayList<>(), false, "EVELYN", "CALLE LARGA", "074056913", "evelin@gmial.com"));
        contenedor.getClientes().get(3).getCiudad().add(contenedor.getCiudades().get(1));
        contenedor.getClientes().get(3).getCiudad().add(contenedor.getCiudades().get(2));

        contenedor.agregarLista(new Cliente(new ArrayList<>(), false, "ROBERTO", "SAN BLAS", "072480759", "roberto@gmial.com"));
        contenedor.getClientes().get(4).getCiudad().add(contenedor.getCiudades().get(3));
        contenedor.getClientes().get(4).getCiudad().add(contenedor.getCiudades().get(4));

        contenedor.agregarLista(new CaracteristicaEspecial("NINGUNA", ""));
        contenedor.agregarLista(new CaracteristicaEspecial("VENTILACIÓN", "PUEDE MANTENER PRODUCTOS EN TEMPERATURAS NORMALES"));
        contenedor.agregarLista(new CaracteristicaEspecial("REFRIGERACIÓN", "PUEDE MANTENER PRODUCTOS EN BAJAS TEMPERATURAS"));
        contenedor.agregarLista(new CaracteristicaEspecial("REFRIGERACION ISOTERMICA", "MANTIENE EL FRIO EN TODO MOMENTO"));

        contenedor.agregarLista(new Producto("CERVEZA WIERQUER", "0.5", "0.0005", new ArrayList<>(), "LATA"));
        contenedor.getProductos().get(0).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(2));

        contenedor.agregarLista(new Producto("CERVEZA PILSENER", "0.2934", "0.000296", new ArrayList<>(), "LATA"));
        contenedor.getProductos().get(1).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(2));

        contenedor.agregarLista(new Producto("CERVEZA CLUB", "0.52", "0.00058", new ArrayList<>(), "LATA"));
        contenedor.getProductos().get(2).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(2));

        contenedor.agregarLista(new Producto("CERVEZA BUDWEISER ", "0.26", "0.00029", new ArrayList<>(), "LATA"));
        contenedor.getProductos().get(3).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(2));

        contenedor.agregarLista(new Producto("CERVEZA PILSENER LIGHT", "0.26", "0.00029", new ArrayList<>(), "LATA"));
        contenedor.getProductos().get(4).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(2));

        contenedor.agregarLista(new Producto("CANGUIL", "0.5", "0.0005", new ArrayList<>(), "FUNDA"));
        contenedor.getProductos().get(5).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(0));

        contenedor.agregarLista(new Producto("GALLETAS AMOR", "0.1", "0.0001", new ArrayList<>(), "PAQUETE"));
        contenedor.getProductos().get(6).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(0));

        contenedor.agregarLista(new Producto("POLLO ENTERO", "2", "0.002", new ArrayList<>(), "PAQUETE"));
        contenedor.getProductos().get(7).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(2));
        contenedor.getProductos().get(7).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(3));

        contenedor.agregarLista(new Producto("CORVINA", "25", "0.028", new ArrayList<>(), "CARTON"));
        contenedor.getProductos().get(8).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(3));

        contenedor.agregarLista(new Producto("1L MARISCO", "0.45", "0.0005", new ArrayList<>(), "PAQUETE"));
        contenedor.getProductos().get(9).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(3));

        contenedor.agregarLista(new Producto("VIVE 100", "0.2", "0.0002", new ArrayList<>(), "BOTELLA"));
        contenedor.getProductos().get(10).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(1));

        contenedor.agregarLista(new Producto("COLA SPRITE", "1.57", "0.0017", new ArrayList<>(), "BOTELLA"));
        contenedor.getProductos().get(11).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(1));

        contenedor.agregarLista(new Producto("SAL", "2", "0.02", new ArrayList<>(), "FUNDA"));
        contenedor.getProductos().get(12).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(0));

        contenedor.agregarLista(new Vehiculo("GDF 653", "FERRARI", "2015", contenedor.getCiudades().get(0), "10", "5", new ArrayList<>()));
        contenedor.getVehiculos().get(0).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(0));

        contenedor.agregarLista(new Vehiculo("ABC 965", "RENAULT", "2016", contenedor.getCiudades().get(1), "11", "6", new ArrayList<>()));
        contenedor.getVehiculos().get(1).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(1));
        contenedor.getVehiculos().get(1).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(2));

        contenedor.agregarLista(new Vehiculo("JHN 267", "AUDI", "2017", contenedor.getCiudades().get(2), "50", "30", new ArrayList<>()));
        contenedor.getVehiculos().get(2).getCaracteristicasEspeciales().add(contenedor.getCaracteristicasEspeciales().get(3));

        //this.agregarLista(new Empresa("CENTRO COMERCIAL ORTIZ",ciudades.get(0),"CALLE LARGA Y TARQUI","072480999"));
 
        contenedor.agregarLista(new Conductor("MANUEL","03020649444" ,contenedor.getCiudades().get(1)));
        contenedor.agregarLista(new Conductor("CARLOS","01050629576", contenedor.getCiudades().get(2)));
    }
}
