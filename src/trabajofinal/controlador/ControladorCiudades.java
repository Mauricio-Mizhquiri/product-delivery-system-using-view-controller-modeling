package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.TableModelEvent;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Contenedor;
import trabajofinal.modelo.Ubicacion;
import trabajofinal.utils.Dialogo;
import trabajofinal.vista.VistaCiudades;

public class ControladorCiudades extends Controlador {

    final private VistaCiudades vista;

    public ControladorCiudades(Contenedor contenedor) {
        super(contenedor);
        this.vista = new VistaCiudades(this.contenedor);
        this.vista.setLocationRelativeTo(null);
        this.vista.cargarDatos();
        this.vista.setActionListeners(this);
        this.vista.setTableListeners(this);
        this.vista.jButtonGuardarCambios.setVisible(false);
        this.vista.jButtonGuardar.setVisible(false);

    }

    private void agregarCiudad() {
        this.vista.jButtonGuardar.setVisible(false);
        if (!existe(vista.getInputNombreCiudad(),vista.getInputUbicacionX(),vista.getInputUbicacionY()) && (!vista.getInputNombreCiudad().isEmpty())) {
            this.contenedor.agregarLista(new Ciudad(
                    this.vista.getInputNombreCiudad().toUpperCase(),
                    new Ubicacion(
                            this.vista.getInputUbicacionX(),
                            this.vista.getInputUbicacionY()),
                    new ArrayList<>()
            ));
            this.vista.cargarDatos();
        } else {
            JOptionPane.showMessageDialog(vista, "Imposible crear");
        }
        limpiar();
    }

    private boolean existe(String nombreCiudad,int ubicacionX,int ubicacionY) {
        for (Ciudad ciudad : contenedor.getCiudades()) {
            if (ciudad.getNombre().equalsIgnoreCase(nombreCiudad) ||(ciudad.getStringUbicacionX()==ubicacionX &&ciudad.getStringUbicacionY()==ubicacionY)) {
                return true;
            }

        }
        
        return false;
    }

    private void enlaces() {
        this.vista.jButtonGuardar.setVisible(true);
        this.vista.jPanelActualizar.setVisible(false);
        ArrayList<Ciudad> ciudades = this.contenedor.getCiudades();
        if (ciudades != null && !ciudades.isEmpty()) {
            new ControladorEnlaceCiudades(contenedor);
            this.vista.cargarDatos();
            return;
        }
        JOptionPane.showMessageDialog(vista, "No existen ciudades a enlazar");
    }

    private void actualizar() {
        int seleccion = vista.tablaDatos.getSelectedRow();
        if (seleccion >= 0 && this.vista.tablaDatos.getRowCount() != 0) {
            this.vista.jPanelActualizar.setVisible(false);
            this.vista.jButtonGuardarCambios.setVisible(true);
            this.vista.inputNombreCiudad.setText(String.valueOf(this.vista.tablaDatos.getValueAt(seleccion, 0)));
            this.vista.inputUbicacionX.setValue(this.vista.tablaDatos.getValueAt(seleccion, 1));
            this.vista.inputUbicacionY.setValue(this.vista.tablaDatos.getValueAt(seleccion, 2));
            return;
        }
        JOptionPane.showMessageDialog(vista, "Seleccione una fila de la tabla");
    }

    private void guardar() {
        int seleccion = vista.tablaDatos.getSelectedRow();
        contenedor.getCiudades().get(seleccion).setNombre(this.vista.getInputNombreCiudad().toUpperCase());
        contenedor.getCiudades().get(seleccion).setUbicacion(new Ubicacion(this.vista.getInputUbicacionX(), this.vista.getInputUbicacionY()));
        this.vista.cargarDatos();
        this.vista.jPanelActualizar.setVisible(true);
        this.vista.jButtonGuardarCambios.setVisible(false);
        limpiar();
    }

    private void limpiar() {
        this.vista.inputNombreCiudad.setText("");
        this.vista.inputUbicacionX.setValue(((SpinnerNumberModel) this.vista.inputUbicacionX.getModel()).getMinimum());
        this.vista.inputUbicacionY.setValue(((SpinnerNumberModel) this.vista.inputUbicacionY.getModel()).getMinimum());
    }

    private void eliminarCiudad() {
        int seleccion = vista.tablaDatos.getSelectedRow();
        if (seleccion >= 0 && this.vista.tablaDatos.getRowCount() != 0) {       
            for(int i=0;i<this.contenedor.getTransacciones().size();i++){
                if(this.contenedor.getCiudades().get(seleccion).getNombre().equals(this.contenedor.getTransacciones().get(i).getOrigen().getNombre())
                  || this.contenedor.getCiudades().get(seleccion).getNombre().equals(this.contenedor.getTransacciones().get(i).getDestino().getNombre())){
                    JOptionPane.showMessageDialog(null,"Hay viajes pendientes con esta ciudad");
                    return;
                }
            }
            for(int i=0;i<this.contenedor.getClientes().size();i++){
                for(int j=0;j<this.contenedor.getClientes().get(i).getCiudad().size();j++){
                    if(this.contenedor.getCiudades().get(seleccion).getNombre().equals(this.contenedor.getClientes().get(i).getCiudad().get(j).getNombre())){
                        JOptionPane.showMessageDialog(null,"Hay clientes relacionados a esta ciudad");
                        return;
                    }                      
                }
            }
            this.contenedor.eliminarLista(this.contenedor.getCiudades().get(seleccion));
            this.vista.cargarDatos();
            return;
        }
        Dialogo.mostrar(this.vista, "Seleccione una fila de la tabla");
    }

    public void guardarC() {
        this.vista.cargarDatos();
        this.vista.jPanelActualizar.setVisible(true);
        this.vista.jButtonGuardar.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String evento = e.getActionCommand();
        switch (evento) {
            case "Enlazar Ciudades":
                enlaces();
                break;
            case "Actualizar":
                guardarC();
                break;
            case "Crear":
                agregarCiudad();
                break;
            case "Modificar":
                actualizar();
                break;
            case "Guardar Cambios":
                guardar();
                break;
            case "Eliminar":
                eliminarCiudad();
                break;
            case "Salir":
                this.vista.dispose();
            default:
                System.out.println("Evento: " + evento);
                break;
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
    }
}
