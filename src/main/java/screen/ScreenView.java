package screen;

import entities.PlayerKeyTracker;
import view.View;

import javax.swing.*;
import java.awt.*;

/**
 * Renders anything that needs to be drawn onto the screen
 */
public class ScreenView extends JPanel implements View {

    /**
     * Preferred width/height of our screen
     */
    public static final int PREFERRED_WIDTH = 400;
    public static final int PREFERRED_HEIGHT = 400;

    public ScreenView() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));
        this.addKeyListener(new PlayerKeyTracker());
        this.setFocusable(true);
        this.requestFocus();
        this.setVisible(true);
    }

    /**
     * Render any components here regarding the screen
     *
     * @param brush renders all screen components
     */
    @Override
    public void renderView(Graphics2D brush) {
        // TODO: Implement screen updating
    }
}
