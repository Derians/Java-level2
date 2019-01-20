package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Admin
 * Date: 17.01.2019
 */
public class ChatServer implements Runnable{

    private ServerSocket serverSocket;
    private List<ChatServerClient> clients = new ArrayList<>();
    private Map<ChatServerClient, String> clientMap = new HashMap<>();

    public ChatServer(int port) {
        try{
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Проблемы с портом: " + port);
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try{
                ChatServerClient client = new ChatServerClient(serverSocket.accept(), this);
                clients.add(client);
                new Thread(client).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sendMessageForAll(ChatServerClient chatServerClient, String message) {
        for (Map.Entry<ChatServerClient, String> clientEntry : clientMap.entrySet()) {
            clientEntry.getKey().sendMessage(clientMap.get(chatServerClient) + ": " + message);
        }
    }

    public synchronized void sendPrivateMessage(ChatServerClient chatServerClient, String name, String message) {
        for (Map.Entry<ChatServerClient, String> chatServerClientStringEntry : clientMap.entrySet()) {
            if (chatServerClientStringEntry.getValue().equals(name)) {
                chatServerClientStringEntry.getKey().sendMessage(clientMap.get(chatServerClient) + ": " + message);
                System.out.println("Send private msg to " + chatServerClientStringEntry.getValue());
            }
        }
    }

    public void subscribe (ChatServerClient client, String name){
        clientMap.put(client, name);
        System.out.println("Client " + name + " registered.");
    }

    public void unsubscribe (ChatServerClient client){
        clientMap.remove(client);
        System.out.println("Client " + clientMap.get(client) + " unregistered.");
    }
}
