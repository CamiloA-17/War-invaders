package game.interfaces;

import java.awt.Graphics;
/**
 * Esta interfaz esta diseñada para implementar los metodos actualizar y dibujar en las clases que lo requieran
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
 */

public interface Jugable {
    void actualizar();
    void dibujar(final Graphics g);
}
