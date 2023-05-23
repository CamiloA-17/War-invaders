/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.entes;

import game.principal.Constante;
import game.principal.sprites.HojaSprite;

/**
 *
 * @author izibr
 */
public class Chasqueador extends Enemigo {
    
    public Chasqueador(int idEnemigo, String nombre, int vidaMaxima, String rutaLamento) {
        super(idEnemigo, nombre, vidaMaxima, rutaLamento, new HojaSprite(Constante.RUTA_ENEMIGOS + idEnemigo + ".png", Constante.LADO_SPRITE, false));

    }
}
