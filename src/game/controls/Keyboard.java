
package game.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public final class Keyboard implements KeyListener{
    private final static int numeroTeclas = 120;
    private final boolean[] teclas = new boolean[numeroTeclas];
    
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    
    public void update(){
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        derecha = teclas[KeyEvent.VK_A];
        izquierda = teclas[KeyEvent.VK_D];
    }


    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
}
