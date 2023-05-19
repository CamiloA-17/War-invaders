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
    
    
    //Colección de sprite sheets
    
    public static SpriteSheet spriteSheet = new SpriteSheet("/game/imgs/SpriteSheet.png", 320, 320);
    
    
    //Fin de colección de sprite sheets

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
