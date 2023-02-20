package Day25;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class HelperMethods {
    public static void sendMessage(SocketChannel socketChannel, String message) {
        try {
            // size defining of receiving
            ByteBuffer buffer = ByteBuffer.allocate(message.length() + 1);
            buffer.put(message.getBytes());
            buffer.put((byte) 0x00);  // making null to end the sentence
            buffer.flip();
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            } // sending it loop
            System.out.println("Sent: " + message);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static String receiveMessage(SocketChannel socketChannel) {
        try {
            // capacity of receive message(byte) -> choose the memory for each situation
            // choose fast quality or memory safe -> higher fast/lower memory safe
            ByteBuffer byteBuffer = ByteBuffer.allocate(16);
            StringBuilder message = new StringBuilder();
            while (socketChannel.read(byteBuffer) > 0) {
                char byteRead = 0x00;
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    byteRead = (char) byteBuffer.get();
                    if (byteRead == 0x00) {
                        break;
                    }
                    message.append(byteRead);
                }
                // for check debug -> System.out.println(message);
                // for check byte position -> System.out.println(byteBuffer);
                if (byteRead == 0x00) {
                    break;
                }
                byteBuffer.clear();
            }
            return message.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}