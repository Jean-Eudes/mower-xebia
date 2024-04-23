package eu.jeaneudes.xebia;

/**
 *
 */
public class Mower {

    /**
     * absisse de la tondeuse.
     */
    private int x;

    /**
     * ordonnée de la tondeuse.
     */
    private int y;

    /**
     * orientation de la tondeuse
     */
    private Orientation orientation;

    /**
     * Surface ou évolue la tondeuse.
     */
    private final Surface surface;

    public Mower(int x, int y, final Orientation orientation, final Surface surface) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.surface = surface;
    }

    /**
     *  Constructeur par défaut. situe la tondeuse au point de coordonnée (0,0) et orientée vers le nord.
     * @param surface la surface ou évolue la tondeuse.
     */
    public Mower(final Surface surface) {
        this(0, 0, Orientation.N, surface);
    }

    /**
     *  avance la tondeuse de 1 en fonction de son orientation. Si le déplacement est impossible, cad sort de la surface,
     *  la tondeuse ne bouge pas
     */
    public void advance() {
        if (surface.isPointInSurface(x + orientation.getX(), y + orientation.getY())) {
            this.x += orientation.getX();
            this.y += orientation.getY();
        }
    }

    /**
     * oriente la tondeuse vers la gauche.
     */
    public void turnLeft() {
        switch (orientation) {
            case N:
                this.orientation = Orientation.W;
                break;
            case W:
                this.orientation = Orientation.S;
                break;
            case S:
                this.orientation = Orientation.E;
                break;
            case E:
                this.orientation = Orientation.N;
                break;
        }
    }

    /**
     * oriente la tondeuse vers la droite.
     */
    public void turnRight() {
        switch (orientation) {
            case N:
                this.orientation = Orientation.E;
                break;
            case W:
                this.orientation = Orientation.N;
                break;
            case S:
                this.orientation = Orientation.W;
                break;
            case E:
                this.orientation = Orientation.S;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
