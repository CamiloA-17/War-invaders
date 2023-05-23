package game.principal;

import game.principal.graphics.SuperficieDibujo;
import game.principal.graphics.Ventana;
import game.principal.states.GestorJuego;

public class GestorPrincipal {

    private boolean enFuncionamiento = false;
    private String titulo;
    private int ancho;
    private int alto;
    private SuperficieDibujo sd;
    private Ventana window;
    private GestorJuego gj;

    public GestorPrincipal(String titulo, int ancho, int alto) {
        this.titulo = titulo;
        this.ancho = ancho;
        this.alto = alto;
    }

    public static void main(String[] args) {
        GestorPrincipal controller = new GestorPrincipal("War Invaders", 640, 360);
        controller.iniciarJuego();
        controller.iniciarBuclePrincipal();
    }

    private void iniciarJuego() {
        enFuncionamiento = true;
        inicializar();
    }

    private void inicializar() {
        sd = new SuperficieDibujo(ancho, alto);
        window = new Ventana(titulo, sd);
        gj = new GestorJuego();

    }

    private void iniciarBuclePrincipal() {
        int aps = 0;
        int fps = 0;
        
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS;

        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();

        double tiempoTranscurrido;
        double delta = 0;

        while (enFuncionamiento) {
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
            while (delta >= 1) {
                actualizar();
                aps++;
                Constante.APS = aps;
                delta--;
            }
            dibujar();
            fps++;
            
            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
                //window.setTitle("War Invaders || APS: " + aps + " || FPS: " + fps);
                System.out.println("FPS: " + fps + " | APS: "+ aps);
                fps = 0;
                Constante.APS = aps;
                aps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }
    
    
    private void actualizar(){
        gj.actualizar();
        sd.actualizar();
    }
    
    private void dibujar(){
        sd.dibujar(gj);
    }

}
