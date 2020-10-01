package talk19u;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String HOST = "localhost";
//    private static final String HOST = "10.24.5.43";
    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {

        Socket clientSocket = new Socket(HOST, PORT);
        Scanner scanner = new Scanner(System.in);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        String message;

        while (true) {
            message = scanner.nextLine();
            outToServer.writeBytes(message + '\n');
            System.out.println("Message sent: " + message);
            if (message.equals(":exit")) break;
            new ClientReceiveMessage(clientSocket).start();
        }
    }
}
