/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objetos;

import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.tools.CargadorRecursos;

/**
 * Este es un objeto que al pasar sobre el resta 10 puntos de vida al jugador 
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
 */
public class Sapo extends Objeto{

    public Sapo(int posicionX, int posicionY) {
        super(4, posicionX, posicionY, CargadorRecursos.cargarImagenCompatibleTranslucida(Constante.RUTA_SAPO));
    }

    @Override
    public void recoger(Jugador jugador) {
        jugador.setVida(jugador.getVida()-10);
    }
    
}
