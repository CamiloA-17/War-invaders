package game.graphics;

public final class Screen {
    private final int ancho;
    private final int alto;
    public final int[] pixeles;
    
    // Temp
    private final static int LADO_SPRITE = 32;
    private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
    

    public Screen(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.pixeles = new int[ancho * alto];
    }
    
    public void clear(){
        for(int i = 0; i < pixeles.length; i++){
            pixeles[i] = 0;
        }
    }
    
    
    public void show(final int tempX, final int tempY){
        for(int y = 0; y < alto; y++){
            int posicionY = y + tempY;
            if(posicionY < 0 || posicionY >= alto) continue;
            for(int x = 0; x < ancho; x++){
                int posicionX = x + tempX;
                if(posicionX < 0 || posicionX >= ancho) continue;
                
                // Temp
                pixeles[posicionX + posicionY * ancho] = Sprite.grass.pixeles[(x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * LADO_SPRITE];
            }
        }
    }
    
}
