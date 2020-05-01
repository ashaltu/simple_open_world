package entities;

import view.View;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * View of an entity, meant for easy control of all Viewable entities
 */
public abstract class EntityView implements View {

    /**
     * View's perspective of the image
     */
    protected BufferedImage image;
    protected Point loc;

    public EntityView(BufferedImage image, Point loc) {
        this.image = image;
        this.loc = loc;
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
     * Updating the entity's image data
     *
     * @param image to replace our current image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Updating the entity's current image loc
     *
     * @param x to replace our current loc.x
     * @param y to replace our current loc.y
     */
    public void setLoc(int x, int y) {
        this.loc = new Point(x, y);
    }

    /**
     * Render anything with the player here
     *
     * @param brush renders the player view
     */
    public void renderView(Graphics2D brush) {
        brush.drawImage(image, loc.x, loc.y, null);
    }
}
