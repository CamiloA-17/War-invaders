/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objetos;

import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.sprites.Sprite;
import game.principal.tools.CargadorRecursos;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author izibr
 */
public class Manzana extends Objeto{
    public Manzana(int posicionX, int posicionY) {
        super(1, posicionX, posicionY, CargadorRecursos.cargarImagenCompatibleTranslucida(Constante.RUTA_MANZANA));
    }
    
    @Override
    public void recoger(Jugador jugador){
        jugador.vida = jugador.vida + 10;
    }
    
    
}
