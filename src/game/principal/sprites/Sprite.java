
package game.principal.sprites;

/**
 * Un sprite es la clase base de todo elemento grafico que se dibuje en pantalla
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
 */

public abstract class Sprite {
    protected double posicionX;
    protected double posicionY;
    protected double ancho;
    protected double alto;

    public Sprite(double posicionX, double posicionY, int ancho, int alto) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }
    
    
    

    
    
    
}
