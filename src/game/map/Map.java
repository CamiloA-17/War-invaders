package game.map;

import game.graphics.Screen;
import game.map.tiles.Tile;


public abstract class Map {
    protected int ancho;
    protected int alto;
    
    protected int[] tiles;
    
    public Map(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
        tiles = new int[ancho * alto];
        generateMap();
    }
    
    public Map(String ruta){
        loadMap(ruta);
    }
    
    protected void generateMap(){
        
    }
    
    private void loadMap(String ruta){
        
    }
    
    public void update(){
        
        
    }
    
    public void show(final int compensacionX, final int compensacionY, final Screen screen){
        // Ver bit shifting-------
        
        screen.setDiferencia(compensacionX, compensacionY);
        int o = compensacionX >> 5;
        int e = (compensacionX + screen.getAncho() + Tile.LADO) >> 5;
        int n = compensacionY >> 5;
        int s = (compensacionY + screen.getAlto() + Tile.LADO) >> 5;
        
        for(int y = n; y < s; y++){
            for(int x = o; x < e; x++){
               getTile(x, y).show(x, y, screen);
            }
        }
    }
    
    /**
     * Se encarga de buscar cuál es el Tile que se debe pintar, cada número
     * representa un Tile
     * <p> Lista de Tiles </p>
     * <ul>
     *  <li>0: Grass</li>
     *  <li></li>
     *  <li></li>
     *  <li></li>
     *  <li></li>
     *  <li></li>
     *  <li></li>
     *  <li></li>
     * </ul>
     * @param x
     * @param y
     * @return 
     */
    public Tile getTile(final int x, final int y){
        if(x< 0 || y < 0 || x >= ancho || y >= alto){
            return Tile.VOID;
        }
        switch(tiles[x + y * ancho]){
            case 0:
                return Tile.GRASS;
            case 1:
                return Tile.DIRT;
            case 2:
                return Tile.SAND;
            case 3:
                return Tile.WATER;
            case 4:
            case 5:
            default:
                return Tile.VOID;
        }
    }
}
