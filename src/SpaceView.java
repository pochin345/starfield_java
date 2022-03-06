import javax.swing.*;
import java.awt.*;

public class SpaceView extends JFrame {

    private static final int LONGEST_DELAY = 1000;

    private PanelView view;
    private final Space space;
    private boolean running;
    private int delay;

    public SpaceView(Space space, int numberOfStars) {
        super("Star-field");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.space = space;
        this.running = false;
        setDelay(50);
        setupSpace();
        pack();
        setVisible(true);
    }

    public void setupSpace() {
        Container container = getContentPane();
        view = new PanelView(800, 800);
        container.add(view, BorderLayout.CENTER);
    }

    public void showStars() {
        Star[] stars = space.getStars();
        if (!isVisible()) {
            setVisible(true);
        }

        view.preparePaint();
        for (Star star : stars) {
            view.drawStar(star, Color.orange);
        }
        view.repaint();
    }

    private void setDelay(int speedPercentage) {
        delay = (int) ((100.0 - speedPercentage) * LONGEST_DELAY / 100);
    }

//        private class Runner extends SwingWorker<Boolean, Void> {
//        public Boolean doInBackground() {
//            while (running) {
//                space.step();
//                showStars();
//                try {
//                    Thread.sleep(delay);
//                }
//                catch (InterruptedException exception) {
//                }
//            }
//            return true;
//        }
//    }
//
    public class PanelView extends JPanel {

        private int width;
        private int height;
        private Dimension size;
        private Graphics graphics;
        private Graphics2D graphics2D;
        private Image image;

        public PanelView(int width, int height) {
            this.width = width;
            this.height = height;
            size = new Dimension(0, 0);
        }

        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }

        public void preparePaint() {
            if (!size.equals(getSize())) {
                size = getSize();
                image = view.createImage(size.width, size.height);
                graphics = image.getGraphics();
                graphics.setColor(Color.blue);
                graphics.fillRect(0, 0, size.width, size.height);
            }
        }

        public void paintComponent(Graphics graphics) {
            if (image != null) {
                Dimension currentSize = getSize();
                if (size.equals(currentSize)) {
                    graphics.drawImage(image, 0, 0, null);
                } else {
                    // Rescale the previous image.
                    graphics.drawImage(image, 0, 0, currentSize.width, currentSize.height, null);
                }
            }
        }

        public void drawStar(Star star, Color color) {
            int x = (star.getX() - star.MIN_WIDTH) * width / (star.MAX_WIDTH - star.MIN_WIDTH);
            int y = (star.getY() - star.MIN_HEIGHT) * height / (star.MAX_HEIGHT - star.MIN_HEIGHT);
            graphics.setColor(color);
            graphics.fillOval(x, y, 8, 8);
        }
    }
}
