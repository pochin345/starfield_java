import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Star {

    private int x;
    private int y;
    private int z;
    private int width;
    private int height;
    private Random random;

    public Star(int width, int height) {
        this.width = width;
        this.height = height;
        int width2 = -(width / 2);
        int height2 = -(height / 2);

        random = new Random();
        x = random.nextInt(width + 1) + width2;
        y = random.nextInt(height + 1) + height2;
        z = random.nextInt(width);
    }

    public double map(double value, double l1, double u1, double l2, double u2) {
        return value * (u2-l2) / (u1-l1);
    }

    public void update() {
        x = x - 2;
        int width2 = -(width / 2);
        if (x < -width/2) {
            x = random.nextInt(width + 1) + width2;
        }
    }

    public void draw(Graphics2D graphics2D) {
        Ellipse2D ellipse2D = new Ellipse2D.Double(x, y, 8, 8);
        graphics2D.setColor(Color.white);
        graphics2D.fill(ellipse2D);
    }
}
