import java.net.*;

class Server{
    private static final int port = 7007;
    private static ServerSocket server_socket;

    public static void main(String[] args) {
        try {
            server_socket = new ServerSocket(port);
        } catch (Exception e) {
            System.out.println("Error with starting server: " + e.getMessage());
        }
        running();
    }

    static void running(){
        try {
            System.out.println("Server started!");
            while (true) {
                Socket client_socket = server_socket.accept();
                ClientHandler client_handler = new ClientHandler(client_socket);
                client_handler.start();
            }    
        } catch (Exception e) {
        }
    }
}