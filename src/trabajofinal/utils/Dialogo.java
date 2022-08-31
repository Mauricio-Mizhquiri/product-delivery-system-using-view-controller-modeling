/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.utils;

import javax.swing.JOptionPane;
import trabajofinal.vista.Vista;

/**
 *
 * @author paulc
 */
public class Dialogo {
    public static void mostrar(Vista vista, String mensaje) {
        JOptionPane.showMessageDialog(vista, mensaje);
    }
    
    public static int numero(Vista vista, String mensaje, int valorInicial, int valorMaximo) {
        try {
            String input = JOptionPane.showInputDialog(vista, mensaje, valorInicial);
            int numero = Integer.parseInt(input);
            if (numero > 0 && numero <= valorMaximo) {
                return numero;
            }
            return  -1;
        } catch (NumberFormatException error) {
            return -1;
        }
    }
    
    public static String texto(Vista vista, String mensaje, String valorInicial) {
        String input = JOptionPane.showInputDialog(vista, mensaje, valorInicial);
        if (input != null && input.length() > 0){
            return input;
        }
        return null;
    }
}
