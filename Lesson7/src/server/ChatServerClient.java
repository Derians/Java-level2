package server;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Admin
 * Date: 17.01.2019
 */
public class ChatServerClient implements Runnable {

    private BufferedReader socketReader;
    private BufferedWriter socektWriter;
    private ChatServer server;

    public ChatServerClient(Socket socket, ChatServer serverSocket) throws IOException {
        this.server = serverSocket;
        socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        socektWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void run() {
        try {
            final String regex = "(^/\\w) (.*)";
            while (true) {
                String message = socketReader.readLine();
               if (message.matches(regex)) {
                   String[] arrOfStr = message.split(" ");
                   if (arrOfStr[0].equals("/r")) {
                       server.subscribe(this, arrOfStr[1]);
                   }
                   if (arrOfStr[0].equals("/u")) {
                       server.unsubscribe(this);
                   }
                   if (arrOfStr[0].equals("/w")) {
                       String newMessage = message.replace("/w " + arrOfStr[1], "");
                       server.sendPrivateMessage(this, arrOfStr[1], newMessage);
                   }
               } else {
                   server.sendMessageForAll(this, message);
               }
            }
        } catch (IOException ioe) {
            System.err.println("Server error: " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            socektWriter.write(message + "\n");
            socektWriter.flush();
        } catch (IOException ioe) {
            System.err.println("Server error: " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
