package eu.jeaneudes.xebia;

/**
 * définit l'orientation de la tondeuse. Pour chaque direction, on définit le vecteur direction associée.
 */
public enum Orientation {

    /**
     * Nord : vecteur(0, 1)
     */
    N(0, 1),
    /**
     * est : vecteur(1, O)
     */
    E(1, 0),
    /**
     * Ouest : vecteur(-1, 0)
     */
    W(-1, 0),
    /**
     * Sud : vecteur(0, -1)
     */
    S(0, -1);

    private final int x;
    private final int y;

    Orientation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
