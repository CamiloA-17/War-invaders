/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.interfaz_usuario;

import game.principal.Constante;
import game.principal.entes.Jugador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *En esta clase se encuentra la barra inferior donde aparecen los atributos del jugador
 * y los objetos que tiene equipados
 * 
 * 
 * @author      Camilo Molano
 * @author      Martin Ostios
 * 
 * @version     1.0.0
 * 
 */
public class MenuInferior {

    private Rectangle areaInventario;
    private Rectangle bordeAreaInventario;

    public MenuInferior(final Jugador jugador) {
        int altoMenu = 64;

        this.areaInventario = new Rectangle(0, Constante.ALTO_VENTANA - altoMenu, Constante.ANCHO_VENTANA, altoMenu);
        this.bordeAreaInventario = new Rectangle(areaInventario.x, areaInventario.y - 1, areaInventario.width, 1);
    }

    public void dibujar(final Graphics g, final Jugador jugador) {
        dibujarAreaInventario(g);
        dibujarBarraVitalidad(g, jugador.resistencia);
        dibujarBarraVida(g, jugador.vida);
        dibujarBarraExperiencia(g, 63);
        dibujarRanurasObjetos(g);
    }

    public void dibujarAreaInventario(final Graphics g) {
        g.setColor(new Color(23, 23, 23));
        g.fillRect(areaInventario.x, areaInventario.y, areaInventario.width, areaInventario.height);
        g.setColor(Color.WHITE);
        g.drawRect(bordeAreaInventario.x, bordeAreaInventario.y, bordeAreaInventario.width, bordeAreaInventario.height);
    }

    private void dibujarBarraVida(final Graphics g, final int vida) {
        final int medidaVertical = 6;
        final int anchoTotal = 100;
        int ancho = 100 * vida / 100;
        g.setColor(Color.red);
        g.fillRect(areaInventario.x + 45, areaInventario.y + medidaVertical, ancho, medidaVertical * 2);
        g.setColor(Color.white);
        g.drawString("VIDA", areaInventario.x + 10, areaInventario.y + 15);
        g.drawString("" + vida, anchoTotal + 55, areaInventario.y + 15);
    }

    private void dibujarBarraVitalidad(final Graphics g, final int resistencia) {
        final int medidaVertical = 6;
        final int anchoTotal = 100;
        int ancho = 100 * resistencia / 600;
        g.setColor(Color.GREEN);
        g.fillRect(areaInventario.x + 45, areaInventario.y + medidaVertical * 2 + 10, ancho, medidaVertical * 2);
        g.setColor(Color.white);
        g.drawString("STA", areaInventario.x + 10, areaInventario.y + 32);
        g.drawString("" + resistencia, anchoTotal + 55, areaInventario.y + 32);
    }

    private void dibujarBarraExperiencia(final Graphics g, final int experiencia) {
        final int medidaVertical = 6;
        final int anchoTotal = 100;
        int ancho = 100 * experiencia / 100;
        g.setColor(Color.PINK);
        g.fillRect(areaInventario.x + 45, areaInventario.y + medidaVertical * 5 + 10, ancho, medidaVertical * 2);
        g.setColor(Color.white);
        g.drawString("EXP", areaInventario.x + 10, areaInventario.y + 50);
        g.drawString(experiencia + "%", anchoTotal + 55, areaInventario.y + 50);
    }

    public void dibujarRanurasObjetos(final Graphics g) {
        final int anchoRaruna = 32;
        final int cantidadRanuras = 10;
        final int gap = 10;
        final int anchoTotal = anchoRaruna * cantidadRanuras + gap * cantidadRanuras;
        final int xInicial = Constante.ANCHO_VENTANA - anchoTotal;
        final int anchoRanuraYEspacio = anchoRaruna + gap;
        g.setColor(Color.WHITE);
        for (int i = 0; i < cantidadRanuras; i++) {
            final int xActual = xInicial + anchoRanuraYEspacio * i;
            g.drawRect(xActual, areaInventario.y + 10, anchoRaruna, anchoRaruna);
            g.drawString("" + i, xActual + 13, areaInventario.y + 60);
        }
    }

//    public static void dibujarBarraResistencia(Graphics g, int resistencia) {
//        int ancho = 100 * resistencia / 600;
//        Color rojoOscuro = new Color(153, 0, 0);
//        g.setColor(Color.WHITE);
//        g.drawRect(9, 69, 102, 17);
//
//        if (ancho > 0) {
//            if (ancho < 25) {
//                g.setColor(Color.RED);
//                g.fillRect(10, 70, ancho, 5);
//
//                g.setColor(Color.RED.darker());
//                g.fillRect(10, 75, ancho, 10);
//            }
//            if (ancho < 50 && ancho >= 25) {
//                g.setColor(Color.ORANGE);
//                g.fillRect(10, 70, ancho, 5);
//
//                g.setColor(Color.ORANGE.darker());
//                g.fillRect(10, 75, ancho, 10);
//            }
//            if (ancho < 75 && ancho >= 50) {
//                g.setColor(Color.YELLOW);
//                g.fillRect(10, 70, ancho, 5);
//
//                g.setColor(Color.YELLOW.darker());
//                g.fillRect(10, 75, ancho, 10);
//            }
//            if (ancho <= 100 && ancho >= 75) {
//                g.setColor(Color.GREEN);
//                g.fillRect(10, 70, ancho, 5);
//
//                g.setColor(Color.GREEN.darker());
//                g.fillRect(10, 75, ancho, 10);
//            }
//        }
//    }
    public MenuInferior() {
    }
}
