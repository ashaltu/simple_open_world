package entities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Updates data about clients input
 */
public class PlayerKeyTracker implements KeyListener {

    public static double dx;
    public static double dy;

    private static Set<Integer> toPress = new HashSet<>();

    /**
     * Only one pair of opposite directions may be true at a time.
     *
     * Ex.: up & left, down & right, up & right, down & left
     *
     * Never up & down or left & right
     */
    private static boolean up;
    private static boolean down;
    private static boolean left;
    private static boolean right;

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // Unused method
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (keyUp(key)) {
            if (down) {
                toPress.add(key);
                return;
            }
            up = true;
            dy = -5;
        } else if (keyDown(key)) {
            if (up) {
                toPress.add(key);
                return;
            }
            down = true;
            dy = 5;
        } else if (keyLeft(key)) {
            if (right) {
                toPress.add(key);
                return;
            }
            left = true;
            dx = -5;
        } else if (keyRight(key)) {
            if (left) {
                toPress.add(key);
                return;
            }
            right = true;
            dx = 5;
        }
    }

    /**
     * Return if key intends to move upwards
     *
     * @param key client's keyboard input
     * @return up arrow or w is pressed
     */
    public boolean keyUp(int key) {
        return key == KeyEvent.VK_UP || key == KeyEvent.VK_W;
    }

    /**
     * Return if key intends to move downwards
     *
     * @param key client's keyboard input
     * @return down arrow or s is pressed
     */
    public boolean keyDown(int key) {
        return key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S;
    }

    /**
     * Return if key intends to move leftwards
     *
     * @param key client's keyboard input
     * @return left arrow or a is pressed
     */
    public boolean keyLeft(int key) {
        return key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A;
    }

    /**
     * Return if key intends to move rightwards
     *
     * @param key client's keyboard input
     * @return right arrow or d is pressed
     */
    public boolean keyRight(int key) {
        return key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D;
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (keyUp(key)) {
            up = false;
            if (toPress.contains(KeyEvent.VK_DOWN) || toPress.contains(KeyEvent.VK_S)) {
                toPress.remove(KeyEvent.VK_DOWN);
                toPress.remove(KeyEvent.VK_S);
                down = true;
                dy = 5;
            } else if (!down) dy = 0;
        } else if (keyDown(key)) {
            down = false;
            if (toPress.contains(KeyEvent.VK_UP) || toPress.contains(KeyEvent.VK_W)) {
                toPress.remove(KeyEvent.VK_UP);
                toPress.remove(KeyEvent.VK_W);
                up = true;
                dy = -5;
            } else if (!up) dy = 0;
        } else if (keyLeft(key)) {
            left = false;
            if (toPress.contains(KeyEvent.VK_RIGHT) || toPress.contains(KeyEvent.VK_D)) {
                toPress.remove(KeyEvent.VK_RIGHT);
                toPress.remove(KeyEvent.VK_D);
                right = true;
                dx = 5;
            } else if (!right) dx = 0;
        } else if (keyRight(key)) {
            right = false;
            if (toPress.contains(KeyEvent.VK_LEFT) || toPress.contains(KeyEvent.VK_A)) {
                toPress.remove(KeyEvent.VK_LEFT);
                toPress.remove(KeyEvent.VK_A);
                left = true;
                dx = -5;
            } else if (!left) dx = 0;
        }
    }

}
