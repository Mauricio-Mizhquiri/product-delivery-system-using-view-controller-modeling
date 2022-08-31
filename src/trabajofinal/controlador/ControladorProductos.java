package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import trabajofinal.modelo.CaracteristicaEspecial;
import trabajofinal.modelo.Contenedor;
import trabajofinal.modelo.Pedido;
import trabajofinal.modelo.Producto;
import trabajofinal.modelo.Transaccion;
import trabajofinal.utils.Dialogo;
import trabajofinal.vista.VistaProductos;

public class ControladorProductos extends Controlador {

    private VistaProductos vista;
    private ArrayList<CaracteristicaEspecial> caracteristicas;

    public ControladorProductos(Contenedor contenedor) {
        super(contenedor);
        this.vista = new VistaProductos(this.contenedor);
        this.caracteristicas = new ArrayList<>();
        this.vista.setActionListeners(this);
        this.vista.setTableListeners(this);
        this.vista.cargarDatosProductos();
        this.vista.jButtonGuardarCambios.setVisible(false);
    }

    public void agregar() {
        for (CaracteristicaEspecial carac : contenedor.getCaracteristicasEspeciales()) {
            if ((this.vista.jComboBox1.getSelectedItem()).equals(carac.getNombre())) {
                //CaracteristicaEspecial caracteristica = new CaracteristicaEspecial(carac.getNombre().toUpperCase(), carac.getDescripcion().toUpperCase());
                caracteristicas.add(carac);
                JOptionPane.showMessageDialog(vista, "Caractistica: " + carac.getNombre() + " Enlazada Correctamente");
            }
        }
        //this.vista.cargarDatosProductos();
        this.vista.jComboBox1.setSelectedIndex(0);
    }

    public void limpiar() {
        this.vista.inputNombreProducto.setText("");
        this.vista.inputTipoUnidad.setText("");
        this.vista.inputPeso.setText("");
        this.vista.inputVolumen.setText("");
    }

    public void registrarProducto() {

        this.contenedor.agregarLista(new Producto(
                this.vista.getInputNombreProducto().toUpperCase(),
                this.vista.getInputPeso(),
                this.vista.getInputVolumen(),
                caracteristicas,
                this.vista.getInputTipoUnidad().toUpperCase()));
        this.vista.cargarDatosProductos();
        limpiar();
        caracteristicas = new ArrayList<>();
    }

    public void actualizar() {
        //visibilidad de botones innecesarios
        int seleccion = vista.tablaDatosProductos.getSelectedRow();
        if (seleccion >= 0 && this.vista.tablaDatosProductos.getRowCount() != 0) {
            this.vista.jButtonGuardarCambios.setVisible(true);
            this.vista.jPanelActualizar.setVisible(false);
            this.vista.jButtonAgregar.setVisible(false);
            this.vista.jComboBox1.setVisible(false);
            this.vista.labelCaracteristicasEspeciales.setVisible(false);

            this.vista.inputNombreProducto.setText(String.valueOf(this.vista.tablaDatosProductos.getValueAt(seleccion, 0)));
            this.vista.inputTipoUnidad.setText(String.valueOf(this.vista.tablaDatosProductos.getValueAt(seleccion, 1)));
            this.vista.inputPeso.setText(String.valueOf(this.vista.tablaDatosProductos.getValueAt(seleccion, 2)));
            this.vista.inputVolumen.setText(String.valueOf(this.vista.tablaDatosProductos.getValueAt(seleccion, 3)));
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione una fila de la tabla");
        }

    }

    public void guardar() {

        int seleccion = vista.tablaDatosProductos.getSelectedRow();

        contenedor.getProductos().get(seleccion).setNombre(this.vista.getInputNombreProducto().toUpperCase());
        contenedor.getProductos().get(seleccion).setTipoUnidad(this.vista.getInputTipoUnidad().toUpperCase());
        contenedor.getProductos().get(seleccion).setPeso(this.vista.getInputPeso());
        contenedor.getProductos().get(seleccion).setVolumen(this.vista.getInputVolumen());
        this.vista.cargarDatosProductos();
        limpiar();
        this.vista.jButtonGuardarCambios.setVisible(false);
        this.vista.jPanelActualizar.setVisible(true);
        this.vista.jButtonAgregar.setVisible(true);
        this.vista.jComboBox1.setVisible(true);
        this.vista.labelCaracteristicasEspeciales.setVisible(true);
    }

    public void eliminar() {
        int seleccion = vista.tablaDatosProductos.getSelectedRow();
        if (seleccion != -1) {
            Producto producto = this.contenedor.getProductos().get(seleccion);
            if (producto != null) {
                ArrayList<Transaccion> transacciones = this.contenedor.getTransacciones();
                if (!this.tieneProducto(producto, transacciones)) {
                    this.contenedor.eliminarLista(producto);
                    this.vista.cargarDatosProductos();
                    return;
                }
                Dialogo.mostrar(vista, "Error, el producto seleccionado no se puede eliminar");
                return;
            }
        }
        Dialogo.mostrar(vista, "Seleccione una fila de la tabla");
    }

    private boolean tieneProducto(Producto producto, ArrayList<Transaccion> transacciones) {
        if (transacciones != null && !transacciones.isEmpty()) {
            for (Transaccion transaccion : transacciones) {
                for (Pedido pedido : transaccion.getPedidos()) {
                    if (pedido.getProducto().equals(producto)) {
                        return true;
                    }
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
                registrarProducto();
                break;
            case "Actualizar":
                actualizar();
                break;
            case "Guardar Cambios":
                guardar();
                break;
            case "Eliminar":
                eliminar();
                break;
            case "Reportar":
                System.out.println("Reportar...................");
                break;
            case "Salir":
                this.vista.dispose();

                break;
            default:
                break;
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
    }

}
