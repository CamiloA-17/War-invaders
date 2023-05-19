/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author izibr
 */
public class SpriteSheet {
    private final int ancho;
    private final int alto;
    public final int[] pixeles;
    
    
    //Sprites
    
    public static SpriteSheet spriteSheet = new SpriteSheet("/game/imgs/SpriteSheet.png", 320, 320);
    
    
    //Fin sprites

    public SpriteSheet(final String ruta, int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.pixeles = new int[ancho * alto];
        
        BufferedImage imagen;
        try{
            imagen = ImageIO.read(SpriteSheet.class.getResource(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        }catch(IOException e){
            System.out.println("Error cargando imagen");
            e.printStackTrace();
        }
    }

    public int getAncho() {
        return ancho;
    }
}
