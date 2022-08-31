/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.utils;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author Michael Peñaloza
 */
public class ValidacionTeclado {
    public static void SNumeros(JTextField a){
        a.addKeyListener(new KeyListener() {
           @Override
            public void keyTyped(KeyEvent ke) {
              char c  = ke.getKeyChar();
              if(Character.isLetter(c))
              {               
                ///getToolKit().beep();
                Toolkit.getDefaultToolkit().beep();
                ke.consume();
              }                
            }

           @Override
            public void keyPressed(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

           @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }            

      });
    }  
    public static void SLetras(JTextField a){
        a.addKeyListener(new KeyListener() {
           @Override
            public void keyTyped(KeyEvent ke) {
              char c  = ke.getKeyChar();
              if(Character.isDigit(c))
              {               
                ///getToolKit().beep();
                Toolkit.getDefaultToolkit().beep();
                ke.consume();
              }                
            }

           @Override
            public void keyPressed(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

           @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }            

      });
    }      
}
