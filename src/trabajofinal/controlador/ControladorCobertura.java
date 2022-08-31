/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.controlador;

import trabajofinal.modelo.Contenedor;
import trabajofinal.vista.VistaCobertura;

/**
 *
 * @author paulc
 */
public class ControladorCobertura extends Controlador {
    
    private VistaCobertura vista;
    public ControladorCobertura(Contenedor contenedor) {
        super(contenedor);
        this.vista = new VistaCobertura(this.contenedor);
        this.cargarCanvas();
    }
    
    private void cargarCanvas() {
    }
    
}
