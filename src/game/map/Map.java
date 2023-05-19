package game.map;

import game.graphics.Screen;


public abstract class Map {
    private int ancho;
    private int alto;
    
    private int[] tiles;
    
    public Map(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
        tiles = new int[ancho * alto];
        generateMap();
    }
    
    public Map(String ruta){
        loadMap(ruta);
    }
    
    private void generateMap(){
        
    }
    
    private void loadMap(String ruta){
        
    }
    
    public void update(){
        
        
    }
    
    public void show(int tempX, int tempY, Screen screen){
        
    }
}
