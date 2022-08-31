/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.vista;

import java.awt.Color;
import java.awt.Font;
import trabajofinal.vista.canvas.Plano;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import trabajofinal.modelo.Ciudad;
import trabajofinal.modelo.Enlace;

/**
 *
 * @author paulc
 */
public class Canvas extends JPanel {

    private ArrayList<Ciudad> ciudades;

    public Canvas(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Plano plano = new Plano(800, 800);
        plano.dibujar(g2);
        if (this.ciudades != null && !this.ciudades.isEmpty()) {
            for (Ciudad ciudad : ciudades) {
                int x = ciudad.getStringUbicacionX() * 5;
                int y = ciudad.getStringUbicacionY() * 5;
                g2.setColor(Color.BLACK);
                g2.drawString(ciudad.getNombre(), x, y);
                ArrayList<Enlace> enlaces = ciudad.getCiudadesEnlazadas();
                if (enlaces != null && !enlaces.isEmpty()) {
                    for (Enlace enlace : enlaces) {
                        int x2 = enlace.getCiudad().getStringUbicacionX() * 5;
                        int y2 = enlace.getCiudad().getStringUbicacionY() * 5;
                        g2.setColor(Color.RED);
                        g2.drawLine(x, y, x2, y2);
                    }
                }
            }
        }
    }

}
