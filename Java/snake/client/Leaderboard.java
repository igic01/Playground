import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

class Leaderboard extends Scene {
    static Label l = new Label("Leaderboard");

    public Leaderboard() {
       super(new HBox(l), 400, 400); 
    }
}
