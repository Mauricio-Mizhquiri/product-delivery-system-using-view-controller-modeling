package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Cliente;
import trabajofinal.modelo.Contenedor;
import trabajofinal.modelo.Transaccion;
import trabajofinal.utils.Dialogo;
import trabajofinal.vista.VistaClientes;

public class ControladorClientes extends Controlador {

    private VistaClientes vista;
    private ArrayList<Ciudad> ciudades;

    public ControladorClientes(Contenedor contenedor) {
        super(contenedor);
        this.vista = new VistaClientes(this.contenedor);
        this.vista.setLocationRelativeTo(null);
        this.vista.setActionListeners(this);
        this.vista.setTableListeners(this);
        this.vista.cargarDatosClientes();
        this.ciudades = new ArrayList<>();
        this.vista.jButtonGuardarCambios.setVisible(false);
    }

    public void agregar() {
        for (Ciudad cu : contenedor.getCiudades()) {
            if (this.vista.jComboBoxNegocios.getSelectedItem().equals(cu.getNombre())) {
                this.ciudades.add(cu);
            }
        }
        for (Ciudad ciu : ciudades) {
            System.out.println("Ciudad: " + ciu.getNombre() + " -> ");
        }
    }

    public void registrarCliente() {
        this.contenedor.agregarLista(new Cliente(
                ciudades,
                true,
                this.vista.getInputNombreCliente().toUpperCase(),
                this.vista.getInputDireccionCliente().toUpperCase(),
                this.vista.getInputTelefonoCliente(),
                this.vista.getInputCorreoCliente()));
        this.vista.cargarDatosClientes();
        limpiar();
        ciudades = new ArrayList<>();
    }

    public void limpiar() {
        this.vista.inputNombreCliente.setText("");
        this.vista.inputTelefonoCliente.setText("");
        this.vista.inputDireccionCliente.setText("");
        this.vista.inputCorreoCliente.setText("");
        this.vista.jComboBoxNegocios.setSelectedIndex(0);
    }

    public void actualizar() {
        int seleccion = vista.tablaDatosClientes.getSelectedRow();
        if (seleccion >= 0 && this.vista.tablaDatosClientes.getRowCount() != 0) {
            this.vista.jPanelActualizar.setVisible(false);
            this.vista.jButtonGuardarCambios.setVisible(true);
            this.vista.inputNombreCliente.setText(String.valueOf(this.vista.tablaDatosClientes.getValueAt(seleccion, 0)));
            this.vista.inputDireccionCliente.setText(String.valueOf(this.vista.tablaDatosClientes.getValueAt(seleccion, 1)));
            this.vista.inputTelefonoCliente.setText(String.valueOf(this.vista.tablaDatosClientes.getValueAt(seleccion, 2)));
            this.vista.inputCorreoCliente.setText(String.valueOf(this.vista.tablaDatosClientes.getValueAt(seleccion, 3)));
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione una fila de la tabla");
        }
    }

    public void guardarCambios() {
        int seleccion = vista.tablaDatosClientes.getSelectedRow();
        contenedor.getClientes().get(seleccion).setNombre(this.vista.getInputNombreCliente().toUpperCase());
        contenedor.getClientes().get(seleccion).setDireccion(this.vista.getInputDireccionCliente().toUpperCase());
        contenedor.getClientes().get(seleccion).setTelefono(this.vista.getInputTelefonoCliente());
        contenedor.getClientes().get(seleccion).setCorreo(this.vista.getInputCorreoCliente().toUpperCase());
        this.vista.cargarDatosClientes();
        this.vista.jPanelActualizar.setVisible(true);
        this.vista.jButtonGuardarCambios.setVisible(false);
        limpiar();
    }

    public void eliminar() {
        int seleccion = vista.tablaDatosClientes.getSelectedRow();
        ArrayList<Transaccion> transacciones = this.contenedor.getTransacciones();
        if (seleccion != -1) {
            Cliente cliente = this.contenedor.getClientes().get(seleccion);
            if (!tieneTransacciones(cliente, transacciones)) {
                this.contenedor.eliminarLista(this.contenedor.getClientes().get(seleccion));
                this.vista.cargarDatosClientes();
                return;
            }
            Dialogo.mostrar(vista, "No se puede eliminar cliente con transacciones");
            return;
        }
        Dialogo.mostrar(vista, "Seleccione una fila de la tabla");
    }

    private boolean tieneTransacciones(Cliente cliente, ArrayList<Transaccion> transacciones) {
        if (transacciones != null && !transacciones.isEmpty()) {
            for (Transaccion transaccion: transacciones) {
                if (transaccion.getCliente().equals(cliente)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String evento = e.getActionCommand();
        switch (evento) {
            case "Agregar":
                agregar();
                break;
            case "Registrar":
                registrarCliente();
                break;
            case "Actualizar":
                actualizar();
                break;
            case "Guardar Cambios":
                guardarCambios();
                break;
            case "Eliminar":
                eliminar();
                break;
            case "Regresar":
                this.vista.dispose();
            default:
                break;
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
    }

}
