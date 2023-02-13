import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SimpleEchoServer {
    public static void main(String[] args) {
        try {
            System.out.println("Waiting for connection.....");
            // InetAddress localAddress = InetAddress.getLocalHost();
            try (Socket clientSocket = new Socket("165.246.115.165", 9900);
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("Connected to server");
                    Scanner sc = new Scanner(System.in);
                while (true)
                {
                    System.out.print("Enter text: ");
                    String inputLine = sc.nextLine();
                    if ("exit".equalsIgnoreCase(inputLine)) {
                        break;  // exit condition
                    }
                    out.println(inputLine);  // to server
                    String response = br.readLine();  // from server give back line to host
                    System.out.println("Server response: " + response);
                }
            }
        } catch (IOException ex) {
            // Handle exceptions
        }

    }
}
