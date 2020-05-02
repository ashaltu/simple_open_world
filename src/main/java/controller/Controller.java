package controller;

import java.awt.*;

/**
 * Controls interactions between the model and view
 */
public interface Controller {

    /**
     * Updates all model components of this controller
     */
    void update();

    /**
     * Updates all view components of this controller
     *
     * @param brush related to component views
     */
    void render(Graphics2D brush);

}
