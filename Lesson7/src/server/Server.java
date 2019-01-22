package server;

import utils.Properties;

import java.util.Scanner;

/**
 * @author Admin
 * Date: 14.01.2019
 */
public class Server {

    public static void main(String[] args) {
        ChatServer server = new ChatServer(Properties.PORT);
        new Thread(server).start();
        System.out.println("Server started, press q for exit");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if ("q".equalsIgnoreCase(scanner.nextLine())) {
                System.exit(0);
            }
        }
    }
}
