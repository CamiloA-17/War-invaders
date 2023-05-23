package game.principal.states;

import game.exceptions.EnemyNoAvailableException;
import game.exceptions.IncorrectSpriteSheetDimensionException;
import game.exceptions.ObjectNoAvailableException;
import game.exceptions.SpriteSheetCoordinatesNoAvailableException;
import game.interfaces.Jugable;
import game.interfaz_usuario.MenuInferior;
import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.maps.Mapa;

import java.awt.Color;
import java.awt.Graphics;

/**
 * En esta clase ya se dibujan los elementos a traves de la implementacion de la clase 
 * jugable
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
 */
public class GestorJuego implements Jugable {

    Mapa mapa;
    Jugador jugador;
    MenuInferior menuInferior;

    public GestorJuego() {
        try{
            mapa = new Mapa(Constante.RUTA_MAPA);
            jugador = new Jugador(0, 0, mapa);
            menuInferior = new MenuInferior(jugador);
        }catch(ObjectNoAvailableException e1){
            System.out.println(e1.getMessage());
        }catch(SpriteSheetCoordinatesNoAvailableException e2){
            System.out.println(e2.getMessage());
        }catch(IncorrectSpriteSheetDimensionException e3){
            System.out.println(e3.getMessage());
        }catch(EnemyNoAvailableException e4){
            System.out.println(e4.getMessage());
        }

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
        g.drawString(String.format("x = %.0f", jugador.getPosicionX()), 20, 20);
        g.drawString(String.format("y = %.0f", jugador.getPosicionY()), 20, 30);
        menuInferior.dibujar(g, jugador);

    }

}
