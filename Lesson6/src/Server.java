import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Ivan Chaykin
 * Date: 15.01.2019
 * Time: 22:18
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket client = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Сервер ожидает подключения");
            client = serverSocket.accept();
            System.out.println("Клиент подключен");
            Scanner scanner = new Scanner(client.getInputStream());
            PrintWriter printWriter = new PrintWriter(client.getOutputStream());

            Thread messageHandler = new Thread(new ServerMessageHandler(printWriter));
            messageHandler.start();

            while (true) {
                String message = scanner.nextLine();
                if ("end".equalsIgnoreCase(message)) {
                    break;
                }
                printWriter.println("Client: " + message);
                System.out.println("Client: " + message);
                printWriter.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ServerMessageHandler implements Runnable {

        PrintWriter printWriter;

        public ServerMessageHandler(PrintWriter printWriter) {
            this.printWriter = printWriter;
        }
        Scanner sc = new Scanner(System.in);
        public void run() {
            String serverMessage;
            try {
                while (true) {
                    serverMessage = sc.nextLine();
                    if ("end".equalsIgnoreCase(serverMessage)) {
                        break;
                    }
                    printWriter.println("Server: " + serverMessage);
                    printWriter.flush();
                }
            } catch(Exception e) { e.printStackTrace(); }
        }
    }

}
