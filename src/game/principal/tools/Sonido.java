/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.tools;

import javax.sound.sampled.Clip;

/**
 *
 * @author izibr
 */
public class Sonido {

    final private Clip sonido;

    public Sonido(final String ruta) {
        sonido = CargadorRecursos.cargarSonido(ruta);
    }

    public void reproducir() {
        sonido.stop();
        sonido.flush();
        sonido.setMicrosecondPosition(0);
        sonido.start();
    }

    public void repetir() {
        sonido.stop();
        sonido.flush();
        sonido.setMicrosecondPosition(0);

        sonido.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public long obtenerDuracion() {
        return sonido.getMicrosecondLength();
    }
}
