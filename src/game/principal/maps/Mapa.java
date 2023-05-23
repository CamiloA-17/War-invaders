package game.principal.maps;

import game.objetos.BotellaAgua;
import game.objetos.Objeto;
import game.objetos.Manzana;
import game.principal.Constante;
import game.principal.entes.Jugador;
import game.principal.sprites.HojaSprite;
import game.principal.sprites.Sprite;
import game.principal.tools.CargadorRecursos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Mapa extends Sprite {

    private final String[] partes;
    private final BufferedImage[] paleta; //Imagenes para crear el mapa
    private final boolean[] colisiones;
    public ArrayList<Rectangle> areasColision = new ArrayList<Rectangle>();
    private final int[] sprites; //Referencias al dibujo de la paleta que va en cada cuadrado del mapa
    private final int MARGEN_X = Constante.ANCHO_VENTANA / 2 - Constante.LADO_SPRITE / 2;
    private final int MARGEN_Y = Constante.ALTO_VENTANA / 2 - Constante.LADO_SPRITE / 2;
    public ArrayList<Objeto> objetosMapa;

    public Mapa(final String ruta) {
        super(0, 0, 0, 0);
        String contenido = CargadorRecursos.leerArchivoTexto(ruta);

        partes = contenido.split("\\*");

        ancho = Integer.parseInt(partes[0].trim());
        alto = Integer.parseInt(partes[1].trim());

        String hojasUtilizadas = partes[2];
        String[] hojasSeparadas = hojasUtilizadas.split(",");

        //Lectura de la paleta de sprites
        String paletaEntera = partes[3];
        String[] partesPaleta = paletaEntera.split("#");

        paleta = asignarSprites(partesPaleta, hojasSeparadas);

        String colisionesEnteras = partes[4];
        colisiones = extraerColisiones(colisionesEnteras);

        String spritesEnteros = partes[5];
        String[] cadenasSprites = spritesEnteros.split(" ");

        sprites = extraerSprites(cadenasSprites);

        String informacionObjetos = partes[6];
        System.out.println(informacionObjetos);
        objetosMapa = asignarObjetos(informacionObjetos);
    }

    private BufferedImage[] asignarSprites(final String[] partesPaleta, final String[] hojasSeparadas) {
        BufferedImage[] paleta = new BufferedImage[partesPaleta.length];
        HojaSprite hoja = new HojaSprite("/game/imgs/hojasTexturas/" + hojasSeparadas[0].trim() + ".png", 32, true);
        for (int i = 0; i < partesPaleta.length; i++) {
            String spriteTemporal = partesPaleta[i];
            String[] partesSprite = spriteTemporal.split("-");
            int indicePaleta = Integer.parseInt(partesSprite[0].trim());
            int indiceSpriteHoja = Integer.parseInt(partesSprite[2].trim());
            paleta[indicePaleta] = hoja.getImage(indiceSpriteHoja);
        }
        return paleta;
    }

    public void escribirArray() {
        for (int i = 0; i < partes.length; i++) {
            System.out.println(partes[i]);
        }
    }

    private boolean[] extraerColisiones(final String cadenaColisiones) {
        boolean[] colisiones = new boolean[cadenaColisiones.length()];
        for (int i = 0; i < cadenaColisiones.length(); i++) {
            if (cadenaColisiones.charAt(i) == '0') {
                colisiones[i] = false;
            } else {
                colisiones[i] = true;
            }
        }
        return colisiones;
    }

    private int[] extraerSprites(final String[] cadenaSprites) {
        ArrayList<Integer> sprites = new ArrayList<Integer>();
        for (int i = 0; i < cadenaSprites.length; i++) {
            if (cadenaSprites[i].length() == 2) {
                sprites.add(Integer.parseInt(cadenaSprites[i]));
            } else {
                String uno = "";
                String dos = "";
                String error = cadenaSprites[i];
                uno += error.charAt(0);
                uno += error.charAt(1);
                dos += error.charAt(2);
                dos += error.charAt(3);
                sprites.add(Integer.parseInt(uno));
                sprites.add(Integer.parseInt(dos));
            }
        }
        int[] vectorSprites = new int[sprites.size()];
        for (int i = 0; i < sprites.size(); i++) {
            vectorSprites[i] = sprites.get(i);
        }
        return vectorSprites;
    }

    private ArrayList<Objeto> asignarObjetos(final String informacionObjetos) {
        final ArrayList<Objeto> objetos = new ArrayList<Objeto>();

        String[] contenedoresObjetos = informacionObjetos.split("#");

        for (String contenedoresIndividuales : contenedoresObjetos) {
            Objeto nuevoObjeto = null;
            final String[] divisionInformacionObjetos = contenedoresIndividuales.split(":");
            final String[] coordenadas = divisionInformacionObjetos[0].split(",");
            final int idObjeto = Integer.parseInt(divisionInformacionObjetos[1].trim());
            if (idObjeto == 1) {
                nuevoObjeto = new Manzana(Integer.parseInt(coordenadas[0].trim()), Integer.parseInt(coordenadas[1].trim()));
            }
            
            if(idObjeto == 2){
                nuevoObjeto = new BotellaAgua(Integer.parseInt(coordenadas[0].trim()), Integer.parseInt(coordenadas[1].trim()));
            }
            objetos.add(nuevoObjeto);
        }

        return objetos;
    }

    public void dibujar(Graphics g, final int posicionX, final int posicionY, Jugador jugador) {
        for (int y = 0; y < this.alto; y++) {
            for (int x = 0; x < this.ancho; x++) {
                int puntoX = x * Constante.LADO_SPRITE - posicionX + MARGEN_X;
                int puntoY = y * Constante.LADO_SPRITE - posicionY + MARGEN_Y;
                g.drawImage(paleta[sprites[x + y * (int) this.ancho]], puntoX, puntoY, null);
                g.setColor(Color.GREEN);
            }
        }
        if (!objetosMapa.isEmpty()) {
            for (Objeto objeto : objetosMapa) {
                final int puntoX = objeto.obtenerPosicion().x * Constante.LADO_SPRITE
                        - (int)jugador.getPosicionX() + MARGEN_X;
                final int puntoY = objeto.obtenerPosicion().y * Constante.LADO_SPRITE
                        - (int)jugador.getPosicionY() + MARGEN_Y;

                objeto.dibujar(g, puntoX, puntoY);
            }
        }

    }

    public void actualizar(final int posicionX, final int posicionY, Jugador jugador) {
        actualizarAreasColision(posicionX, posicionY);
        actualizarRecogidaObjetos(jugador);
    }
    private void actualizarRecogidaObjetos(Jugador jugador) {
        if (!objetosMapa.isEmpty()) {
            final Rectangle areaJugador = new Rectangle((int)jugador.getPosicionX(),
                   (int)jugador.getPosicionY(), Constante.LADO_SPRITE, Constante.LADO_SPRITE);

            for (int i = 0; i < objetosMapa.size(); i++) {
                final Objeto objeto = objetosMapa.get(i);

                final Rectangle posicionContenedor = new Rectangle(
                        objeto.obtenerPosicion().x * Constante.LADO_SPRITE,
                        objeto.obtenerPosicion().y * Constante.LADO_SPRITE, Constante.LADO_SPRITE,
                        Constante.LADO_SPRITE);

                if (areaJugador.intersects(posicionContenedor)) {
                    objeto.recoger(jugador);
                    objetosMapa.remove(i);
                }
            }
        }
    }

    private void actualizarAreasColision(final int posicionX, final int posicionY) {
        if (!areasColision.isEmpty()) {
            areasColision.clear();
        }

        for (int y = 0; y < this.alto; y++) {
            for (int x = 0; x < this.ancho; x++) {
                int puntoX = x * Constante.LADO_SPRITE - posicionX + MARGEN_X;
                int puntoY = y * Constante.LADO_SPRITE - posicionY + MARGEN_Y;
                if (colisiones[x + y * (int) this.ancho]) {
                    final Rectangle r = new Rectangle(puntoX, puntoY, Constante.LADO_SPRITE, Constante.LADO_SPRITE);
                    areasColision.add(r);
                }
            }
        }
    }

    public Rectangle obtenerBordes(final int posicionX, final int posicionY, final int anchoJugador, final int altoJugador) {
        int x = MARGEN_X - posicionX + anchoJugador;
        int y = MARGEN_Y - posicionY + altoJugador;
        int ancho = (int) this.ancho * Constante.LADO_SPRITE - anchoJugador * 2;
        int alto = (int) this.alto * Constante.LADO_SPRITE - altoJugador * 2;
        return new Rectangle(x, y, ancho, alto);
    }
}
