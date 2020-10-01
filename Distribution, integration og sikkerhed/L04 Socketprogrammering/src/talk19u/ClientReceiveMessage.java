package talk19u;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiveMessage extends Thread {

    private Socket clientSocket;

    public ClientReceiveMessage(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String messageFromServer = inFromServer.readLine();
            System.out.println("Message received: " + messageFromServer);
            if (messageFromServer.equals(":exit"))
                clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
