package screen;

import status.Status;

import javax.swing.*;
import java.awt.*;

/**
 * Controller for ScreenModel and ScreenView
 */
public class ScreenController {

    private JFrame screen;
    private ScreenModel model;
    private ScreenView view;

    /**
     * Make sure client's screen size is big enough before starting game
     */
    public ScreenController() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ScreenView sv = new ScreenView();
        if (screenSize.height < ScreenView.PREFERRED_HEIGHT
                || screenSize.width < ScreenView.PREFERRED_WIDTH) {
            int r = JOptionPane.showConfirmDialog(new JFrame(), "Screen too small!",
                    "Screen width/size not supported. Would you like to continue?",
                    JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }

        init();
        start();
    }

    /**
     * Initialize it's components
     */
    public void init() {
        screen = new JFrame("open-world");
        model = new ScreenModel();
        view = new ScreenView();

        // TODO: Init rest of components for ScreenController
    }

    /**
     * Start the game
     */
    public void start() {
        screen.setTitle("Open World Game");
        screen.setSize(ScreenView.PREFERRED_WIDTH, ScreenView.PREFERRED_HEIGHT);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setResizable(false);
        screen.setContentPane(view);
        screen.setVisible(true);
        screen.pack();
        view.setVisible(true);
    }

    /**
     * Safely dispose and remove all screen components
     */
    public void end() {
        screen.removeAll();
        screen.dispose();
    }

    /**
     * Return the screen's current status
     * @return the screen's current status: SUCCESS, TIMEOUT, or ERROR
     */
    public Status status() {
        // TODO:  Implement usage of status within ScreenController
        throw new RuntimeException("Unimplemented method: endStatus()");
    }

    /**
     * Update screen's data model
     */
    public void update() {
        model.updateModel();
    }

    /**
     * Render screen's components here
     *
     * @param brush all components related to the screen
     */
    public void render(Graphics2D brush) {
        view.renderView(brush);
    }

    /**
     * Paint entire game onto this panel
     *
     * @param canvas to paint over this entire panel
     */
    public void brushCanvas(Image canvas) {
        Graphics g = view.getGraphics();
        g.drawImage(canvas, 0, 0,null);
        g.dispose();
    }
}
