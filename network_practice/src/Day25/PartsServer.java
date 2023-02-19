package Day25;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

import static java.net.StandardSocketOptions.SO_RCVBUF;

public class PartsServer {
    // server parts -> key value
    private static final HashMap<String,Float> parts = new HashMap<>();

    public PartsServer() {
        System.out.println("Part Server has started");
        initializeParts();
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(5000));
            //
            serverSocketChannel.setOption(SO_RCVBUF, 64);
            boolean running = true;
            while (running) {
                System.out.println("Waiting for client ...");
                // accept the request
                SocketChannel socketChannel = serverSocketChannel.accept();
                // start connect with thread and make connection
                new Thread(new ClientHandler(socketChannel)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeParts() {
        parts.put("Hammer", 12.55f);
        parts.put("Nail", 1.35f);
        parts.put("Pliers", 4.65f);
        parts.put("Saw", 8.45f);
        parts.put("Tsetseg", 3000f);
        parts.put("Yubin", 3000f);
        parts.put("Dabin", 3000f);
    }

    public static Float getPrice(String partName) {
        return parts.get(partName);
    }

    public static void main(String[] args) {
        new PartsServer();
    }
}
