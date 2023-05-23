/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objetos;

import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.tools.CargadorRecursos;
import java.awt.image.BufferedImage;

/**
 *
 * @author ASUS
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
