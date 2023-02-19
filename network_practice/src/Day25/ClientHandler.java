package Day25;

import java.nio.channels.SocketChannel;

public class ClientHandler implements Runnable{

    private final SocketChannel socketChannel;
    // constructor pf socket channel
    public ClientHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        System.out.println("ClientHandler Started for " + this.socketChannel);
        String partName;
        while (true) {
            partName = HelperMethods.receiveMessage(socketChannel);
            if (partName.equalsIgnoreCase("quit")) {
                break;
            } else {
                Float price = PartsServer.getPrice(partName);
                HelperMethods.sendMessage(socketChannel, price.toString());
            }
        }
        System.out.println("ClientHandler Terminated for IP: " + this.socketChannel);
    }
}
