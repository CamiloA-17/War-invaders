/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.principal.graphics;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author izibr
 */
public class Ventana extends JFrame{
    private String titulo;
    
    public Ventana(final String titulo,  final SuperficieDibujo surface){
        this.titulo = titulo;
        configurarVentana(surface);
    }
    
    public void configurarVentana(final SuperficieDibujo surface){
        setTitle(titulo);
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
