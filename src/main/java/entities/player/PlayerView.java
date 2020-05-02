package entities.player;

import entities.EntityView;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Render the players view and its components
 */
public class PlayerView extends EntityView {

    public PlayerView(BufferedImage image, Point loc) {
        super(image, loc);
    }

    /**
     * Renders current players image and sub-components
     */
    @Override
    public void renderView(Graphics2D brush) {
        if (hasImage()) {
            super.renderView(brush);
        }else {
            brush.setColor(Color.cyan);
            brush.fillRect(loc.x, loc.y, 20, 20);
        }

    }
}
