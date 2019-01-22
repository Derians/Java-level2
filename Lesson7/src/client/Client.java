package client;

import utils.Properties;

/**
 * @author Admin
 * Date: 14.01.2019
 */
public class Client {

    public static void main(String[] args) {
        String clientName = "client_1";
        ChatClient client = new ChatClient(Properties.HOST, Properties.PORT, clientName);
        client.setOutPrintStream(System.out);
        new Thread(client).start();
        new ClientWindow(clientName, client);
    }
}
