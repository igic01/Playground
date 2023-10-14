import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

class Game extends Scene {
    static Label l = new Label("Game");
    static private final int NUM_ROWS = 20;
    static private final int NUM_COLS = 30;
    static private final int CELL_SIZE = 20;

    static Canvas canvas = new Canvas(NUM_COLS * CELL_SIZE, NUM_ROWS * CELL_SIZE);
    static GraphicsContext gc = canvas.getGraphicsContext2D();
    static Group root = new Group(canvas);
    static Button b_leave = new Button("Leave");


    public Game(String username, LobbyScreen gui) {
        super(new HBox(root, b_leave), 800, 400);

        gc.setFill(Color.BLACK);
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                gc.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        b_leave.setOnAction(e->{
            gui.close();
            LobbyScreen lobby_screen = new LobbyScreen(username);
            lobby_screen.show();
        });
    }
}
