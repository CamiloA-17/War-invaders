/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.sprites;

import game.principal.tools.CargadorRecursos;
import java.awt.image.BufferedImage;

/**
 *
 * @author izibr
 */
public class HojaSprite {

    final private int anchoHojaEnPixeles;
    final private int altoHojaEnPixeles;

    final private int anchoHojaEnSprites;
    final private int altoHojaEnSprites;

    final private int anchoSprites;
    final private int altoSprites;

    final private Sprite[] sprites;

    public HojaSprite(final String ruta, final int tamanoSprites, final boolean hojaOpaca) {
        final BufferedImage imagen;
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

        sprites = new Sprite[anchoHojaEnSprites * altoHojaEnSprites];
        
        rellenarSpritesDesdeImagen(imagen);
    }

    public HojaSprite(final String ruta, final int anchoSprites, final int altoSprites, final boolean hojaOpaca) {
        final BufferedImage imagen;
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

        sprites = new Sprite[anchoHojaEnSprites * altoHojaEnSprites];
        rellenarSpritesDesdeImagen(imagen);
    }
    
    private void rellenarSpritesDesdeImagen(final BufferedImage imagen){
        for(int y = 0; y < altoHojaEnSprites; y++){
            for(int x = 0; x < altoHojaEnSprites; x++){
                final int posicionX = x * anchoSprites;
                final int posicionY = y * altoSprites;
                
                sprites[x+y*anchoHojaEnSprites] = new Sprite(imagen.getSubimage(posicionX, posicionY, anchoSprites, altoSprites));
            }
        }
    }
    
    public Sprite getSprite(final int indice){
        return sprites[indice];
    }
    
    public Sprite getSprite(final int x, final int y){
        return sprites[x + y * anchoHojaEnSprites];
    }

}
