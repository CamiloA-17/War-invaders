/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.maps;

import game.principal.sprites.Sprite;
import java.awt.Rectangle;

/**
 *
 * @author izibr
 */
public class Tile {
    private final Sprite sprite;
    private final int id;
    private boolean solido;
    
    public Tile(final Sprite sprite, final int id){
        this.sprite = sprite;
        this.id = id;
        solido = false;
    }

    public Tile(Sprite sprite, int id, boolean solido) {
        this.sprite = sprite;
        this.id = id;
        this.solido = solido;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getId() {
        return id;
    }

    public void setSolido(final boolean solido) {
        this.solido = solido;
    }

    public Rectangle obtenerLimites(final int x, final int y){
        return new Rectangle(x, y, sprite.getAncho(), sprite.getAlto());
    }
    
    
}
