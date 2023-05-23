/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.sprites;

import game.exceptions.SpriteSheetCoordinatesNoAvailableException;
import game.principal.tools.CargadorRecursos;
import java.awt.image.BufferedImage;

/**
 * En esta clase se recibe la hoja con los sprites y se determina que es lo que ocurre con los sprites
 * presentes
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
 */

public class HojaSprite {

    final private int anchoHojaEnPixeles;
    final private int altoHojaEnPixeles;

    final private int anchoHojaEnSprites;
    final private int altoHojaEnSprites;

    final private int anchoSprites;
    final private int altoSprites;
    
    final private String ruta;

    final private BufferedImage[] images;

    public HojaSprite(final String ruta, final int tamanoSprites, final boolean hojaOpaca) {
        final BufferedImage imagen;
        this.ruta = ruta;
        if (hojaOpaca) {
            imagen = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
        } else {
            imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(ruta);
        }

        anchoHojaEnPixeles = imagen.getWidth();
        altoHojaEnPixeles = imagen.getHeight();

        anchoHojaEnSprites = anchoHojaEnPixeles / tamanoSprites;
        altoHojaEnSprites = altoHojaEnPixeles / tamanoSprites;

        anchoSprites = tamanoSprites;
        altoSprites = tamanoSprites;

        images = new BufferedImage[anchoHojaEnSprites * altoHojaEnSprites];
        
        rellenarSpritesDesdeImagen(imagen);
    }

    public HojaSprite(final String ruta, final int anchoSprites, final int altoSprites, final boolean hojaOpaca) {
        final BufferedImage imagen;
        this.ruta = ruta;
        if (hojaOpaca) {
            imagen = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
        } else {
            imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(ruta);
        }

        anchoHojaEnPixeles = imagen.getWidth();
        altoHojaEnPixeles = imagen.getHeight();

        anchoHojaEnSprites = anchoHojaEnPixeles / anchoSprites;
        altoHojaEnSprites = altoHojaEnPixeles / altoSprites;

        this.anchoSprites = anchoSprites;
        this.altoSprites = altoSprites;

        images = new BufferedImage[anchoHojaEnSprites * altoHojaEnSprites];
        rellenarSpritesDesdeImagen(imagen);
    }
    
    private void rellenarSpritesDesdeImagen(final BufferedImage imagen){
        for(int y = 0; y < altoHojaEnSprites; y++){
            for(int x = 0; x < altoHojaEnSprites; x++){
                final int posicionX = x * anchoSprites;
                final int posicionY = y * altoSprites;
                
                images[x+y*anchoHojaEnSprites] = imagen.getSubimage(posicionX, posicionY, anchoSprites, altoSprites);
            }
        }
    }
    
    public BufferedImage getImage(final int indice){
        return images[indice];
    }
    
    public BufferedImage getImage(final int x, final int y){
        if(x + y * anchoHojaEnSprites < images.length){
            return images[x + y * anchoHojaEnSprites];
        }else{
            throw new SpriteSheetCoordinatesNoAvailableException(x, y, ruta);
        }
        
    }

}
