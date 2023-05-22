/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.control;

import game.principal.Constante;
import game.principal.tools.CargadorRecursos;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

/**
 *
 * @author izibr
 */
public class Mouse {
    private final Cursor cursor;

    public Mouse() {
        Toolkit configuracion = Toolkit.getDefaultToolkit();
        BufferedImage icono = CargadorRecursos.cargarImagenCompatibleTranslucida(Constante.RUTA_ICONO_CURSOR);
        Point punta = new Point(0, 0);
        this.cursor= configuracion.createCustomCursor(icono, punta, "Cursor por defecto");
    }
    
    public Cursor getCursor(){
        return this.cursor;
    }
    
}
