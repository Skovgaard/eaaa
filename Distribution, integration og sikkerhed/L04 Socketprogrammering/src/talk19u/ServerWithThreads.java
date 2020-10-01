package talk19u;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerWithThreads {

    private static final int PORT = 12345;

    public static final Map<String, String> NAVNE_SERVER = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(PORT);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("New connection from: " + connectionSocket.getInetAddress());
            new ConnectionThread(connectionSocket).start();
        }
    }
}
