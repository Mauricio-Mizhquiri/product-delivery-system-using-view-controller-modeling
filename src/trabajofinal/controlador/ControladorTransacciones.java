package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Cliente;
import trabajofinal.modelo.Contenedor;
import trabajofinal.modelo.Enlace;
import trabajofinal.modelo.Pedido;
import trabajofinal.modelo.Transaccion;
import trabajofinal.modelo.Vehiculo;
import trabajofinal.modelo.estados.EstadoViaje;
import trabajofinal.utils.Dialogo;
import trabajofinal.vista.VistaTransacciones;
import trabajofinal.vista.adicionales.ModalPedido;

public class ControladorTransacciones extends Controlador {

    private VistaTransacciones vista;
    private ArrayList<Pedido> pedidos;

    public ControladorTransacciones(Contenedor contenedor) {
        super(contenedor);
        this.pedidos = new ArrayList<>();
        this.vista = new VistaTransacciones(this.contenedor);
        this.vista.cargarTransacciones();
        this.vista.setActionListeners(this);
    }

    public void ingresar() {
        if (this.esValido()) {
            if (this.existeEnlace()) {
                ArrayList<Pedido> pedidos = new ArrayList<>();
                for (Pedido pedido : this.pedidos) {
                    pedidos.add(new Pedido(
                            pedido.getProducto(),
                            pedido.getCantidad()
                    ));
                }
                Transaccion transaccion = new Transaccion(
                        this.vista.getCliente(),
                        this.vista.getCiudadOrigen(),
                        this.vista.getCiudadDestino(),
                        this.vista.getFecha(),
                        pedidos,
                        this.contenedor.getVehiculoLibre(),
                        this.vista.getPeso(),
                        this.vista.getVolumen()
                );
                this.contenedor.agregarLista(transaccion);
                this.vista.cargarTransacciones();
                this.pedidos.clear();
                this.vista.borrarCampos();
                Dialogo.mostrar(vista, "Transacción agregada correctamente");
                return;
            }
            Dialogo.mostrar(vista, "Error, no existe un enlace entre estas ciudades");

        }
    }

    public boolean existeEnlace() {
        Ciudad origen = this.vista.getCiudadOrigen();
        Ciudad destino = this.vista.getCiudadDestino();
        ArrayList<Enlace> enlacesOrigen = origen.getCiudadesEnlazadas();
        if ((enlacesOrigen != null && !enlacesOrigen.isEmpty())) {
            for (Enlace enlace : enlacesOrigen) {
                if (enlace.getCiudad().equals(destino)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void calcularPeso() {
        if (this.pedidos != null && !this.pedidos.isEmpty()) {
            Double peso = 0.00;
            for (Pedido pedido : this.pedidos) {
                peso += Double.parseDouble(pedido.getProducto().getPeso()) * pedido.getCantidad();
            }
            DecimalFormat df = new DecimalFormat("#.00");
            this.vista.setPeso(df.format(peso));
            return;
        }
        this.vista.setPeso("0");
    }

    public void calcularVolumen() {
        if (this.pedidos != null && !this.pedidos.isEmpty()) {
            Double volumen = 0.00;
            for (Pedido pedido : this.pedidos) {
                volumen += Double.parseDouble(pedido.getProducto().getVolumen()) * pedido.getCantidad();
            }
            DecimalFormat df = new DecimalFormat("#.00");
            this.vista.setVolumen(df.format(volumen));
            return;
        }
        this.vista.setVolumen("0");
    }

    public void marcar(EstadoViaje estado) {
        int index = this.vista.getIndiceTablaTransacciones();
        if (index != -1) {
            this.contenedor.getTransacciones().get(index).setEstado(estado);
            this.vista.cargarTransacciones();
            return;
        }
        Dialogo.mostrar(vista, "Selecciona una transacción para continuar");
    }

    public ArrayList<Vehiculo> validarVehiculo(Ciudad origen, Ciudad destino) {
        //System.out.println("Ciudad Destino: "+origen+" Ciudad Destino: "+destino);
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        int peso = 0, volumen = 0;
        boolean ciudadExistente = false;
        /*
        for (Pedido ped : this.vista.getPedidos()) {
            peso += Integer.parseInt(ped.getProducto().getPeso()) * ped.getCantidad();
            volumen += Integer.parseInt(ped.getProducto().getVolumen()) * ped.getCantidad();
        }
         */
        for (Vehiculo vehi : contenedor.getVehiculos()) {
            if ((Integer.parseInt(vehi.getPesoMaximo()) >= peso) && (Integer.parseInt(vehi.getVolumenMaximo()) >= volumen)) {
                vehiculos.add(vehi);
            }
        }
        for (Ciudad orig : contenedor.getCiudades()) {
            if (orig.getNombre().equalsIgnoreCase(origen.getNombre())) {
                for (Enlace dest : orig.getCiudadesEnlazadas()) {
                    if (dest.getCiudad().getNombre().equalsIgnoreCase(destino.getNombre())) {
                        ciudadExistente = true;
                    }
                }
            }
        }
        return vehiculos;
    }

    private boolean esValido() {
        String errores = "";
        if (this.vista.getCliente() == null) {
            errores += "- No has seleccionado un cliente.\n";
        }
        if (this.vista.getCiudadOrigen() == null) {
            errores += "- No has seleccionado una ciudad de origen.\n";
        }
        if (this.vista.getCiudadDestino() == null) {
            errores += "- No has seleccionado una ciudad de destino.\n";
        }
        if (this.pedidos == null || this.pedidos.isEmpty()) {
            errores += "- No has ingresado ningun pedido.\n";
        }
        if (errores.length() != 0) {
            Dialogo.mostrar(vista, "Error:\n" + errores);
            return false;
        }
        return true;
    }

    public Cliente clienteElegido(String nombre) {
        for (Cliente clien : contenedor.getClientes()) {
            if (clien.getNombre().equalsIgnoreCase(nombre)) {
                return clien;
            }
        }
        return null;
    }

    public Ciudad ciudadElegida(String nombre) {
        for (Ciudad ciudad : contenedor.getCiudades()) {
            if (ciudad.getNombre().equalsIgnoreCase(nombre)) {
                return ciudad;
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String evento = e.getActionCommand();
        switch (evento) {
            case "Agregar":
                agregarPedido();
                break;
            case "Eliminar":
                eliminarPedido();
                break;
            case "Ingresar":
                ingresar();
                break;
            case "Completado":
                marcar(EstadoViaje.completado);
                break;
            case "Pendiente":
                marcar(EstadoViaje.pendiente);
                break;
            case "Cancelado":
                eliminarTransaccion();
                break;
            case "Regresar":
                this.vista.dispose();
                break;
            default:
                System.out.println("Evento: " + evento);
                break;
        }
    }

    private void agregarPedido() {
        ModalPedido modal = new ModalPedido(this.vista, true, this.contenedor.getProductos());
        modal.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Pedido pedido = modal.getPedido();
                if (pedido != null) {
                    agregarPedido(pedido);
                    Dialogo.mostrar(vista, "¡Pedido agregado!");
                    return;
                }
                Dialogo.mostrar(vista, "No se agregó ningún pedido");
            }
        });
    }

    private void eliminarPedido() {
        int seleccion = this.vista.filaPedidoSeleccionada();
        if (seleccion != -1) {
            this.eliminarPedido(seleccion);
            return;
        }
        Dialogo.mostrar(vista, "No se agregó ningún pedido");
    }
    
    private void eliminarTransaccion() {
        int seleccion = this.vista.filaTransaccionSeleccionada();
        if (seleccion != -1) {
            this.eliminarTransaccion(seleccion);
            return;
        }
        Dialogo.mostrar(vista, "No se agregó ningún pedido");
    }
    
    

    private void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        calcularPeso();
        calcularVolumen();
        this.vista.cargarPedidos(this.pedidos);
    }

    private void eliminarPedido(int index) {
        this.pedidos.remove(index);
        calcularPeso();
        calcularVolumen();
        this.vista.cargarPedidos(this.pedidos);
    }
    
    private void eliminarTransaccion(int index) {
        this.contenedor.getTransacciones().remove(index);
        this.vista.cargarTransacciones();
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
    }

}
