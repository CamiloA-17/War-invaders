package game.principal.states;

import game.interfaces.Jugable;
import game.interfaz_usuario.MenuInferior;
import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.maps.Mapa;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author izibr
 */
public class GestorJuego implements Jugable {

    Mapa mapa;
    Jugador jugador;
    MenuInferior menuInferior;

    public GestorJuego() {
        mapa = new Mapa(Constante.RUTA_MAPA);
        jugador = new Jugador(0, 0, mapa);
        menuInferior = new MenuInferior(jugador);
    }

    @Override
    public void actualizar() {
        jugador.actualizar();
        mapa.actualizar((int) jugador.getPosicionX(), (int) jugador.getPosicionY(), jugador);
    }

    @Override
    public void dibujar(Graphics g) {
        mapa.dibujar(g, (int) jugador.getPosicionX(), (int) jugador.getPosicionY(), jugador);
        jugador.dibujar(g);
        g.setColor(Color.white);
        g.drawString("x= " + jugador.getPosicionX(), 20, 20);
        g.drawString("y= " + jugador.getPosicionY(), 20, 30);
        menuInferior.dibujar(g, jugador);

    }

}
