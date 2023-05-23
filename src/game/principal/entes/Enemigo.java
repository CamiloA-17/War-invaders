/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.entes;

import game.principal.Constante;
import game.principal.sprites.HojaSprite;
import game.principal.tools.CargadorRecursos;
import game.principal.tools.Sonido;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.sound.sampled.Clip;

/**
 *
 * @author izibr
 */
public abstract class Enemigo implements Runnable {

    private Sonido lamento;
    private static HojaSprite hojaEnemigo;
    private long duracionLamento;
    private long lamentoSiguiente = 0;

    private int idEnemigo;

    private double posicionX;
    private double posicionY;

    private String nombre;
    private int vidaMaxima;
    private float vidaActual;
    private double posXJugador;
    private double posYJugador;
    private int direccion;
    private Thread thread = null;
    private boolean isRunning = false;

    public Enemigo(final int idEnemigo, final String nombre, final int vidaMaxima, final String rutaLamento, final HojaSprite hojaEnemigo) {
        this.hojaEnemigo = hojaEnemigo;
        this.idEnemigo = idEnemigo;
        this.direccion = 0;
        this.posXJugador = 0;
        this.posYJugador = 0;

        this.posicionX = 0;
        this.posicionY = 0;

        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;

        this.lamento = new Sonido(rutaLamento);
        this.duracionLamento = lamento.obtenerDuracion();

        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            //arriba
            if (this.posicionY - this.posYJugador > 0.5 || this.posicionY - this.posYJugador < -0.5) {
                if (this.posicionY > this.posYJugador) {
                    direccion = 0;
                } else if (this.posicionY < this.posYJugador) {
                    direccion = 1;
                }
            } else if (this.posicionX - this.posXJugador != 1 || this.posicionX - this.posXJugador != -1) {
                if (this.posicionX < this.posXJugador) {
                    direccion = 3;
                } else if (this.posicionX > this.posXJugador) {
                    direccion = 2;
                }
            }

            switch (direccion) {
                case 0:
                    posicionY -= 0.5;
                    break;
                case 1:
                    posicionY += 0.5;
                    break;
                case 2:
                    posicionX -= 0.5;
                    break;
                case 3:
                    posicionX += 0.5;
                    break;
            }
            try {
                thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizar() {
        if (lamentoSiguiente > 0) {
            lamentoSiguiente -= 1000000 / 60;
        }
        //moverHaciaSiguienteNodo(enemigos);
    }

    public void dibujar(final Graphics g, final int puntoX, final int puntoY) {
        if (vidaActual <= 0) {
            isRunning = false;
            return;
        }

        dibujarBarraVida(g, puntoX, puntoY);
        g.drawImage(hojaEnemigo.getImage(direccion), puntoX, puntoY, null);
        g.setColor(Color.BLUE);
        //DibujoDebug.dibujarRectanguloContorno(g, obtenerArea());
        //dibujarDistancia(g, puntoX, puntoY);
    }

    private void dibujarBarraVida(final Graphics g, final int puntoX, final int puntoY) {
        g.setColor(Color.red);
        g.fillRect(puntoX, puntoY - 5, Constante.LADO_SPRITE * (int) vidaActual / vidaMaxima, 2);
    }

    public void establecerPosicion(final double posicionX, final double posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public double obtenerPosicionX() {
        return posicionX;
    }

    public double obtenerPosicionY() {
        return posicionY;
    }

    public int obtenerIdEnemigo() {
        return idEnemigo;
    }

    public float obtenerVidaActual() {
        return vidaActual;
    }

    public Rectangle obtenerArea(Jugador jugador) {
        final int puntoX = (int) posicionX * Constante.LADO_SPRITE - (int) jugador.getPosicionX() + Constante.MARGEN_X;
        final int puntoY = (int) posicionY * Constante.LADO_SPRITE - (int) jugador.getPosicionY() + Constante.MARGEN_Y;
        return new Rectangle(puntoX, puntoY, Constante.LADO_SPRITE, Constante.LADO_SPRITE);
    }

    public void perderVida(float ataqueRecibido) {
        if (lamentoSiguiente <= 0) {
            lamento.reproducir();
            lamentoSiguiente = duracionLamento;
        }

        if (vidaActual - ataqueRecibido < 0) {
            vidaActual = 0;

        } else {
            vidaActual -= ataqueRecibido;
        }
    }

    public Rectangle obtenerAreaPosicional() {
        return new Rectangle((int) posicionX, (int) posicionY, Constante.LADO_SPRITE, Constante.LADO_SPRITE);
    }

    public void setPosXJugador(double posXJugador) {
        this.posXJugador = posXJugador / Constante.LADO_SPRITE;
    }

    public void setPosYJugador(double posYJugador) {
        this.posYJugador = posYJugador / Constante.LADO_SPRITE;
    }
    
    public void atacar(Jugador jugador){
        
    }

}
