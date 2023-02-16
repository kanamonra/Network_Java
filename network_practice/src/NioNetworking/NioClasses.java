package NioNetworking;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class NioClasses {
    public static void main(String[] args) {
        System.out.println("[7바이트 크기로 버퍼 생성]");
        ByteBuffer buffer = ByteBuffer.allocateDirect(7);
        printState(buffer);

        buffer.put((byte)10); // 1, 7, 7
        buffer.put((byte)11); // 2, 7, 7
        System.out.println("[after 2 byte entered]");
        printState(buffer);

        buffer.put((byte)12);
        buffer.put((byte)13);
        buffer.put((byte)14);
        System.out.println("[after 3 byte entered");
        printState(buffer); // 5, 7, 7

        // flip for send the data
        buffer.flip();
        System.out.println("[after flip()]");
        printState(buffer); // 0, 5, 7

        buffer.get(new byte[3]);
        System.out.println("[after 3 byte add]");
        printState(buffer); // 3, 5, 7

        buffer.mark(); // 0, 5, 7 (mark=3)
        System.out.println("--------[mark -> position // -1 -> 3]");

        buffer.get(new byte[2]);
        System.out.println("[After 2 byte]");
        printState(buffer); // 5, 5, 7

        buffer.reset(); // 3, 5, 7
        System.out.println("--------[position -> mark]");
        printState(buffer);

        buffer.rewind(); // 0, 5, 7
        System.out.println("[after rewind()]");
        printState(buffer);

        buffer.clear(); // 0, 7, 7
        System.out.println("[after clear()]");
        printState(buffer);
    }
    public static void printState(Buffer buffer){
        System.out.print("\tposition:" + buffer.position() + ", ");
        System.out.print("\tlimit:" + buffer.limit() + ", ");
        System.out.println("\tcapacity:" + buffer.capacity());

    }
}

