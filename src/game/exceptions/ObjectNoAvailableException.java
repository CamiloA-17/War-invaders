/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.exceptions;

/**
 *
 * @author izibr
 */
public class ObjectNoAvailableException extends RuntimeException{

    public ObjectNoAvailableException(int idObjeto) {
        super("El objeto de id " + idObjeto + " no existe actualmente");
    }
    
}
