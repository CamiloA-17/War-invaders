/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.game;

import game.controls.Keyboard;
import game.graphics.Screen;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

/**
 *
 * @author izibr
 */
public class Game extends Canvas implements Runnable {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    
    private static volatile boolean isRunning = false;
    
    private static final String GAME_NAME = "War Invaders";
    private static int aps = 0;
    private static int fps = 0;
    
    
    private static int x = 0;
    private static int y = 0;
    
    private static JFrame window;
    private static Thread thread;
    private static Keyboard keyboard;
    private static Screen screen;
    
    private static BufferedImage imagen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    

    private Game() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        screen = new Screen(WIDTH, HEIGHT);
        
        keyboard = new Keyboard();
        addKeyListener(keyboard);
        
        window = new JFrame(GAME_NAME);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(new BorderLayout());
        window.add(this, BorderLayout.CENTER);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        Game juego = new Game();
        juego.start();
    }

    private synchronized void start() {
        isRunning = true;
        thread = new Thread(this, "Graphics");
        thread.start();
    }

    private synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void update(){
        keyboard.update();
        
        
        if(keyboard.arriba){
            y++;
        }
        
        if(keyboard.abajo){
            y--;
        }
        
        if(keyboard.izquierda){
            x--;
        }
        
        if(keyboard.derecha){
            x++;
        }
        
        aps++;
    }
    
    public void show(){
        BufferStrategy estrategia = getBufferStrategy();
        
        if(estrategia == null){
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        screen.show(x, y);
        
        System.arraycopy(screen.pixeles, 0, pixeles, 0, pixeles.length);
        
        Graphics g = estrategia.getDrawGraphics();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        
        estrategia.show();
        fps++;
    }

    /**
     * NS_POR_SEGUNDO = Nanosegundos por segundo
     * APS = Actualizaciones por segundo
     * NS_POR_ACTUALIZACION = Nanosegundos por actualiación
     */
    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS;
        
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        
        double tiempoTranscurrido;
        double delta = 0;
        
        requestFocus();
        while(isRunning){
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
            while(delta >= 1){
                update();
                delta--;
            }
            show();
            
            if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){
                window.setTitle(GAME_NAME + " || APS: " + aps + " || FPS: " + fps);
                fps = 0;
                aps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }
}
