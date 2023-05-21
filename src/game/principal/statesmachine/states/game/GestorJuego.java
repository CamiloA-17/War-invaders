/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.statesmachine.states.game;

import game.principal.control.GestorControl;
import game.principal.entes.Jugador;
import game.principal.maps.Mapa;

import java.awt.Color;
import java.awt.Graphics;
import game.principal.statesmachine.EstadoJuego;

/**
 *
 * @author izibr
 */
public class GestorJuego implements EstadoJuego{

    Mapa mapa= new Mapa("/game/mapas/texto.txt");
    Jugador jugador= new Jugador(0, 0);

    @Override
    public void actualizar() {
        if(GestorControl.teclado.isArriba()){
            jugador.establecerPosicionY(jugador.getPosicionY()-1);
        }
        if(GestorControl.teclado.isAbajo()){
            jugador.establecerPosicionY(jugador.getPosicionY()+1);
        }
        if(GestorControl.teclado.isIzquierda()){
            jugador.establecerPosicionX(jugador.getPosicionX()-1);
        }
        if(GestorControl.teclado.isDerecha()){
            jugador.establecerPosicionX(jugador.getPosicionX()+1);
        }
    }

    @Override
    public void dibujar(Graphics g) {
        mapa.dibujar(g, (int)jugador.getPosicionX(), (int)jugador.getPosicionY());
        jugador.dibujar(g);
        g.setColor(Color.red);
        g.drawString("x= "+jugador.getPosicionX(), 20, 20);
        g.drawString("y= "+jugador.getPosicionY(), 20, 30);

    }
    
}
