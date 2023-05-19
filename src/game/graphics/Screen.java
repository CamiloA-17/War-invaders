package game.graphics;

import game.map.tiles.Tile;
/**
 * Es quien coordina todos los Sprites, guardando los que sea necesario
 * pintar y luego se los pasa a la clase Game para que los pinte.
 * @author Camilo Andrés Molano
 * @author Martin Ostios Arias
 * @version 20230519
 * @since 1.0
 * @see Game
 */
public final class Screen {
    
    /**
     * Ancho de la ventana
     */
    private final int ancho;
    
    /**
     * Alto de la ventana
     */
    private final int alto;
    
    /**
     * Es donde se guardan individualmente cada uno de los pixeles que se deben
     * presentar en pantalla. Por ejemplo si la pantalla es 600x800, este arreglo
     * tendría 480.000 posiciones
     */
    public final int[] pixeles;
    
    
    
    /**
     * Controla como se mueve nuestro personaje por el mapa horizontalmente
     */
    private int diferenciaX;
    
    /**
     * Controla como se mueve nuestro personaje por el mapa verticalmente
     */
    private int diferenciaY;
    
    
    /**
     * Constructor de la clase
     * @param ancho Ancho de la ventana
     * @param alto Alto de la ventana
     */
    public Screen(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.pixeles = new int[ancho * alto];
    }
    
    /**
     * Llena el array de pixeles de color negro (se utiliza números
     * hexadecimales)
     */
    public void clear(){
        for(int i = 0; i < pixeles.length; i++){
            pixeles[i] = 0;
        }
    }
    
    
    /**
     * Pinta los cuadros del mapa
     * @param compensacionX En que medida se ha desplazado el mapa, horizontalmente
     *              respecto a nuestro personaje
     * @param compensacionY En que medida se ha desplazado el mapa, verticalmente
     *              respecto a nuestro personaje
     * @param tile  Cuadro que hay que pintar
     */
    public void showTile(int compensacionX, int compensacionY, Tile tile){
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;
        
        for(int y = 0; y < tile.sprite.getLado(); y++){
            int posicionY = y + compensacionY;
            for(int x = 0; x < tile.sprite.getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -tile.sprite.getLado() || posicionX >= ancho || posicionY  < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                pixeles[posicionX + posicionY * ancho] = tile.sprite.pixeles[x + y * tile.sprite.getLado()];
            }
        }
    }

    public void setDiferencia(final int diferenciaX, final int diferenciaY) {
        this.diferenciaX = diferenciaX;
        this.diferenciaY = diferenciaY;
    }
    
    

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    
    
}
