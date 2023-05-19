
package game.map.tiles;

import game.graphics.Screen;
import game.graphics.Sprite;

public abstract class Tile {
    public int x;
    public int y;
    
    public Sprite sprite;
    
    public Tile(Sprite sprite){
        this.sprite = sprite;
    }
    
    public void show(int x, int y, Screen screen){
        
    }
    
    public boolean isSolid(){
        return false;
    }
}
