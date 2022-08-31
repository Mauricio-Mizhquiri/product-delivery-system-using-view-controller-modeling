package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Contenedor;
import trabajofinal.vista.VistaEmpresas;

public class ControladorEmpresas extends Controlador {
    
    private VistaEmpresas vista;
    
    public ControladorEmpresas(Contenedor contenedor) {
        super(contenedor);
        this.vista = new VistaEmpresas(this.contenedor);
        this.vista.setActionListeners(this);
        this.vista.jButtonGuardarCambios.setVisible(false);
        
    }
    
    public void agregar(){
        for(Ciudad ci: contenedor.getCiudades()){
            if(this.vista.jComboBox.getSelectedItem().equals(ci.getNombre())){
                contenedor.agregarListaOficina(ci);
                JOptionPane.showMessageDialog(vista, "Oficina en la ciudad: "+ci.getNombre());
                break;
            }
            
        }
    }
    public void registrar(){
        this.contenedor.setDireccion((String)this.vista.inputDireccionEmpresa.getText().toUpperCase());
        this.contenedor.setTelefono((String)this.vista.inputTelefonoEmpresa.getText().toUpperCase());
        this.vista.cargarDatos();
        limpiar();
        
    }
    
    public void actualizar(){
        int seleccion = vista.tablaDatonEmpresa.getSelectedRow();
        if(seleccion >= 0){
            this.vista.jPanelActualizar.setVisible(false);
            this.vista.jButtonGuardarCambios.setVisible(true);
             this.vista.inputDireccionEmpresa.setText(String.valueOf(this.vista.tablaDatonEmpresa.getValueAt(seleccion, 1)));
             this.vista.inputTelefonoEmpresa.setText(String.valueOf(this.vista.tablaDatonEmpresa.getValueAt(seleccion, 2)));
        }else{
            JOptionPane.showMessageDialog(vista,"Seleccione una fila de la tabla");
        }
    }
    public void guardarCambios(){
        int seleccion = vista.tablaDatonEmpresa.getSelectedRow();
        contenedor.setDireccion(this.vista.inputDireccionEmpresa.getText().toUpperCase());
        contenedor.setTelefono(this.vista.inputTelefonoEmpresa.getText().toUpperCase());
        this.vista.jPanelActualizar.setVisible(true);
        this.vista.jButtonAgregar.setVisible(false);
        this.vista.cargarDatos();
        limpiar();
    }
    public void limpiar(){
        this.vista.inputDireccionEmpresa.setText("");
        this.vista.inputTelefonoEmpresa.setText("");
    }
    
    public void eliminar(){
        int seleccion = vista.tablaDatonEmpresa.getSelectedRow();
        if(seleccion >= 0 && this.vista.tablaDatonEmpresa.getRowCount() != 0){
            this.vista.tablaDatonEmpresa.removeAll();
            //this.contenedor.eliminarLista(this.contenedor.getClientes().get(seleccion));
            this.vista.cargarDatos();
        }else{
            JOptionPane.showMessageDialog(vista,"Seleccione una fila de la tabla");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String evento = e.getActionCommand();
        switch(evento){
            case "Agregar":
                agregar();
                break;
            case "Registrar":
                registrar();
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
                this.vista.setVisible(false);
                break;
            default:
                System.out.println("Evento: "+evento);
                break;
        }
        
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
    }
}
