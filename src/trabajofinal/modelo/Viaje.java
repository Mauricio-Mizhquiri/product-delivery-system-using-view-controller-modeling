/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.modelo;

import trabajofinal.modelo.estados.EstadoViaje;

/**
 *
 * @author paulc
 */
public class Viaje {
    private Ciudad partida;
    private Ciudad llegada;
    private EstadoViaje estado;

    public Viaje(Ciudad partida, Ciudad llegada, EstadoViaje estado) {
        this.partida = partida;
        this.llegada = llegada;
        this.estado = estado;
        
    }
    
    
}
