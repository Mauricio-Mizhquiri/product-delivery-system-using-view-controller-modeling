/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.vista.canvas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *
 * @author paulc
 */
public class Plano {

    private double ancho;
    private double alto;

    public Plano(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;

    }

    public void dibujar(Graphics2D g) {

        for (int i = 0; i < alto; i++) {
            Line2D linea = new Line2D.Double(i, 0, i, ancho);
            if (i % 10 == 0) {
                g.setColor(new Color(204, 204, 204));
                g.draw(linea);
            }
        }

        for (int i = 0; i < ancho; i++) {
            Line2D linea = new Line2D.Double(0, i, ancho, i);
            if (i % 10 == 0) {
                g.setColor(new Color(204, 204, 204));
                g.draw(linea);
            }
        }

    }

}
