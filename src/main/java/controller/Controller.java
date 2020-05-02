package controller;

import java.awt.*;

/**
 * Controls interactions between the model and view
 */
public interface Controller {

    /**
     * Updates all model components of this class
     */
    void update();

    /**
     * Updates all view components of this class
     */
    void render(Graphics2D brush);

}
