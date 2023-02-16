package ThreadMultiJava8Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedEchoServer implements Runnable
{   private static Socket clientSocket;

    public ThreadedEchoServer(Socket clientSocket)
    {
        ThreadedEchoServer.clientSocket = clientSocket;
    }

    public static void main(String[] args) {
        ExecutorService eService = Executors.newFixedThreadPool(2);
        System.out.println("Threaded Echo Server");
        try (ServerSocket serverSocket = new ServerSocket(20000)) {
            while (true) {
                System.out.println("Waiting for connection.....");

                // connected socket
                clientSocket = serverSocket.accept();
                // connected socket
                ThreadedEchoServer tes = new ThreadedEchoServer(clientSocket);
                eService.submit(tes);
            }
        }  catch (IOException e) {
            throw new RuntimeException(e);
            }

    }

    @Override
    public void run() {
        System.out.println("Connected to client using [" + Thread.currentThread() + "]");
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                // clientSocket.get---.toString <for change the computer code to numbers>
                System.out.println(clientSocket.getRemoteSocketAddress().toString() + "Client request [" + Thread.currentThread() + "]: " + inputLine);
                pw.println(inputLine);
            }
            System.out.println("Client [" + Thread.currentThread() + " connection terminated");
        } catch (IOException ignored) {
        }

    }
}

