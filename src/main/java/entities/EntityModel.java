package entities;

import model.Model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Basic structure of an entity - immutable from outside 'entities' package
 */
public abstract class EntityModel implements Model {

    /**
     * Essential data for any entity
     */
    protected double x, y;
    protected int width, height;
    protected BufferedImage image;

    public EntityModel(double x, double y, int width, int height, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    /**
     * X coordinates of this entity
     *
     * @return x coordinate
     */
    public double x() {
        return x;
    }

    /**
     * Y coordinates of this entity
     *
     * @return y coordinate
     */
    public double y() {
        return y;
    }

    /**
     * Width of this entity
     *
     * @return entity's width
     */
    public int width() {
        return width;
    }

    /**
     * Width of this entity
     *
     * @return entity's width
     */
    public int height() {
        return height;
    }

    /**
     * Image of this entity
     *
     * @return copy of this entity's image
     */
    public BufferedImage image() {
        BufferedImage b = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g = b.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return b;
    }

}
