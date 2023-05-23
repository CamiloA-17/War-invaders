/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.exceptions;

/**
 *
 * @author izibr
 */
public class IncorrectSpriteSheetDimensionException extends RuntimeException{

    public IncorrectSpriteSheetDimensionException(int intento, int tamanoLista) {
        super("Las dimensiones de la hoja de Sprites son incorrectas.\n Se intentó acceder a la posición " + intento + " pero la lista sólo tiene " + tamanoLista + " posiciones");
        
    }
    
}
