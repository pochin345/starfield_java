import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MyCanvas extends JComponent {

    private int width;
    private int height;
    private Star[] stars;
    private final int NUMBEROFSTARS = 100;
    private Graphics2D graphics2D;

    private void drawStars() {
        for (Star star:stars) {
            star.update();
            star.draw(graphics2D);
        }
    }

    private void createStars() {
        stars = new Star[NUMBEROFSTARS];
        for (int i=0; i<NUMBEROFSTARS; i++) {
            stars[i] = new Star(width, height);
        }
    }

    public MyCanvas(int width, int height) {
        this.width = width;
        this.height = height;
        createStars();
    }

    protected void paintComponent(Graphics graphics) {
        graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        graphics2D.translate(width/2.0, height/2.0);

        Rectangle2D.Double rectangle = new Rectangle2D.Double(-width, -height, width*2, height*2);
        graphics2D.setBackground(Color.black);
        graphics2D.fill(rectangle);

        drawStars();
    }
}
