/**
 * Launch game here
 */
public class Launcher {

    /**
     * Launch game, report game's end status when finished, end game safely
     */
    public static void launch() {
        GameController game = new GameController();
        game.run();
        switch (game.status()) {
            case ERROR:
                System.out.println("Game ended due to an error");
                break;
            case TIMEOUT:
                System.out.println("Game timed out (long computation)");
                break;
            case SUCCESS:
                System.out.println("Game ended successfully");
                break;
            default:
                System.out.println("Unknown game ending state");
                break;
        }
        game.end();
    }

    public static void main(String[] args) {
        Launcher.launch();
    }
}