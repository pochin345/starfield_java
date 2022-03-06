
public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowCanvas());
    }

    private static void createAndShowCanvas() {
        Space space = new Space();
        space.step();
    }
}
