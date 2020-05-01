package entities;

import java.awt.*;

/**
 * Control the player's data, rendering, and movement
 */
public class PlayerController {

    public static final int playerStartX = 20;
    public static final int playerStartY = 20;

    private PlayerView view;
    private PlayerModel model;

    public PlayerController(PlayerView view, PlayerModel model) {
        this.view = new PlayerView(view.image, view.loc);
        this.model = new PlayerModel(model.hitbox, model.image);
    }

    /**
     * Update players's data model
     */
    public void update() {
        model.updateModel();
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
