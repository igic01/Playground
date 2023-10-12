import javafx.application.Application;
import javafx.stage.Stage;

public class ClientApp extends Application{

    @Override
    public void start(Stage arg0) throws Exception {
        LoginScreen login_screen  = new LoginScreen();
        login_screen.show();   
    }

    public static void main(String[] args) {
        launch(args);
    }
}
