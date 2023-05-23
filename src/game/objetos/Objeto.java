
package game.objetos;

import game.principal.entes.Jugador;
import game.principal.sprites.Sprite;
import game.principal.tools.CargadorRecursos;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Objeto {
    protected final int id;
    private Point posicion;
    private BufferedImage sprite;
    protected Rectangle posicionMenu;
    protected Rectangle posicionFlotante;

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

    public Rectangle obtenerPosicionMenu() {
        return posicionMenu;
    }

    public Rectangle obtenerPosicionFlotante() {
        return posicionFlotante;
    }

    public void establecerPosicionMenu(final Rectangle posicionMenu) {
        this.posicionMenu = posicionMenu;
    }

    public void establecerPosicionFlotante(final Rectangle posicionFlotante) {
        this.posicionFlotante = posicionFlotante;
    }
}
