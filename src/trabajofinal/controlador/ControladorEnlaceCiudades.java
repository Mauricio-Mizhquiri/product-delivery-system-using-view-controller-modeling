
package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Contenedor;
import trabajofinal.modelo.Enlace;
import trabajofinal.vista.VistaEnlaceCiudades;

public class ControladorEnlaceCiudades extends Controlador {
    
    private VistaEnlaceCiudades vista;
    
    public ControladorEnlaceCiudades(Contenedor contenedor) {
        super(contenedor);
        this.vista = new VistaEnlaceCiudades(this.contenedor);
        this.vista.setActionListeners(this);
        
    }
    public void agregar(){
        //contenedor.getCiudades().get(this.vista.jComboBox.getSelectedIndex()).getCiudadesEnlazadas().add(new Enlace(this.contenedor.getCiudades().get(this.vista.jComboBoxCiudades.getSelectedIndex()),(int)this.vista.jSpinnerTiempoViaje.getValue()));
        for(Ciudad ciu: contenedor.getCiudades()){
            if(ciu.getNombre().equals((String)vista.jComboBox.getSelectedItem())){
                for(Ciudad ciudad: contenedor.getCiudades()){
                    if(((String)vista.jComboBoxCiudades.getSelectedItem()).equals(ciudad.getNombre())&&!(this.vista.jComboBox.getSelectedItem().equals(vista.jComboBoxCiudades.getSelectedItem()))){
                        Enlace nuevo = new Enlace(ciudad,(int)vista.jSpinnerTiempoViaje.getValue());
                        ciu.getCiudadesEnlazadas().add(nuevo);
                        JOptionPane.showMessageDialog(vista, "Ciudad: "+ciu.getNombre()+" Enlazada correctamente");
                        llenarDatos();
                    }
                }
                
            }
        }
        
    }
    public void llenarDatos(){
        vista.jTextArea1.append(vista.jComboBox.getSelectedItem()+"\t"+vista.jComboBoxCiudades.getSelectedItem()+"\t\t"+vista.jSpinnerTiempoViaje.getValue()+"\n");
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String evento = e.getActionCommand();
        switch(evento){
            case "Agregar":
                agregar();
                break;
            case "Aceptar":
                this.vista.dispose();
                break;
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
