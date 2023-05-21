package game.principal.graphics;

import game.principal.control.Mouse;
import game.principal.control.Teclado;
import game.principal.statesmachine.GestorEstados;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

/**
 *
 * @author izibr
 */
public class SuperficieDibujo extends Canvas {
    private int ancho;
    private int alto;
    
    private Teclado teclado;
    private Mouse raton;
    
    public SuperficieDibujo(final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;
        this.teclado = new Teclado();
        this.raton = new Mouse();
        setIgnoreRepaint(true);
        setCursor(raton.getCursor());
        setPreferredSize(new Dimension(ancho, alto));
        addKeyListener(teclado);
        setFocusable(true);
        requestFocus();
    }
    
    public void dibujar(GestorEstados ge){
        BufferStrategy buffer = getBufferStrategy();
        if(buffer == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = buffer.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, ancho, alto);
        
        ge.dibujar(g);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        buffer.show();
    }
    
    public Teclado getTeclado(){
        return teclado;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    
}
