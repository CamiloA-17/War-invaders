/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.graphics;

/**
 *
 * @author izibr
 */
public final class Sprite {
    private final int lado;
    private int x;
    private int y;
    public int[] pixeles;
    private final SpriteSheet hoja;
    
    //Sprites
    public static Sprite grass = new Sprite(32, 0, 0, SpriteSheet.spriteSheet);
    //Fin sprites
    
    

    public Sprite(final int lado, final int columna, final int fila, final SpriteSheet hoja) {
        this.lado = lado;
        pixeles = new int[lado * lado];
        this.x = columna*lado;
        this.y = columna*lado;
        this.hoja = hoja;
        for(int y = 0; y < lado; y++){
            for(int x = 0; x < lado; x++){
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
        
    }
    
    
}
