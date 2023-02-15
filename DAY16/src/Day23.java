import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

// Getting multiple Mac address

public class Day23 {
    public static String getMacIdentifier(NetworkInterface network){
        StringBuilder identifier = new StringBuilder();
        try {
            byte[] macBuffer = network.getHardwareAddress();
            if (macBuffer != null) {
                for (int i = 0; i < macBuffer.length; i++) {identifier.append(String.format("%02X%s",macBuffer[i], (i < macBuffer.length - 1) ? "-" : ""));
                }
            } else {
                return "---";
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return identifier.toString();
    }

    public static void main(String[] args) {
        InetAddress addr;
        try {
            addr = InetAddress.getLocalHost();
            System.out.println("IP address: " + addr.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(addr);
            System.out.println("Mac address: " + getMacIdentifier(network));
        } catch (UnknownHostException | SocketException e) {
            throw new RuntimeException(e);
        }
    }
}