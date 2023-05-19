package game.graphics;

/**
 * 
 * 
 */
public final class Sprite {
    /**
     * 
     */
    private final int lado;
    private int x;
    private int y;
    public int[] pixeles;
    private SpriteSheet hoja;
    
    //Colección de spreets
    public static final Sprite GRASS = new Sprite(32, 0, 0, SpriteSheet.spriteSheet);
    public static final Sprite VOID = new Sprite(32, 0);
    //Fin de colección de sprites
    
    

    public Sprite(final int lado, final int columna, final int fila, final SpriteSheet hoja) {
        this.lado = lado;
        pixeles = new int[lado * lado];
        this.x = columna*lado;
        this.y = columna*lado;
        this.hoja = hoja;
        for(int y = 0; y < lado; y++){
            for(int x = 0; x < lado; x++){
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    }
    
    public Sprite(final int lado, final int color){
        this.lado = lado;
        pixeles = new int[lado * lado];
        
        for(int i = 0; i < pixeles.length; i++){
            pixeles[i] = color;
        }
    }

    public int getLado() {
        return lado;
    }
    
    
}
