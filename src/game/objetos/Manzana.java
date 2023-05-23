/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objetos;

import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.tools.CargadorRecursos;

/**
 *Este es un objeto que al pasar sobre el aumenta 10 puntos la vida base del jugador 
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
 */
public class Manzana extends Objeto{
    public Manzana(int posicionX, int posicionY) {
        super(1, posicionX, posicionY, CargadorRecursos.cargarImagenCompatibleTranslucida(Constante.RUTA_MANZANA));
    }
    
    @Override
    public void recoger(Jugador jugador){
        jugador.setVida(jugador.getVida() + 10);
    }
    
    
}
