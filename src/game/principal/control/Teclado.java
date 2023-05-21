/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author izibr
 */
public class Teclado implements KeyListener{
    private final static int NUMERO_TECLAS = 257;
    private final boolean[] teclas = new boolean[NUMERO_TECLAS];
    
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    
    public boolean correr;
    public boolean salir;
    
    public void actualizar(){
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        derecha = teclas[KeyEvent.VK_A];
        izquierda = teclas[KeyEvent.VK_D];
        
        correr = teclas[KeyEvent.VK_SHIFT];
        salir = teclas[KeyEvent.VK_ESCAPE];
        
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
