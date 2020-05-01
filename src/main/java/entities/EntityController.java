package entities;

import java.awt.*;

/**
 * Manages all entity data, rendering, and movement
 */
public class EntityController {
    /**
     * Entity's controllers
     */
    private PlayerController playerController;
    //private MonsterController monsterController;

    public EntityController() {
        PlayerModel model = new PlayerModel(new Rectangle(20, 20, 20, 20), null);
    }

    /**
     * Update all entity's data model
     */
    public void update() {
        playerController.update();
    }

    /**
     * Render all entity's components here
     *
     * @param brush all components related to all entity's
     */
    public void render(Graphics2D brush) {
        playerController.render(brush);
    }
}
