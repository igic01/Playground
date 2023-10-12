import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private final int PORT = 7007;
    private LoginScreen gui;
    DataOutputStream output;
    DataInputStream input;

    public Client(String username, String password, LoginScreen gui) {
        try {
            this.socket = new Socket("localhost", PORT);
            this.output = new DataOutputStream(socket.getOutputStream());
            this.input = new DataInputStream(socket.getInputStream());
            this.gui = gui;
            
            // sendig the user credentials to the server
            output.writeUTF(username);
            output.writeUTF(password);
            
            // waiting for server response
            boolean server_response = input.readBoolean();
            
            /*
             * if credentials are invalid
             * user wont be prompted to lobby 
             */
            if (!server_response) {
                gui.l_info.setText("Incorrect credentials");
                gui.tf_username.setText("");
                gui.tf_password.setText("");
                return;
            }
            
            /*
             * credentials valid 
             * user is prmented to lobby
             */
            start_lobby(username);

        } catch (Exception e) {
            System.out.println("Error with logging in ");
        }
    }

    /*
     * 
     */
    void start_lobby(String username) {
        LobbyScreen lobby_screen = new LobbyScreen(username);
        lobby_screen.show();
        gui.close();
    }
}
