
package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import javax.swing.event.TableModelEvent;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Conductor;
import trabajofinal.modelo.Contenedor;
import trabajofinal.vista.VistaConductores;

public class ControladorConductores extends Controlador {
    
    private VistaConductores vista;
    
    public ControladorConductores(Contenedor contenedor) {
        super(contenedor);
        this.vista = new VistaConductores(this.contenedor);
        this.vista.setActionListeners(this);
        this.vista.setResizable(false);
        this.vista.setLocationRelativeTo(null);
        this.vista.cargarDatos();
    }
    public void registrar(){
        for(Ciudad ciu: contenedor.getCiudades()){
            if(ciu.getNombre().equals(this.vista.jComboBoxCiudades.getSelectedItem())){
                this.contenedor.agregarLista(new Conductor(this.vista.jTextFieldNombre.getText().toUpperCase(),this.vista.jTextFieldCedula.getText(), ciu));
            }
        }
        this.vista.cargarDatos();
        limpiar();
        for(Conductor cnd: contenedor.getConductores()){
            System.out.println("Conductor-> "+cnd.getNombre());
        }
    }
    public void limpiar(){
        this.vista.jTextFieldNombre.setText("");
        this.vista.jTextFieldCedula.setText("");
        this.vista.jComboBoxCiudades.setSelectedIndex(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String evento = e.getActionCommand();
        switch(evento){
            case "Registrar":
                registrar();
                break;
            case "Salir":
                this.vista.setVisible(false);
                break;
            default:
                System.out.println("Evento: "+evento);
        }
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
        
    }
}
