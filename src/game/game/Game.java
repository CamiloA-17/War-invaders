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
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Es la clase principal del juego, conecta la lógica de negocio con la 
 * lógica de presentación.
 * @author Camilo Andrés Molano
 * @author Martin Ostios Arias
 * @version 20230519
 * @since 1.0
 */
public class Game extends Canvas implements Runnable {
    
    
    /**
     * Ancho del canvas
     */
    private static final int WIDTH = 800;
    
    /**
     * Alto del canvas
     */
    private static final int HEIGHT = 600;
    
    
    /**
     * Determina que el juego está ejecutándose
     * @see #run() 
     */
    private static volatile boolean isRunning = false;
    
    
    /**
     * Nombre del juego, se pone cuando se instancia el JFrame
     * @see #Game() 
     */
    private static final String GAME_NAME = "War Invaders";
    
    /**
     * Actualizaciones por segundo, hace referencia a que tan rápido
     * se actualizan los métodos del juego.
     * @see #run()
     * @see #update() 
     */
    private static int aps = 0;
    
    /**
     * Frames por segundo, hace referencia a qué tan rápido se pinta la ventana
     * @see #run() 
     * @see #show() 
     */
    private static int fps = 0;
    
    /**
     * Posición en x de nuestro personaje principal
     */
    private static int x = 0;
    
    /**
     * Posición en y de nuestro personaje principal
     */
    private static int y = 0;
    
    
    /**
     * Es la ventana en donde todo el juego se va a pintar
     * @see #Game() 
     */
    private static JFrame window;
    
    /**
     * Hilo que se encarga de toda la parte gráfica
     * @see #start() 
     */
    private static Thread thread;
    
    
    /**
     * Es el encargado de controlar todos los eventos que hay por teclado
     * @see #Game() 
     */
    private static Keyboard keyboard;
    
    /**
     * Es el encargado de juntar todos los Sprites y presentarlos en pantalla
     * @see #show() 
     */
    private static Screen screen;
    
    
    /**
     * Es la imagen negra que queda de fondo en la ventana
     */
    private static BufferedImage imagen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    
    /**
     * Es un array que contiene individualmente cada uno de los pixeles de 
     * la ventana
     * @see #show()
     */
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    
    /**
     * Es la imagen que se muestra por fuera del entorno del juego
     * @see #Game() 
     */
    private static final ImageIcon icono = new ImageIcon(Game.class.getResource("/game/imgs/Logo.png"));
    
    
    /**
     * Constructor de la clase principal del juego, acá se da la configuración
     * inicial del componente JFrame.
     */
    private Game() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        screen = new Screen(WIDTH, HEIGHT);
        
        keyboard = new Keyboard();
        addKeyListener(keyboard);
        
        window = new JFrame(GAME_NAME);
        window.setIconImage(icono.getImage());
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
    
    /**
     * Inicia el Thread que se encarga de los gráficos.
     * @throws IllegalThreadStateException
     *         Si el Thread ya fue iniciado
     */
    private synchronized void start() {
        isRunning = true;
        thread = new Thread(this, "Graphics");
        thread.start();
    }
    
    /**
     * Detiene el Thread que se encarga de los gráficos
     */
    private synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Actualiza el estado de los controles del juego, la cantidad de veces que
     * se ejecuta este método está dado por la variable <code>aps</code>.
     * @see #run() 
     * 
     */
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
    
    /**
     * Se encarga de pintar todo lo gráfico en pantalla, la cantidad de veces
     * que se ejecuta este método está dado por la variable <code>fps</code>.
     */
    
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
     * Es el ciclo principal del juego, es quien se encarga de poner a correr 
     * todo el juego.
     * <p><b> Variables </b></p>
     * <ul>
     *  <li>NS_POR_SEGUNDO: Nanosegundos por segundo</li>
     *  <li>APS: Actualizaciones por segundo</li>
     *  <li>NS_POR_ACTUALIZACION: Nanosegundos por actualiación</li>
     * </ul>
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
