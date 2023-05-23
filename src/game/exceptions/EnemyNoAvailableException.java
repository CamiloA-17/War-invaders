/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.exceptions;

/**
 *
 * @author izibr
 */
public class EnemyNoAvailableException extends RuntimeException{

    public EnemyNoAvailableException(int id) {
        super("El enemigo de id " + id + " no existe");
    }
    
}
