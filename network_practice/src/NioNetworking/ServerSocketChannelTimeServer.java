package NioNetworking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class ServerSocketChannelTimeServer {
    public static void main(String[] args) {
        // print greeting
        System.out.println("NIO time Server has started ʕ•́ᴥ•̀ʔっ");
        // use try except for enter Socket channel
        try {
            // make chanel socket
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            // in c language <bind> will use for sign up to network
            serverSocketChannel.socket().bind(new InetSocketAddress(20000));

            // listening
            while (true) {
                System.out.println("Waiting for message request");

                // accept
                SocketChannel socketChannel = serverSocketChannel.accept();
                // connection is successful
                // if (socketChannel != null) {
                    String dateAndTimeMessage = "Date: " + new Date(System.currentTimeMillis());

                    // get bytes
                    // 64 bytes enough for most messages
                    ByteBuffer buf = ByteBuffer.allocate(64);
                    buf.put(dateAndTimeMessage.getBytes());
                    // flip the position to 0 -> when while loop ends
                    buf.flip();
                    while (buf.hasRemaining()) {
                        socketChannel.write(buf);
                    }
                    System.out.println("Sent: " + dateAndTimeMessage);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}