package eu.jeaneudes.xebia;

/**
 * Représente une surface.
 */
public interface Surface {
    /**
     *  Méthode permettant de savoir si un point d'absisse x et d'ordonnée y est contenu ou non dans la surface.
     * @param x absisse du point.
     * @param y ordonnée du point
     * @return  true si le point et dans la surface, false sinon
     */
    boolean isPointInSurface(int x, int y);
}
