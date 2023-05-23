package game.principal.graphics;

import game.principal.control.GestorControl;
import game.principal.control.Mouse;
import game.principal.states.GestorJuego;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

/**
 *En esta clase es donde directamente se dibujan los demas objetos necesarios para el funcionamiento
 * del juego
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
 */
public class SuperficieDibujo extends Canvas {
    private int ancho;
    private int alto;

    private Mouse raton;
    
    public SuperficieDibujo(final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;

        this.raton = new Mouse(this);
        setIgnoreRepaint(true);
        setCursor(raton.getCursor());
        setPreferredSize(new Dimension(ancho, alto));
        addKeyListener(GestorControl.teclado);
        setFocusable(true);
        requestFocus();
    }
    
    public void actualizar(){
        raton.actualizar(this); 
    }
    
    public void dibujar(GestorJuego gj){
        BufferStrategy buffer = getBufferStrategy();
        if(buffer == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = buffer.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, ancho, alto);
        
        gj.dibujar(g);
        raton.dibujar(g);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        buffer.show();
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    
}
