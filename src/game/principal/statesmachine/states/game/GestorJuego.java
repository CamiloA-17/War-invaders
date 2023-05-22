/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.statesmachine.states.game;

import game.interfaz_usuario.InterfazUsuario;
import game.principal.Constante;
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
public class GestorJuego implements EstadoJuego {

    Mapa mapa = new Mapa(Constante.RUTA_MAPA);
    Jugador jugador = new Jugador(0, 0, mapa);

    @Override
    public void actualizar() {
        jugador.actualizar();
        mapa.actualizar((int) jugador.getPosicionX(), (int) jugador.getPosicionY());
    }

    @Override
    public void dibujar(Graphics g) {
        mapa.dibujar(g, (int) jugador.getPosicionX(), (int) jugador.getPosicionY());
        jugador.dibujar(g);
        g.setColor(Color.red);
        g.drawString("x= " + jugador.getPosicionX(), 20, 20);
        g.drawString("y= " + jugador.getPosicionY(), 20, 30);
        InterfazUsuario.dibujarBarraResistencia(g, jugador.resistencia);

    }

}
