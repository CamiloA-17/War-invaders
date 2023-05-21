/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.graphics;

import game.principal.tools.CargadorRecursos;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author izibr
 */
public class Ventana extends JFrame{
    private String titulo;
    private final ImageIcon icono;
    
    public Ventana(final String titulo,  final SuperficieDibujo surface){
        this.titulo = titulo;
        BufferedImage imagen= CargadorRecursos.cargarImagenCompatibleOpaca("/game/imgs/iconos/icono.png");
        this.icono= new ImageIcon(imagen);
        configurarVentana(surface);
        
        
    }
    
    public void configurarVentana(final SuperficieDibujo surface){
        setTitle(titulo);
        setIconImage(icono.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setIconImage(image);
        setLayout(new BorderLayout());
        add(surface, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
