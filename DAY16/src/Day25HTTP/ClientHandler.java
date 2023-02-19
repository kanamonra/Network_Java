package Day25HTTP;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class ClientHandler implements Runnable {

    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("\nClientHandler Started for " + this.socket);
        handleRequest(this.socket);
        System.out.println("ClientHandler Terminated for " + this.socket + "\n");
    }

    public void handleRequest(Socket socket) {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()))) {
            String headerLine = in.readLine();
            StringTokenizer tokenizer = new StringTokenizer(headerLine);
            String httpMethod = tokenizer.nextToken();

            if (httpMethod.equals("GET")) {
                System.out.println("Get method processed");
                String httpQueryString = tokenizer.nextToken();
                StringBuilder responseBuffer = new StringBuilder();
                responseBuffer
                        .append("<html><h1>Product Management Home Page</h1><br> <b>Welcome to product management server! ♡(｡ ❛ᴗ❛ ｡)♡</b><BR>" +
                                "-----------------------------------------------------------------------------------------------------------</h1>" +
                                "Product №         Name                                                    Price                      Stock"+
                                "-----------------------------------------------------------------------------------------------------------</h1>");


                sendResponse(socket, 200, responseBuffer.toString());
            } else {
                System.out.println("Umm... I don't understand your command ₍ᐢ. _ .ᐢ₎ ");
                sendResponse(socket, 405, "Method is not Allowed ₍ᐢ. _ .ᐢ₎");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendResponse(Socket socket, int statusCode, String responseString) {
        String statusLine;
        String serverHeader = "Server: WebServer\r\n";
        String contentTypeHeader = "Content-Type: text/html\r\n";

        try (DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            if (statusCode == 200) {
                statusLine = "HTTP/1.0 200 OK" + "\r\n";
                String contentLengthHeader = "Content-Length: " + responseString.length() + "\r\n";

                out.writeBytes(statusLine);
                out.writeBytes(serverHeader);
                out.writeBytes(contentTypeHeader);
                out.writeBytes(contentLengthHeader);
                out.writeBytes("\r\n");
                out.writeBytes(responseString);
            } else if (statusCode == 405) {
                statusLine = "HTTP/1.0 405 Method Not Allowed ₍ᐢ. _ .ᐢ₎" + "\r\n";
                out.writeBytes(statusLine);
                out.writeBytes("\r\n");
            } else {
                statusLine = "HTTP/1.0 404 Not Found ₍ᐢ. _ .ᐢ₎" + "\r\n";
                out.writeBytes(statusLine);
                out.writeBytes("\r\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}