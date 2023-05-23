/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objetos;

import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.tools.CargadorRecursos;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ASUS
 */
public class Berenjena extends Objeto {

    public Berenjena(int posicionX, int posicionY) {
        super(7, posicionX, posicionY, CargadorRecursos.cargarImagenCompatibleTranslucida(Constante.RUTA_BERENJENA));
    }

    @Override
    public void recoger(Jugador jugador) {
//        Timer timer= new Timer();
//        jugador.setEnMovimiento(false);
//        timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    jugador.setEnMovimiento(true);
//                }
//            }, 2000);
    }
    
}
