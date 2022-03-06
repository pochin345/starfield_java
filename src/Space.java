public class Space {

    private static final int DEFAULT_NUMBER_OF_STARS = 100;
    private Star[] stars;
    private final SpaceView view;

    public Space() {
        this(DEFAULT_NUMBER_OF_STARS);
    }

    public Space(int numberOfStars) {
        view = new SpaceView(this, numberOfStars);
        setup(numberOfStars);
        view.showStars();
    }

    private void setup(int numberOfStars) {
        stars = new Star[numberOfStars];
        for (int i=0; i<numberOfStars; i++) {
            stars[i] = new Star();
        }
    }

    /**
     * Move starts to the left by one unit distance
     */
    public void step() {
        for (Star star:stars) {
            star.getNextState();
        }
    }

    public Star[] getStars() {
        return stars;
    }

}
