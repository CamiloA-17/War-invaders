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
public class Moneda extends Objeto{

    public Moneda(int posicionX, int posicionY) {
        super(5, posicionX, posicionY, CargadorRecursos.cargarImagenCompatibleTranslucida(Constante.RUTA_MONEDA));
    }

    @Override
    public void recoger(Jugador jugador) {
        jugador.setPuntaje(jugador.getPuntaje()+1);
    }
    
}
