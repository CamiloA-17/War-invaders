package game.principal.statesmachine;

import game.principal.statesmachine.states.game.GestorJuego;
import java.awt.Graphics;

/**
 *
 * @author izibr
 */
public class GestorEstados {
    private EstadoJuego[] estados;
    private EstadoJuego estadoActual;

    public GestorEstados() {
        iniciarEstados();
        iniciarEstadoActual();
    }
    
    private void iniciarEstados(){
        estados = new EstadoJuego[1];
        estados[0] = new GestorJuego();
        // Acá van los demás estados del juego
    }
    
    public void iniciarEstadoActual(){
        estadoActual = estados[0];
    }
    
    public void actualizar(){
        estadoActual.actualizar();
    }
    
    public void dibujar(final Graphics g){
        estadoActual.dibujar(g);
    }
    
    public void cambiarEstadoActual(final int nuevoEstado){
        estadoActual = estados[nuevoEstado];
    }
    
    public EstadoJuego getEstadoActual(){
        return estadoActual;
    }
    
}
