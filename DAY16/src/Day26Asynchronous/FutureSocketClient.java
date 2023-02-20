package Day26Asynchronous;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Future;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class FutureSocketClient {
    public static void main(String[] args) {
        System.out.println("Asynchronous Client Started");
        try (AsynchronousSocketChannel client = AsynchronousSocketChannel.open()) {
            InetSocketAddress hostAddress = new InetSocketAddress("127.0.0.1", 5000);
            Future<Void> future = client.connect(hostAddress);
            future.get(); // Blocks until connection made

            System.out.println("Client is started: " + client.isOpen());
            System.out.println("Sending messages to server: ");

            Scanner scanner = new Scanner(System.in);
            String message;
            while (true) {
                System.out.print("> ");
                message = scanner.nextLine();
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                Future<Integer> result = client.write(buffer);
                while (!result.isDone()) {
                    // Wait
                }
                if (message.equalsIgnoreCase("quit")) {
                    break;
                }
            }
        } catch (IOException | InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}
