package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import trabajofinal.modelo.CaracteristicaEspecial;
import trabajofinal.modelo.Contenedor;
import trabajofinal.vista.VistaCaracteristicasEspeciales;

public class ControladorCaracteristicasEspeciales extends Controlador {

    private VistaCaracteristicasEspeciales vista;

    public ControladorCaracteristicasEspeciales(Contenedor contenedor) {
        super(contenedor);
        this.vista = new VistaCaracteristicasEspeciales(this.contenedor);
        this.vista.setActionListeners(this);
        this.vista.setTableListeners(this);
        this.vista.cargarDatosCaracteristicasEspeciales();
        this.vista.jButtonGuardarCambios.setVisible(false);
    }

    public void agregarCaracteristicasEspeciales() {
        this.contenedor.agregarLista(new CaracteristicaEspecial(
                this.vista.getInputNombreCaracteristicasEspecial().toUpperCase(),
                this.vista.getInputDescripcionCaracteristicasEspecial().toUpperCase()));
        this.vista.cargarDatosCaracteristicasEspeciales();
        limpiar();
    }

    public void actualizar() {
        int seleccion = vista.tablaCaracteristicasEspeciales.getSelectedRow();
        if (seleccion >= 0 && this.vista.tablaCaracteristicasEspeciales.getRowCount() != 0) {
            this.vista.jPanelActualizar.setVisible(false);
            this.vista.jButtonGuardarCambios.setVisible(true);

            this.vista.inputNombreCaracteristicaEspecial.setText(String.valueOf(this.vista.tablaCaracteristicasEspeciales.getValueAt(seleccion, 0)));
            this.vista.setInputDescriptionText(String.valueOf(this.vista.tablaCaracteristicasEspeciales.getValueAt(seleccion, 1)));
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione una fila de la tabla");
        }

    }

    public void guardarCambios() {
        int seleccion = vista.tablaCaracteristicasEspeciales.getSelectedRow();
        contenedor.getCaracteristicasEspeciales().get(seleccion).setNombre(this.vista.getInputNombreCaracteristicasEspecial().toUpperCase());
        contenedor.getCaracteristicasEspeciales().get(seleccion).setDescripcion(this.vista.getInputDescripcionCaracteristicasEspecial().toUpperCase());
        this.vista.cargarDatosCaracteristicasEspeciales();
        this.vista.jPanelActualizar.setVisible(true);
        this.vista.jButtonGuardarCambios.setVisible(false);
        limpiar();

    }

    public void eliminar() {

        int seleccion = vista.tablaCaracteristicasEspeciales.getSelectedRow();
        if (seleccion >= 0 && this.vista.tablaCaracteristicasEspeciales.getRowCount() != 0) {
            for(int i=0;i<this.contenedor.getProductos().size();i++){
                for(int j=0;j<this.contenedor.getProductos().get(i).getCaracteristicasEspeciales().size();j++)
                   if(this.contenedor.getCaracteristicasEspeciales().get(seleccion).getNombre().equals(this.contenedor.getProductos().get(i).getCaracteristicasEspeciales().get(j).getNombre())){
                       JOptionPane.showMessageDialog(null,"Esta ligado a un producto");
                       return;
            }
            }
            this.contenedor.eliminarLista(this.contenedor.getCaracteristicasEspeciales().get(seleccion));
            this.vista.cargarDatosCaracteristicasEspeciales();
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione una fila de la tabla");
        }

    }

    @Override
    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e); //To change body of generated methods, choose Tools | Templates.

    }

    public void limpiar() {
        this.vista.inputNombreCaracteristicaEspecial.setText("");
        this.vista.setInputDescriptionText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e); //To change body of generated methods, choose Tools | Templates.
        String evento = e.getActionCommand();
        switch (evento) {
            case "Registrar":
                agregarCaracteristicasEspeciales();
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
                ;
                break;
            default:
                System.out.println("Evento: " + evento);
                break;
        }
    }

}
