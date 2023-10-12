import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class LoginScreen extends Stage {
    GridPane grid = new GridPane();

    Label t_title = new Label("Welcome");

    Label l_username = new Label("Username:");
    TextField tf_username = new TextField();

    Label l_password = new Label("Password:");
    TextField tf_password = new TextField();

    Label l_info = new Label();
    Button b_login = new Button("Login");

    public LoginScreen() {
        // styling layout
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // styling elements
        t_title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 44));
        l_username.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 16));
        l_password.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 16));
        l_info.setTextFill(Color.RED);

        // functionality
        tf_username.setOnAction(e-> b_login.fire());
        tf_password.setOnAction(e-> b_login.fire());
        b_login.setPrefWidth(200);
        b_login.setOnAction(e -> login(tf_username.getText(), tf_password.getText()));

        // setting layout
        grid.add(t_title, 0, 0);
        grid.add(l_username, 0, 1);
        grid.add(tf_username, 0, 2);
        grid.add(l_password, 0, 3);
        grid.add(tf_password, 0, 4);
        grid.add(l_info, 0, 5);
        grid.add(b_login, 0, 6);

        // setting the scene
        Scene scene = new Scene(grid, 600, 600);
        this.setScene(scene);
        this.setTitle("Login");
    }

    /*
     * when the user press button login
     * user tries to connect to the server
     * check if his/her credentials are correct
     */
    void login(String username, String password) {
        new Client(username, password, this);
    }
}
