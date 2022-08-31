package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import trabajofinal.modelo.Contenedor;
import trabajofinal.modelo.Ordenamientos;
import trabajofinal.modelo.Transaccion;
import trabajofinal.modelo.Vehiculo;
import trabajofinal.vista.VistaReportes;
import trabajofinal.vista.VistaTransacciones;

public class ControladorReportes extends Controlador {

    private VistaReportes vista;
    Ordenamientos ordenar;

    public ControladorReportes(Contenedor contenedor) {
        super(contenedor);
        this.vista = new VistaReportes(contenedor);
        this.vista.setActionListeners(this);
        this.vista.setLocationRelativeTo(null);
        this.vista.setResizable(false);
        this.ordenar = new Ordenamientos();

    }

    public void reportar() {
        String opcion = (String) this.vista.jComboBoxTipo.getSelectedItem();
        switch (opcion) {
            case "Vehiculos Ordenados Por placa":
                this.vista.jTextArea.setText("");
                this.vista.jTextArea.append("PLACA ACTUAL\n\n");
                mostrarPlaca();
                ordenarPlaca();
                this.vista.jTextArea.append("\n\nPLACA ORDENADA\n\n");
                mostrarPlaca();

                break;
            case "Viajes contratados por fecha":
                this.vista.jTextArea.setText("");
                this.vista.jTextArea.append("FECHA ACTUAL\n\n");
                mostrarFecha();
                ordenarFecha();
                this.vista.jTextArea.append("\n\nFECHA ORDENADA\n\n");
                mostrarFecha();

                break;
            case "Viajes contratados por ciudad":
                this.vista.jTextArea.setText("");
                this.vista.jTextArea.append("CIUDAD ACTUAL\n\n");
                mostrarCiudad();
                ordenarCiudad();
                this.vista.jTextArea.append("\n\nCIUDAD ORDENADA\n\n");
                mostrarCiudad();
                
                break;
            default:
                System.out.println("opcion: " + opcion);
                break;
        }
    }

    public void mostrarPlaca() {
        this.vista.jTextArea.append("");
        for (Vehiculo v : contenedor.getVehiculos()) {
            this.vista.jTextArea.append(v.getPlaca() + "\n");
        }
    }
    public void mostrarFecha() {
        this.vista.jTextArea.append("");
        for (Transaccion v : contenedor.getTransacciones()) {
            this.vista.jTextArea.append(v.getFecha() + "\n");
        }
    }
    public void mostrarCiudad() {
        this.vista.jTextArea.append("");
        for (Transaccion v : contenedor.getTransacciones()) {
            this.vista.jTextArea.append(v.getDestino().getNombre() + "\n");
        }
    }
    public void ordenarPlaca() {
        String evento = (String) this.vista.jComboBoxAlgoritmo.getSelectedItem();
        switch (evento) {
            case "MergeSort":
                ordenar.mergeSortPlaca(contenedor.getVehiculos());this.vista.jTextArea.removeAll();
                break;
            case "QuickSort":
                ordenar.quicksortVehiclo(contenedor.getVehiculos(), 0, contenedor.getVehiculos().size() - 1);this.vista.jTextArea.removeAll();
                break;
            case "HeapSort":
                ordenar.HeapVehiculo(contenedor.getVehiculos());this.vista.jTextArea.removeAll();
                break;
            default:
                break;
        }
    }

    public void ordenarFecha() {
        String evento = (String) this.vista.jComboBoxAlgoritmo.getSelectedItem();
        switch (evento) {
            case "MergeSort":
                ordenar.mergeSortTransaccion(contenedor.getTransacciones(), true, false);this.vista.jTextArea.removeAll();
                break;
            case "QuickSort":
                ordenar.quicksortContrato(contenedor.getTransacciones(), 0, contenedor.getTransacciones().size() - 1, true, false);this.vista.jTextArea.removeAll();
                break;
            case "HeapSort":
                ordenar.HeapContrato(contenedor.getTransacciones(), true, false);this.vista.jTextArea.removeAll();
                break;
            default:
                break;
        }
    }

    public void ordenarCiudad() {
        String evento = (String) this.vista.jComboBoxAlgoritmo.getSelectedItem();
        switch (evento) {
            case "MergeSort":
                ordenar.mergeSortTransaccion(contenedor.getTransacciones(), false, true);this.vista.jTextArea.removeAll();
                break;
            case "QuickSort":
                ordenar.quicksortContrato(contenedor.getTransacciones(), 0, contenedor.getTransacciones().size() - 1, false, true);this.vista.jTextArea.removeAll();
                break;
            case "HeapSort":
                ordenar.HeapContrato(contenedor.getTransacciones(), false, true);this.vista.jTextArea.removeAll();

                break;
            default:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String evento = e.getActionCommand();
        switch (evento) {
            case "Reportar":
                reportar();
                break;
            case "Regresar":
                this.vista.setVisible(false);
                break;
            default:
                System.out.println("Evento: " + evento);
                break;

        }
    }
}
