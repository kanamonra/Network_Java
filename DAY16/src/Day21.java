import java.io.IOException;
import java.net.*;

public class Day21 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6000)){
            System.out.println("Waiting for connection.....");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client");

        } catch (IOException ex) {
            // Handle exceptions
        }

    }
}
