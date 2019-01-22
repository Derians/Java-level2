package client;

import java.io.*;
import java.net.Socket;
import java.text.MessageFormat;

/**
 * @author Admin
 * Date: 17.01.2019
 */
public class ChatClient implements Runnable {

    private Socket socket;
    private String clientName;

    private BufferedReader socketReader;
    private BufferedWriter socketWriter;

    private PrintStream outPrintStream;

    public ChatClient(String host, int port, String clientName) {
        try {
            this.clientName = clientName;
            socket = new Socket(host, port);
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            sendMessage("/r " + clientName);
        } catch (IOException e) {
            System.err.println(MessageFormat.format(
                    "Проблема с подключением к сокету: {0}:{1}", host, port));
        }
    }


    @Override
    public void run() {
        try{
            while (true) {
                String message = socketReader.readLine();
                outPrintStream.println(message);
            }
        } catch (IOException e) {
            System.err.println("Ошибка на клиенте: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try{
            socketWriter.write(message + "\n");
            socketWriter.flush();
        } catch (IOException e) {
            System.err.println("Ошибка при отправке сообщения: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public PrintStream getOutPrintStream() {
        return outPrintStream;
    }

    public void setOutPrintStream(PrintStream outPrintStream) {
        this.outPrintStream = outPrintStream;
    }

    public Socket getSocket() {
        return socket;
    }
}
