package view;

import java.awt.Graphics2D;

/**
 * Every View type class implements this to coordinate rendering across all views
 */
public interface View {

    /**
     * Render any components here
     *
     * @param brush renders this components view
     */
    void renderView(Graphics2D brush);

}
