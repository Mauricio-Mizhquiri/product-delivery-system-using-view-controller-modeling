/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import trabajofinal.modelo.Contenedor;

/**
 *
 * @author paulc
 */
public class Controlador implements ActionListener, TableModelListener {

    protected Contenedor contenedor;

    public Controlador(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Accion: " + e.getActionCommand());
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        Object source = e.getSource();
        System.out.println(source);
    }   
    
}
