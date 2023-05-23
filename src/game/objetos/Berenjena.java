/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objetos;

import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.tools.CargadorRecursos;

/**
 * Este es un tipo de objeto que al momento de pasar sobre el hace que el jugador
 * no se pueda mover durante 2 segundos
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
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
