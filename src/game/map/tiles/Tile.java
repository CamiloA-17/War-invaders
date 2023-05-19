package game.map.tiles;

import game.graphics.Screen;
import game.graphics.Sprite;

public abstract class Tile {

    public int x;
    public int y;

    public Sprite sprite;
    
    public static final int LADO = 32;

    //Tile collection
    public static final Tile VOID = new VoidTile(Sprite.VOID);
    public static final Tile GRASS = new GrassTile(Sprite.GRASS);
    //End file collection
    
    
    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void show(int x, int y, Screen screen) {
        screen.showTile(x << 5, y << 5, this);
    }

    public boolean isSolid() {
        return false;
    }
}
