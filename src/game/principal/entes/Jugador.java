package game.principal.entes;

import java.awt.Color;
import java.awt.Graphics;

import game.principal.Constante;
import game.principal.sprites.Sprite;

public class Jugador {

    private double posicionX;
    private double posicionY;

    private Sprite sprite;

    public Jugador(double posicionX, double posicionY){
        this.posicionX= posicionX;
        this.posicionY= posicionY;
    }

    public void dibujar(Graphics g){
        final int centroX= Constante.ANCHO_PANTALLA/2 - Constante.LADO_SPRITE/2; //Para que el centro del sprite quede en el centro de pantalla
        final int centroY= Constante.ALTO_PANTALLA/2 - Constante.LADO_SPRITE/2; //Para que el centro del sprite quede en el centro de pantalla
        
        g.setColor(Color.white);
        g.fillRect(centroX, centroY, Constante.LADO_SPRITE, Constante.LADO_SPRITE);
    }

    public void establecerPosicionX(double posicionX){
        this.posicionX= posicionX;
    }

    public void establecerPosicionY(double posicionY){
        this.posicionY= posicionY;
    }

    public double getPosicionX(){
        return posicionX;
    }

    public double getPosicionY(){
        return posicionY;
    }
}
