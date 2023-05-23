/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objetos;

import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.tools.CargadorRecursos;

/**
 *
 * @author ASUS
 */
public class Hongo extends Objeto{

    public Hongo(int posicionX, int posicionY) {
        super(3, posicionX, posicionY, CargadorRecursos.cargarImagenCompatibleTranslucida(Constante.RUTA_HONGO));
    }
    

    @Override
    public void recoger(Jugador jugador) {
        jugador.setVelocidadBase(jugador.getVelocidadBase() - 0.2);
    }
    
}
