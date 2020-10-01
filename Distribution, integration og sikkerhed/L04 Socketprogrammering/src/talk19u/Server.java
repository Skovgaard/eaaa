package talk19u;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(PORT);
        Socket connectionSocket = welcomeSocket.accept();
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        System.out.println("New connection from: " + connectionSocket.getInetAddress());
        while (true) {
            String messageFromClient = inFromClient.readLine();
            System.out.println("Message: " + messageFromClient);
            if (messageFromClient.equals(":exit"))
                connectionSocket.close();
            outToClient.writeBytes("Message was received" + '\n');
        }
    }
}
