package talk19u;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectionThread extends Thread {

    private Socket socket;

    public ConnectionThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String messageFromClient = inFromClient.readLine();
                System.out.println("Message: " + messageFromClient);
                if (ServerWithThreads.NAVNE_SERVER.containsKey(messageFromClient))
                    outToClient.writeBytes(ServerWithThreads.NAVNE_SERVER.get(messageFromClient) + '\n');
                if (messageFromClient.length() >= 5 && messageFromClient.substring(0, 5).equals("NAME:")) {
                    String navn = messageFromClient.split(" ")[1];
                    String ip = messageFromClient.split(" ")[2];
                    ServerWithThreads.NAVNE_SERVER.put(navn, ip);
                    System.out.println("Added to NAME_SERVER: " + navn + " " + ip);
                    outToClient.writeBytes("Added to NAME_SERVER: " + navn + " " + ip + '\n');
                } else if (messageFromClient.equals(":exit"))
                    socket.close();
                else
                    outToClient.writeBytes("Message was received" + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}