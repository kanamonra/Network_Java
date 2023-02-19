package Day25Assignment;

import java.io.*;
import java.net.Socket;
import java.net.InetAddress;
import java.util.Scanner;

public class HTTPClient {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Scanner sc;
    public void startServer() throws IOException{
        socket = new Socket("localhost", 10000);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("Successfully connected with server! ");
        sc = new Scanner(System.in);

    }
    // public HTTPClient() {
    //    System.out.println("HTTP Client Started");
    //    try {
    //        InetAddress serverInetAddress = InetAddress.getByName("127.0.0.1");
    //        Socket connection = new Socket(serverInetAddress, 10000);
//
    //        try (OutputStream out = connection.getOutputStream();
    //             BufferedReader in = new BufferedReader(
    //                     new InputStreamReader(connection.getInputStream()))) {
    //            sendGet(out);
    //            System.out.println(getResponse(in));
    //        }
    //    } catch (IOException ex) {
    //        ex.printStackTrace();
    //    }
    //}

    // need add, delete, update, exit function in it

}
