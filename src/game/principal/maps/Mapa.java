package game.principal.maps;

import game.principal.sprites.HojaSprite;
import game.principal.sprites.Sprite;
import game.principal.tools.CargadorRecursos;
import java.util.ArrayList;

public class Mapa {
    
    private final String[] partes;
    private final int alto;
    private final int ancho;
    private final Sprite[] paleta;
    private final boolean[] colisiones;
    private final int[] sprites;

    public Mapa(final String ruta){
        String contenido = CargadorRecursos.leerArchivoTexto(ruta);
        
        partes = contenido.split("\\*");
        
        ancho= Integer.parseInt(partes[0].trim());
        alto= Integer.parseInt(partes[1].trim());
        
        String hojasUtilizadas= partes[2];
        String[] hojasSeparadas = hojasUtilizadas.split(",");
        
        //Lectura de la paleta de sprites
        String paletaEntera = partes[3];
        String[] partesPaleta = paletaEntera.split("#");
        
        paleta= asignarSprites(partesPaleta,hojasSeparadas);
        
        String colisionesEnteras= partes[4]; 
        colisiones= extraerColisiones(colisionesEnteras);
        
        String spritesEnteros= partes[5];
        String[] cadenasSprites= spritesEnteros.split(" ");
        
        sprites= extraerSprites(cadenasSprites);
    }
    
    private Sprite[] asignarSprites(final String[] partesPaleta, final String[] hojasSeparadas){
        Sprite[] paleta = new Sprite[partesPaleta.length];
        HojaSprite hoja= new HojaSprite("/game/imgs/hojasTexturas/" + hojasSeparadas[0] + ".png", 32, true);
        for (int i = 0; i < partesPaleta.length; i++) {
            String spriteTemporal = partesPaleta[i];
            String[] partesSprite = spriteTemporal.split("-");
            int indicePaleta= Integer.parseInt(partesSprite[0]);
            int indiceSpriteHoja= Integer.parseInt(partesSprite[2]);
            paleta[indicePaleta]= hoja.getSprite(indiceSpriteHoja);
            
        }
        return paleta;
    }
    
    public void escribirArray(){
        for (int i = 0; i < partes.length; i++) {
            System.out.println(partes[i]);
        }
    }
    
    private boolean[] extraerColisiones(final String cadenaColisiones){
        boolean[] colisiones = new boolean[cadenaColisiones.length()];
        for (int i = 0; i < cadenaColisiones.length(); i++) {
            if(cadenaColisiones.charAt(i)=='0'){
                colisiones[i]= false;
            }
            else{
                colisiones[i]=true;
            }
        }
        return colisiones;
    }
    
    private int[] extraerSprites(final String[] cadenaSprites){
        ArrayList<Integer> sprites = new ArrayList<Integer>();
        for (int i = 0; i < cadenaSprites.length; i++) {
            if(cadenaSprites[i].length()==2){
                sprites.add(Integer.parseInt(cadenaSprites[i]));
            }else{
                String uno="";
                String dos="";
                String error= cadenaSprites[i];
                uno+= error.charAt(0);
                uno+= error.charAt(1);
                dos+= error.charAt(2);
                dos+= error.charAt(3);
                sprites.add(Integer.parseInt(uno));
                sprites.add(Integer.parseInt(dos));
            }
        }
        int[] vectorSprites= new int[sprites.size()];
        for (int i = 0; i < sprites.size(); i++) {
            vectorSprites[i]=sprites.get(i);
        }
        return vectorSprites;
    }
}
