import entities.EntityController;
import screen.ScreenController;
import screen.ScreenView;
import status.Status;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Manage all controller classes for this game
 */
public class GameController {

    /**
     * Refresh rate data
     */
    private final int FPS = 60;
    private long TPS = 1000 / FPS;

    /**
     * Fields for drawing our components
     */
    private Graphics2D brush;
    private BufferedImage canvas;

    /**
     * Game screen data
     */
    private Status status;

    /**
     * Controllers
     */
    private ScreenController screen;
    private EntityController entities;

    /**
     * MVC architecture where this class is the controller
     */
    public GameController() {
        screen = new ScreenController();
        entities = new EntityController();

        canvas = new BufferedImage(ScreenView.PREFERRED_WIDTH, ScreenView.PREFERRED_HEIGHT, BufferedImage.TYPE_INT_RGB);
        brush = (Graphics2D) canvas.getGraphics();
    }

    /**
     * Safely end the game
     */
    public void end() {
        screen.end();
        entities.end();
        // TODO:  Implement end method for all Controllers and delete exception
        throw new RuntimeException("Unimplemented method: end()");
    }

    /**
     * Run the actual game
     */
    public void run() {
        long start;
        long elapsed;
        long wait;
        status = Status.RUNNING;
        while (status == Status.RUNNING) {
            start = System.nanoTime();
            updateAll();
            renderAll();
            screen.brushCanvas(canvas);
            brush.clearRect(0, 0, ScreenView.PREFERRED_WIDTH, ScreenView.PREFERRED_HEIGHT);
            elapsed = System.nanoTime() - start;
            wait = TPS - elapsed / 1000000;
            if (wait < 0)
                wait = 5;
            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        status = Status.GAME_ENDED_SUCCESS;
    }

    /**
     * Update all of the game's models
     */
    public void updateAll() {
        entities.update();
        screen.update();
        // TODO: update all controllers
    }

    /**
     * Render all of the game's views
     */
    public void renderAll() {
        entities.render(brush);
        screen.render(brush);
        // TODO: render all controllers
    }

    /**
     * Return the game current status
     * @return the game's status
     */
    public Status status() {
        // TODO:  Implement status for components
        throw new RuntimeException("Unimplemented method: endStatus()");
        // return status;
    }
}
