import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class LobbyScreen extends Stage {
    // user credentials
    private String username;

    // components
    GridPane grid = new GridPane();
    Label l_username = new Label();
    Button b_play = new Button("Play");
    Button b_leader_board = new Button("Leaderboard");
    HBox hbox = new HBox(b_play, b_leader_board);
    

    public LobbyScreen(String username) {
        this.username = username;

        // style
        l_username.setText("Welcome " + this.username);
        l_username.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));

        // functionality
        b_play.setOnAction(e -> {
            this.setScene(new Game(this.username, this));
            this.show();
        });

        b_leader_board.setOnAction(e -> {
            this.setScene(new Leaderboard());
            this.show();
        });

        // layout
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(l_username, 0, 0);
        grid.add(hbox, 0, 1);

        // seting a scene
        Scene scene = new Scene(grid, 800, 400);
        setScene(scene);
        setTitle("Game");
    }

    String get_username(){
        return this.username;
    }
}