import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Star {

    public static final int MIN_WIDTH = -1000;
    public static final int MIN_HEIGHT = -1000;
    public static final int MIN_DEPTH = -1000;
    public static final int MAX_WIDTH = 1000;
    public static final int MAX_HEIGHT = 1000;
    public static final int MAX_DEPTH = 1000;

    private int x;
    private int y;
    private int z;
    private Random random;

    public Star() {
        random = new Random();
        x = random.nextInt(MAX_WIDTH - MIN_WIDTH + 1) + MIN_WIDTH;
        y = random.nextInt(MAX_HEIGHT - MIN_HEIGHT + 1) + MIN_HEIGHT;
        z = random.nextInt(MAX_DEPTH + MIN_DEPTH + 1) + MIN_DEPTH;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double map(double value, double l1, double u1, double l2, double u2) {
        return value * (u2 - l2) / (u1 - l1);
    }

    public void getNextState() {
        x = x - 20;
        if (x < MIN_WIDTH) {
            x = random.nextInt(MAX_WIDTH - MIN_WIDTH + 1) + MIN_WIDTH;
        }
    }

    public void draw(Graphics2D graphics2D) {
        Ellipse2D ellipse2D = new Ellipse2D.Double(x, y, 8, 8);
        graphics2D.setColor(Color.white);
        graphics2D.fill(ellipse2D);
    }
}
