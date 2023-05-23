/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objetos;

import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.tools.CargadorRecursos;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author izibr
 */
public class BotellaAgua extends Objeto{
    
    public BotellaAgua(int posicionX, int posicionY) {
        super(2, posicionX, posicionY, CargadorRecursos.cargarImagenCompatibleTranslucida(Constante.RUTA_AGUA));
    }
    
    
    @Override
    public void recoger(Jugador jugador){
        jugador.setVelocidadBase(jugador.getVelocidadBase() + 0.2);
    }
    
}
