package entities.player;

import controller.Controller;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Control the player's data, rendering, and movement
 */
public class PlayerController implements Controller {

    public static final int playerStartX = 20;
    public static final int playerStartY = 20;

    private PlayerView view;
    private PlayerModel model;

    public PlayerController(Rectangle hitbox, BufferedImage image) {
        this.view = new PlayerView(image, hitbox.getLocation());
        this.model = new PlayerModel(hitbox, image);
    }

    /**
     * Update players's data model
     */
    public void update() {
        model.updateModel();
        view.setImage(model.image());
        view.setLoc(model.hitbox().x, model.hitbox().y);
    }

    /**
     * Render players's components here
     *
     * @param brush all components related to the player
     */
    public void render(Graphics2D brush) {
        view.renderView(brush);
    }

}
