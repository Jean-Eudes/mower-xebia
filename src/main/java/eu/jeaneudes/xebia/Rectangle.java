package eu.jeaneudes.xebia;

/**
 * Représente une surface rectangulaire avec comme origine (0, 0)
 */
public class Rectangle implements Surface {

    /**
     * longueur du rectangle.
     */
	private final int width;

    /**
     * largeur du rectangle.
     */
	private final int height;
	/**
     * @param width  longueur.
     * @param height largeur.
     */
    public Rectangle(int width, int height) {
	    this.width = width;
	    this.height = height;
    }

    /**
     * Teste si l'absisse du point est compris entre 0 et sa longueur, et si l'ordonnée du point est compris entre 0 et sa hauteur.
     * @param x absisse du point.
     * @param y ordonnée du point
     * @return true si le point est dans le rectangle, false sinon.
     */
    public boolean isPointInSurface(int x, int y) {
        boolean a = (x >= 0) && (x  <= width);
        boolean b = (y >= 0) && (y  <= height);

        return a && b;
    }

	public int getWidth() {
    	return width;
    }

	public int getHeight() {
    	return height;
    }
}
