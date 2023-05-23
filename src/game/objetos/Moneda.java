/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objetos;

import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.tools.CargadorRecursos;

/**
 *Este es un objeto que al pasar sobre el suma 1 punto en el puntaje del jugador 
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
 */
public class Moneda extends Objeto{

    public Moneda(int posicionX, int posicionY) {
        super(5, posicionX, posicionY, CargadorRecursos.cargarImagenCompatibleTranslucida(Constante.RUTA_MONEDA));
    }

    @Override
    public void recoger(Jugador jugador) {
        jugador.setPuntaje(jugador.getPuntaje()+1);
    }
    
}
