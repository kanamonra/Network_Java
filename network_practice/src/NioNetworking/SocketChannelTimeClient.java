package NioNetworking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelTimeClient {
    public static void main(String[] args) {
        SocketAddress address = new InetSocketAddress("127.0.0.1", 20000);
        try (SocketChannel sc = SocketChannel.open(address)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);
            int bytesRead = sc.read(byteBuffer);
            while (bytesRead > 0) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining())
                {
                    System.out.print((char)
                            byteBuffer.get());
                }
                System.out.println();
                bytesRead = sc.read(byteBuffer);
            }

        } catch (IOException e) {
            System.out.println("Error IO exception");
        }
    }
}
