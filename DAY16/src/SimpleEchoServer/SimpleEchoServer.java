package SimpleEchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SimpleEchoServer {
    public static void main(String[] args) {
        System.out.println("Simple Echo Server");
        try (ServerSocket serverSocket = new ServerSocket(9900)) {
            System.out.println("Waiting for connection.....");
            Socket clientSocket = serverSocket.accept();   // waiting line
            System.out.println("Connected to client");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true))
            {
                Stream
                        .generate(() -> {
                            try {
                                return br.readLine();
                            } catch (IOException ex) {
                                return null;
                            }
                        })
                        .peek(text -> {
                            System.out.println("클라이언트로 부터 받은 메세지 : " + text);
                            out.println(text);
                        })
                        .allMatch(Objects::nonNull);
            }
            catch (IOException e) {
                System.out.println("Error with connection");
                throw new RuntimeException(e);}
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

