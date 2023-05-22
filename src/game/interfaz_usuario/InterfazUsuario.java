/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.interfaz_usuario;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author izibr
 */
public class InterfazUsuario {

    public static void dibujarBarraResistencia(Graphics g, int resistencia) {
        int ancho = 100 * resistencia / 600;
        Color rojoOscuro = new Color(153, 0, 0);
          g.setColor(Color.WHITE);
        g.drawRect(9, 69, 102, 17);

        if (ancho > 0) {
            if (ancho < 25) {
                g.setColor(Color.RED);
                g.fillRect(10, 70, ancho, 5);

                g.setColor(Color.RED.darker());
                g.fillRect(10, 75, ancho, 10);
            }
            if (ancho < 50 && ancho >= 25) {
                g.setColor(Color.ORANGE);
                g.fillRect(10, 70, ancho, 5);

                g.setColor(Color.ORANGE.darker());
                g.fillRect(10, 75, ancho, 10);
            }
            if (ancho < 75 && ancho >= 50) {
                g.setColor(Color.YELLOW);
                g.fillRect(10, 70, ancho, 5);

                g.setColor(Color.YELLOW.darker());
                g.fillRect(10, 75, ancho, 10);
            }
            if (ancho <= 100 && ancho >= 75) {
                g.setColor(Color.GREEN);
                g.fillRect(10, 70, ancho, 5);

                g.setColor(Color.GREEN.darker());
                g.fillRect(10, 75, ancho, 10);
            }
        }

    }
}
