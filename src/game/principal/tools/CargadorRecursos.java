/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.tools;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author izibr
 */
public class CargadorRecursos {

    public static BufferedImage cargarImagenCompatibleOpaca(final String ruta) {
        Image imagen = null;

        try {
            imagen = ImageIO.read(CargadorRecursos.class.getResource(ruta));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.OPAQUE);

        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen, 0, 0, null);
        g.dispose();
        return imagenAcelerada;
    }

    public static BufferedImage cargarImagenCompatibleTranslucida(final String ruta) {
        Image imagen = null;

        try {
            imagen = ImageIO.read(CargadorRecursos.class.getResource(ruta));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.TRANSLUCENT);

        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen, 0, 0, null);
        g.dispose();
        return imagenAcelerada;
    }
    
    public static String leerArchivoTexto(final String ruta){
        String contenido= "";
        InputStream entradaBytes = CargadorRecursos.class.getResourceAsStream(ruta);
        BufferedReader lector = new BufferedReader(new InputStreamReader(entradaBytes));
        String linea;
        try {
            while((linea=lector.readLine())!= null){
                contenido += linea;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(entradaBytes!=null){
                    entradaBytes.close();
                }
                if(lector!=null){
                    lector.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return contenido;
    } 
}
