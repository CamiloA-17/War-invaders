/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.statesmachine.states.game;

import game.principal.maps.Mapa;
import game.principal.sprites.HojaSprite;
import java.awt.Graphics;
import game.principal.statesmachine.EstadoJuego;
import game.principal.tools.CargadorRecursos;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author izibr
 */
public class GestorJuego implements EstadoJuego{
    private GestorMapa gestorMapa;
    // String texto= CargadorRecursos.leerArchivoTexto("/game/mapas/texto.txt");
    Mapa mapa= new Mapa("/game/mapas/texto.txt");
    @Override
    public void actualizar() {
        
    }

    @Override
    public void dibujar(Graphics g) {
        mapa.dibujar(g);
    }
    
}
