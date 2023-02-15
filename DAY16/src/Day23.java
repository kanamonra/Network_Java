import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

// check network address
// Java network interface -> test for get Inet address, name, display, interface
public class Day23 {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();
            System.out.printf("Name Display name\n");
            for (NetworkInterface element : Collections.list(interfaceEnum)) {
                System.out.printf("%-8s %-32s\n", element.getName(), element.getDisplayName());
                Enumeration<InetAddress> addresses = element.getInetAddresses();
                for (InetAddress inetAddress : Collections.list(addresses)) {
                    System.out.printf("InetAddress: %s\n", inetAddress);
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}