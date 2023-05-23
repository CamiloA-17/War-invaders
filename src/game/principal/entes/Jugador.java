package game.principal.entes;

import java.awt.Color;
import java.awt.Graphics;

import game.principal.Constante;
import game.principal.control.GestorControl;
import game.principal.maps.Mapa;
import game.principal.sprites.HojaSprite;
import game.principal.sprites.Sprite;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Jugador extends Sprite{

    private int direccion;

    private boolean enMovimiento;
    private double velocidadBase = 1;
    private double velocidad = 0;
    public int resistencia = 600;
    public int vida = 80;
    private int recuperacion = 100;
    private boolean recuperado = true;

    private HojaSprite hs;
    private BufferedImage imagenActual;

    private final Rectangle LIMITE_ARRIBA = new Rectangle(Constante.CENTRO_VENTANA_X - 10, Constante.CENTRO_VENTANA_Y - 10, Constante.LADO_SPRITE - 12, 1);
    private final Rectangle LIMITE_ABAJO = new Rectangle(Constante.CENTRO_VENTANA_X - 10, Constante.CENTRO_VENTANA_Y + 10, Constante.LADO_SPRITE - 12, 1);
    private final Rectangle LIMITE_IZQUIERDA = new Rectangle(Constante.CENTRO_VENTANA_X - 10, Constante.CENTRO_VENTANA_Y - 10, 1, 20);
    private final Rectangle LIMITE_DERECHA = new Rectangle(Constante.CENTRO_VENTANA_X + 10, Constante.CENTRO_VENTANA_Y - 10, 1, 20);

    private int animacion;
    private int estado;

    private Mapa mapa;

    public Jugador(double posicionX, double posicionY, Mapa mapa){
        super(posicionX, posicionY, 20, 20);
        enMovimiento = false;
        direccion = 0;
        hs = new HojaSprite(Constante.RUTA_PERSONAJE, Constante.LADO_SPRITE, false);
        imagenActual = hs.getImage(0);
        animacion = 0;
        estado = 0;
        this.mapa = mapa;
    }

    public void actualizar() {
        cambiarAnimacionEstado();
        gestionarVelocidadResistencia();
        enMovimiento = false;
        determinarDireccion();
        animar();
    }

    private void gestionarVelocidadResistencia() {
        if (GestorControl.teclado.corriendo && resistencia > 0) {
            velocidad = velocidadBase + 2;
            recuperado = false;
            recuperacion = 0;
        } else {
            velocidad = velocidadBase + 1;
            if (!recuperado && recuperacion < 100) {
                recuperacion++;
            }
            if (recuperacion == 100 && resistencia < 600) {
                resistencia++;
            }
        }
    }

    private void cambiarAnimacionEstado() {
        if (animacion < 30) {
            animacion++;
        } else {
            animacion = 0;
        }

        if (animacion < 15) {
            estado = 1;
        } else {
            estado = 0;
        }
    }

    private void determinarDireccion() {
        final int velocidadX = evaluarVelocidadX();
        final int velocidadY = evaluarVelocidadY();
        if (velocidadX == 0 && velocidadY == 0) {
            return;
        }

        if ((velocidadX != 0 && velocidadY == 0) || (velocidadX == 0 && velocidadY != 0)) {
            mover(velocidadX, velocidadY);
        } else {
            //izquierda y arriba
            if (velocidadX == -1 && velocidadY == -1) {
                if (GestorControl.teclado.izquierda.getUltimaPulsacion() > GestorControl.teclado.arriba.getUltimaPulsacion()) {
                    mover(velocidadX, 0);
                } else {
                    mover(0, velocidadY);
                }
            }

            //izquierda y abajo
            if (velocidadX == -1 && velocidadY == 1) {
                if (GestorControl.teclado.izquierda.getUltimaPulsacion() > GestorControl.teclado.abajo.getUltimaPulsacion()) {
                    mover(velocidadX, 0);
                } else {
                    mover(0, velocidadY);
                }
            }

            //derecha y arriba
            if (velocidadX == 1 && velocidadY == -1) {
                if (GestorControl.teclado.derecha.getUltimaPulsacion() > GestorControl.teclado.arriba.getUltimaPulsacion()) {
                    mover(velocidadX, 0);
                } else {
                    mover(0, velocidadY);
                }
            }

            //derecha y abajo
            if (velocidadX == 1 && velocidadY == 1) {
                if (GestorControl.teclado.derecha.getUltimaPulsacion() > GestorControl.teclado.abajo.getUltimaPulsacion()) {
                    mover(velocidadX, 0);
                } else {
                    mover(0, velocidadY);
                }
            }
        }

    }

    private int evaluarVelocidadX() {
        int velocidadX = 0;
        if (GestorControl.teclado.izquierda.isPulsada() && !GestorControl.teclado.derecha.isPulsada()) {
            velocidadX = -1;
        } else if (GestorControl.teclado.derecha.isPulsada() && !GestorControl.teclado.izquierda.isPulsada()) {
            velocidadX = 1;
        }
        return velocidadX;
    }

    private int evaluarVelocidadY() {
        int velocidadY = 0;
        if (GestorControl.teclado.arriba.isPulsada() && !GestorControl.teclado.abajo.isPulsada()) {
            velocidadY = -1;
        } else if (GestorControl.teclado.abajo.isPulsada() && !GestorControl.teclado.arriba.isPulsada()) {
            velocidadY = 1;
        }
        return velocidadY;
    }

    private void mover(final int velocidadX, final int velocidadY) {
        enMovimiento = true;
        cambiarDireccion(velocidadX, velocidadY);
        if (!fueraMapa(velocidadX, velocidadY)) {
            if (velocidadX == -1 && !enColisionIzquierda(velocidadX)) {
                posicionX += velocidadX * velocidad;
            }
            if (velocidadX == 1 && !enColisionDerecha(velocidadX)) {
                posicionX += velocidadX * velocidad;
            }
            if (velocidadY == -1 && !enColisionArriba(velocidadY)) {
                posicionY += velocidadY * velocidad;
            }
            if (velocidadY == 1 && !enColisionAbajo(velocidadY)) {
                posicionY += velocidadY * velocidad;
            }
        }
        if (GestorControl.teclado.corriendo && resistencia > 0) {
            resistencia--;
        }
    }

    private boolean enColisionArriba(int velocidadY) {
        for (int r = 0; r < mapa.areasColision.size(); r++) {
            final Rectangle area = mapa.areasColision.get(r);
            int origenX = area.x;
            int origenY = area.y + velocidadY * (int) velocidad + 3 * (int) velocidad;
            final Rectangle areaFutura = new Rectangle(origenX, origenY, Constante.LADO_SPRITE, Constante.LADO_SPRITE);
            if (LIMITE_ARRIBA.intersects(areaFutura)) {
                return true;
            }
        }
        return false;
    }

    private boolean enColisionAbajo(int velocidadY) {
        for (int r = 0; r < mapa.areasColision.size(); r++) {
            final Rectangle area = mapa.areasColision.get(r);
            int origenX = area.x;
            int origenY = area.y + velocidadY * (int) velocidad - 3 * (int) velocidad;
            final Rectangle areaFutura = new Rectangle(origenX, origenY, Constante.LADO_SPRITE, Constante.LADO_SPRITE);
            if (LIMITE_ABAJO.intersects(areaFutura)) {
                return true;
            }
        }
        return false;
    }

    private boolean enColisionIzquierda(int velocidadX) {
        for (int r = 0; r < mapa.areasColision.size(); r++) {
            final Rectangle area = mapa.areasColision.get(r);
            int origenX = area.x + velocidadX * (int) velocidad + 3 * (int) velocidad;;
            int origenY = area.y;
            final Rectangle areaFutura = new Rectangle(origenX, origenY, Constante.LADO_SPRITE, Constante.LADO_SPRITE);
            if (LIMITE_IZQUIERDA.intersects(areaFutura)) {
                return true;
            }
        }
        return false;
    }

    private boolean enColisionDerecha(int velocidadX) {
        for (int r = 0; r < mapa.areasColision.size(); r++) {
            final Rectangle area = mapa.areasColision.get(r);
            int origenX = area.x + velocidadX * (int) velocidad - 3 * (int) velocidad;
            int origenY = area.y;
            final Rectangle areaFutura = new Rectangle(origenX, origenY, Constante.LADO_SPRITE, Constante.LADO_SPRITE);
            if (LIMITE_DERECHA.intersects(areaFutura)) {
                return true;
            }
        }
        return false;
    }

    private boolean fueraMapa(final int velocidadX, final int velocidadY) {
        int posicionFuturaX = (int) posicionX + velocidadX * (int) velocidad;
        int posicionFuturaY = (int) posicionY + velocidadY * (int) velocidad;
        final Rectangle bordesMapa = mapa.obtenerBordes(posicionFuturaX, posicionFuturaY, (int) getAncho(), (int) getAlto());
        final boolean fuera;

        if (LIMITE_ARRIBA.intersects(bordesMapa) || LIMITE_ABAJO.intersects(bordesMapa) || LIMITE_IZQUIERDA.intersects(bordesMapa) || LIMITE_DERECHA.intersects(bordesMapa)) {
            fuera = false;
        } else {
            fuera = true;
        }

        return fuera;
    }

    private void cambiarDireccion(final int velocidadX, final int velocidadY) {
        if (velocidadX == -1) {
            direccion = 3;
        } else if (velocidadX == 1) {
            direccion = 2;
        }

        if (velocidadY == -1) {
            direccion = 1;
        } else if (velocidadY == 1) {
            direccion = 0;
        }
    }

    private void animar() {
        if (!enMovimiento) {
            estado = 0;
            animacion = 0;
        }
        imagenActual = hs.getImage(direccion, estado);
    }

    public void dibujar(Graphics g) {
        final int centroX = Constante.ANCHO_VENTANA / 2 - Constante.LADO_SPRITE / 2; //Para que el centro del sprite quede en el centro de pantalla
        final int centroY = Constante.ALTO_VENTANA / 2 - Constante.LADO_SPRITE / 2; //Para que el centro del sprite quede en el centro de pantalla

        g.setColor(Color.white);
        g.drawImage(imagenActual, centroX, centroY, null);
        g.drawString("Resistencia: " + resistencia, 20, 40);
        g.drawString("Velocidad: " + velocidad, 20, 50);
    }

    public void setVelocidadBase(double velocidadBase) {
        this.velocidadBase = velocidadBase;
    }

    public double getVelocidadBase() {
        return velocidadBase;
    }
    
    
    
    
    
    
}
