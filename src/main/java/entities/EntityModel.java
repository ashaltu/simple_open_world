package entities;

import model.Model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Basic structure of an entity
 */
public abstract class EntityModel implements Model {

    /**
     * Essential data for any entity
     */
    protected Rectangle hitbox;
    protected BufferedImage image;

    public EntityModel(Rectangle hitbox, BufferedImage image) {
        this.hitbox = hitbox;
        this.image = image;
    }

    /**
     * Check if this entity has an image
     *
     * @return true if image != null, else false
     */
    public boolean hasImage() {
        return image != null;
    }

    public Rectangle hitbox() {
        return new Rectangle(hitbox);
    }

    /**
     * X coordinate of this entity
     *
     * @return x coordinate
     */
    public double x() {
        return hitbox.x;
    }

    /**
     * Y coordinate of this entity
     *
     * @return y coordinate
     */
    public double y() {
        return hitbox.y;
    }

    /**
     * Width of this entity
     *
     * @return entity's width
     */
    public int width() {
        return hitbox.width;
    }

    /**
     * Width of this entity
     *
     * @return entity's width
     */
    public int height() {
        return hitbox.height;
    }

    /**
     * Translates this entity by dx, dy
     *
     * @param dx translate x by dx
     * @param dy translate y by dy
     */
    public void move(double dx, double dy) {
        hitbox.translate((int)Math.round(dx), (int)Math.round(dy));
    }

    /**
     * Image of this entity
     *
     * @return copy of this entity's image
     */
    public BufferedImage image() {
        /* Returning copy is unnecessary
        BufferedImage b = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g = b.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
         */
        return image;
    }

}
