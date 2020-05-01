package status;

/**
 * Possible outcomes before, during, and after the game
 */
public enum Status {
    /**
     * Screen
     */
    ERROR,
    TIMEOUT,
    SUCCESS,

    /**
     * GameController
     */
    RUNNING,
    GAME_ENDED_SUCCESS
}
