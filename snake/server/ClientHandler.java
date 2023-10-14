import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
    private Socket socket;
    private DataOutputStream output;
    private BufferedReader read;
    private BufferedWriter write;
    private String database_name = "database.csv";

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error with creating ClientHandler");
        }
    }

    public void run() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            
            while (true) {
                String username = input.readUTF();
                String password = input.readUTF();
                output.writeBoolean(check_credentials(username, password));
            }
        } catch (Exception e) {
            System.out.println("Error with client handler listening!");
        }
    }

    boolean check_credentials(String username, String password) {
        try {
            read = new BufferedReader(new FileReader(database_name));
        } catch (IOException e) {
            System.out.println("Error with creating ClientHandler");
        }
        /*
         * reads throuhg our database 
         * checks if there is a user with specific username
         * if there is, we just need to check his password
         * if password is correct it is our user 
         * if password is not correct we already know that usrname is taken
         */
        String line;
        try {
            while ((line = read.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length > 0 && row[0].equals(username)) {
                    System.out.println(row[1]);
                    if (row[1].equals(password)) {
                        read.close();
                        return true;
                    }
                    read.close();
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println("Error with readign database!");
        }

        /*
         * we did not find any users with specific username
         * than we create a new user with this info
         */
        try {
            write = new BufferedWriter(new FileWriter(database_name, true));
            write.append(username + ","+ password);
            write.newLine();
            write.close();
        } catch (IOException e) {
            System.out.println("Error with adding a new user!");
        }
        return true;
    }
}
