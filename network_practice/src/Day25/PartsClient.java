package Day25;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class PartsClient {
    public PartsClient() {
        System.out.println("PartsClient has started");
        SocketAddress address = new InetSocketAddress("192.168.219.129", 5000);
        // start connection
        try (SocketChannel socketChannel = SocketChannel.open(address)) {
            System.out.println("Connected to Parts Server");
            // take input
            Scanner scanner = new Scanner(System.in);
            while (true) {
                // Get part name
                System.out.print("[상품 목록]");
                String partName = scanner.nextLine();
                if (partName.equalsIgnoreCase("quit")) {
                    HelperMethods.sendMessage(socketChannel, "quit");
                    break;
                } else {
                    HelperMethods.sendMessage(socketChannel, partName);
                    System.out.println("The price is " + HelperMethods.receiveMessage(socketChannel));
                }
            }
            System.out.println("PartsClient has terminated");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PartsClient();
    }
}