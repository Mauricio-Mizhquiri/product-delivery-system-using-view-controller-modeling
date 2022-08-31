/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.vista;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.event.TableModelListener;
import trabajofinal.modelo.Contenedor;

public class Vista extends javax.swing.JFrame {
    
    protected Contenedor contenedor;

    public Vista(Contenedor contenedor) {
        this.contenedor = contenedor;
        this.setVisible(true);
    }
    
    public void setActionListeners(ActionListener controlador) {}
    
    public void setTableListeners(TableModelListener controlador) {}
    
    public void setKeyListeners(KeyListener controlador) {}

    
}
