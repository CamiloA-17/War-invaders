/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.control;

/**
 *En esta clase se tiene un control de cada tecla del teclado de manera individual
 * para poder manejar sus estados
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
 */
public class Tecla {
    private boolean pulsada = false;
    private long ultimaPulsacion = System.nanoTime();
    
    public void teclaPulsada(){
        pulsada = true;
        ultimaPulsacion = System.nanoTime();
    }
    
    public void teclaLiberada(){
        pulsada = false;
    }

    public boolean isPulsada() {
        return pulsada;
    }

    public long getUltimaPulsacion() {
        return ultimaPulsacion;
    }
    
    
}
