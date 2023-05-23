/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.exceptions;

/**
 *
 * @author izibr
 */
public class SpriteSheetCoordinatesNoAvailableException extends RuntimeException{

    public SpriteSheetCoordinatesNoAvailableException(int x, int y, String ruta) {
        super("Las coordenadas x:" + x + " - y: " + y + " no están disponibles en la hoja de Sprite.\nRuta hoja: "+ ruta);
    }
    
}
