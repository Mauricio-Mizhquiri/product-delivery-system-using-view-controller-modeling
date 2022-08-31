package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import trabajofinal.modelo.CaracteristicaEspecial;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Contenedor;
import trabajofinal.modelo.Vehiculo;
import trabajofinal.vista.VistaVehiculos;

public class ControladorVehiculos extends Controlador {

    private VistaVehiculos vista;

    private ArrayList<CaracteristicaEspecial> caracteristica;
    private Ciudad ciudad;

    public ControladorVehiculos(Contenedor contenedor) {
        super(contenedor);
        this.vista = new VistaVehiculos(this.contenedor);
        this.caracteristica = new ArrayList<>();
        this.vista.cargarDatos();
        this.vista.setActionListeners(this);
        this.vista.setTableListeners(this);
        ciudad = new Ciudad();
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
                this.agregarVehiculo();
                break;
            case "Regresar":
                this.vista.setVisible(false);
                break;
            default:
                System.out.println("Evento: " + evento);
                break;

        }
    }

    private void agregarVehiculo() {
        ciudad = agregarCiudad((String) this.vista.jComboBoxCiudad.getSelectedItem());
        if (ciudad != null) {
            this.contenedor.agregarLista(
                    new Vehiculo(
                            this.vista.getPlaca().toUpperCase(),
                            this.vista.getMarca().toUpperCase(),
                            this.vista.getModelo().toUpperCase(),
                            ciudad,
                            this.vista.getPesoMaximo(),
                            this.vista.getVolumenMaximo(),
                            caracteristica
                    )
            );
            this.vista.cargarDatos();
            caracteristica = new ArrayList<>();
            limpiar();
        }
    }
    public void limpiar(){
        this.vista.inputPlaca.setText("");
        this.vista.inputMarca.setText("");
        this.vista.inputModelo.setText("");
        this.vista.inputPesoMaximo.setText("");
        this.vista.jComboBoxCiudad.setSelectedIndex(0);
        this.vista.inputVolumenMaximo.setText("");
        this.vista.jComboBoxCaracteristica.setSelectedIndex(0);
    }
    public void agregar() {
        for (CaracteristicaEspecial caracteris : contenedor.getCaracteristicasEspeciales()) {
            if (this.vista.jComboBoxCaracteristica.getSelectedItem().equals(caracteris.getNombre())) {
                caracteristica.add(caracteris);
            }
        }
        this.vista.cargarDatos();
        this.vista.jComboBoxCaracteristica.setSelectedIndex(0);
    }

    public Ciudad agregarCiudad(String ciudad) {
        for (Ciudad ciu : contenedor.getCiudades()) {
            if (ciu.getNombre().equals(ciudad)) {
                return ciu;
            }
        }
        return null;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);

    }

}
