import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

// check network
// Java network interface -> test for get Inet address, name, display, interface
public class Day23 {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();
            System.out.print("Name         Display name\n");
            for (NetworkInterface element : Collections.list(interfaceEnum)) {
                System.out.printf("%-8s %-32s\n", element.getName(), element.getDisplayName());
            }  // %-8s name display name space
        } catch (SocketException e) {
            System.out.println("Socket exception error");
        }
    }
}
