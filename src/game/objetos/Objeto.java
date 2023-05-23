
package game.objetos;

import game.principal.entes.Jugador;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * Esta clase maneja los diferentes objetos que se encuentran en el mapa y la manera en como 
 * estos se dibujan 
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
 */

public abstract class Objeto {
    protected final int id;
    private Point posicion;
    private BufferedImage sprite;

    public Objeto(int id, int posicionX, int posicionY, BufferedImage sprite) {
        this.id = id;
        posicion = new Point(posicionX, posicionY);
        this.sprite =sprite;
    }
 
    public void dibujar(Graphics g, int puntoX, int puntoY) {
        g.drawImage(sprite, puntoX, puntoY, null);
    }
    public abstract void recoger(Jugador jugador);
    public Point obtenerPosicion() {
        return posicion;
    }

    public int obtenerId() {
        return id;
    }
}
