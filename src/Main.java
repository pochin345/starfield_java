import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowCanvas());
    }

    private static void createAndShowCanvas() {
        Space space = new Space();
        space.step();

//        int width = 800;
//        int height = 800;
//        SpaceView.PanelView myCanvas = new SpaceView.PanelView(width, height);
//        JFrame frame = new JFrame("Canvas Demo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(myCanvas);
//        frame.setSize(width,height);
//        frame.setBackground(Color.magenta);
//        frame.setVisible(true);
    }
}
