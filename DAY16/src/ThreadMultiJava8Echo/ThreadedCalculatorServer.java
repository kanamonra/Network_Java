package ThreadMultiJava8Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedCalculatorServer implements Runnable {
    private static Socket clientSocket;

    public ThreadedCalculatorServer(Socket clientSocket) {
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
                ThreadedCalculatorServer tes = new ThreadedCalculatorServer(clientSocket);
                eService.submit(tes);
            }
        } catch (IOException e) {
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
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(clientSocket.getRemoteSocketAddress().toString() + " " + Thread.currentThread() + " 클라이언트가 보낸 메세지 : " + line);
                try {
                    StringTokenizer st = new StringTokenizer(line, "+-*/", true);
                    int result = 0, operand;
                    char operator = '+';

                    while (st.hasMoreTokens()) {
                        String token = st.nextToken().trim();

                        // if ("+-*/".indexOf(token) >= 0) {
                        if ("+-*/".contains(token)) {
                            operator = token.charAt(0);
                        } else {
                            operand = Integer.parseInt(token);

                            switch (operator) {
                                case '+' -> result = result + operand;
                                case '-' -> result = result - operand;
                                case '*' -> result = result * operand;
                                case '/' -> result = result / operand;
                            }
                        }
                    }
                    pw.println(line + "=" + result);
                } catch (NumberFormatException err) {
                    pw.println("Error with input. Please use calculator token with only NUMBERS.");
                }
            }
            System.out.println(Thread.currentThread() + " ended");
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
}


