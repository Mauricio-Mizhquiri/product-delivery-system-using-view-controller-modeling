
package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import javax.swing.event.TableModelEvent;
import trabajofinal.modelo.Contenedor;
import trabajofinal.vista.VistaPrincipal;

public class ControladorPrincipal extends Controlador {

    private VistaPrincipal vista;
    
    public ControladorPrincipal(Contenedor contenedor) {
        super(contenedor);
        this.vista = new VistaPrincipal(contenedor);
        this.vista.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String evento = e.getActionCommand();
        switch (evento) {
            case "Ciudades":
                new ControladorCiudades(this.contenedor);
                break;
            case "Productos":
                new ControladorProductos(this.contenedor);
                break;
            case "Clientes":
                new ControladorClientes(this.contenedor);
                break;
            case "Caracteristicas":
                new ControladorCaracteristicasEspeciales(this.contenedor);
                break;
            case "Empresa":
                new ControladorEmpresas(this.contenedor);
                break;
            case "Vehiculos":
                new ControladorVehiculos(this.contenedor);
                break;
            case "Conductores":
                new ControladorConductores(this.contenedor);
                break;
            case "Salir":
                System.exit(0);
            case "Transacciones":
                new ControladorTransacciones(this.contenedor);
                break;
            case "Reportes":
                new ControladorReportes(this.contenedor);
                break;
            case "Cobertura":
                new ControladorCobertura(this.contenedor);
                break;
            default:
                throw new UnsupportedOperationException("Not supported yet.");
                
        }
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
    }

}
