import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

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
//        setDelay(50);
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
            view.drawStar(star, Color.black);
        }
        view.repaint();
    }

    private void setDelay(int speedPercentage) {
        delay = (int) ((100.0 - speedPercentage) * LONGEST_DELAY / 100);
    }

    //    private class Runner extends SwingWorker<Boolean, Void> {
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
            System.out.println("size:" + size);
            if (!size.equals(getSize())) {
                System.out.println("I am here!!");
                System.out.println("getSize():" + getSize());
                size = getSize();
                image = view.createImage(size.width, size.height);
                graphics2D = (Graphics2D) image.getGraphics();
                graphics2D.setColor(Color.white);
                graphics2D.fillRect(0, 0, size.width, size.height);
            }
        }

        public void paintComponent(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            if (image != null) {
                Dimension currentSize = getSize();
                if (size.equals(currentSize)) {
                    graphics2D.drawImage(image, 0, 0, null);
                } else {
                    // Rescale the previous image.
                    graphics2D.drawImage(image, 0, 0, currentSize.width, currentSize.height, null);
                }
            }
        }

        public void drawStar(Star star, Color color) {
//            graphics.translate(width/2, height/2);
            int x = (star.getX() - star.MIN_WIDTH) * width / (star.MAX_WIDTH - star.MIN_WIDTH);
            int y = (star.getY() - star.MIN_HEIGHT) * height / (star.MAX_HEIGHT - star.MIN_HEIGHT);
//            System.out.println("x:"+x+",y:"+y);
            Ellipse2D ellipse2D = new Ellipse2D.Double(x, y, 8, 8);
            graphics2D.setColor(color);
            graphics2D.fill(ellipse2D);
        }

        //    private final int NUMBEROFSTARS = 100;
        //    private Graphics2D graphics2D;
        //
        //    private void drawStars() {
        //        for (Star star:stars) {
        //            star.update();
        //            star.draw(graphics2D);
        //        }
        //    }
        //
        //    private void createStars() {
        //        stars = new Star[NUMBEROFSTARS];
        //    }
        //
        //    public Canvas(int width, int height) {
        //        this.width = width;
        //        this.height = height;
        //        createStars();
        //    }
        //
        //    protected void paintComponent(Graphics graphics) {
        //        graphics2D = (Graphics2D) graphics;
        //
        //        RenderingHints renderingHints = new RenderingHints(
        //                RenderingHints.KEY_ANTIALIASING,
        //                RenderingHints.VALUE_ANTIALIAS_ON
        //        );
        //
        //        graphics2D.translate(width/2.0, height/2.0);
        //
        //        Rectangle2D.Double rectangle = new Rectangle2D.Double(-width, -height, width*2, height*2);
        //        graphics2D.setBackground(Color.black);
        //        graphics2D.fill(rectangle);
        //
        //        drawStars();
        //    }
    }
}
