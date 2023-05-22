/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.control;

import game.principal.Constante;
import game.principal.graphics.SuperficieDibujo;
import game.principal.tools.CargadorRecursos;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;

/**
 *
 * @author izibr
 */
public class Mouse extends MouseAdapter {

    private final Cursor cursor;
    private Point posicion;

    public Mouse(final SuperficieDibujo sd) {
        Toolkit configuracion = Toolkit.getDefaultToolkit();
        BufferedImage icono = CargadorRecursos.cargarImagenCompatibleTranslucida(Constante.RUTA_ICONO_CURSOR);
        Point punta = new Point(0, 0);
        this.cursor = configuracion.createCustomCursor(icono, punta, "Cursor por defecto");
        posicion = new Point();
        actualizarPosicion(sd);
    }

    public void actualizar(final SuperficieDibujo sd) {
        actualizarPosicion(sd);
    }

    public void dibujar(final Graphics g) {
        g.setColor(Color.red);
        g.drawString("RX: " + posicion.getX(), 10, 200);
        g.drawString("RY: " + posicion.getY(), 10, 210);
    }

    public Cursor getCursor() {
        return this.cursor;
    }

    private void actualizarPosicion(final SuperficieDibujo sd) {
        final Point posicionInicial = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(posicionInicial, sd);
        posicion.setLocation(posicionInicial.getX(), posicionInicial.getY());

    }

}
