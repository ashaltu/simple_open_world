package entities.player;

import entities.EntityModel;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Manage data on the player
 */
public class PlayerModel extends EntityModel {

    public static final double MAX_DX = 5;
    public static final double MAX_DY = 5;
    public static final double SPEED = 5;

    public PlayerModel(Rectangle hitbox, BufferedImage image) {
        super(hitbox, image);
    }

    /**
     * Updates current Model data
     */
    @Override
    public void updateModel() {
        move(PlayerKeyTracker.dx, PlayerKeyTracker.dy);
    }
}
