package opg12;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private static final int PORT = 12345;
    private static ArrayList<Person> personer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        fillArraylist();

        ServerSocket welcomeSocket = new ServerSocket(PORT);
        Socket connectionSocket = welcomeSocket.accept();
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        System.out.println("New connection from: " + connectionSocket.getInetAddress());
        sendPersoner(personer, outToClient);
        connectionSocket.close();
    }

    public static void sendPersoner(ArrayList<Person> personer, DataOutputStream outstream) throws IOException {
        StringBuilder personsString = new StringBuilder();
        String splitter = ",";
        for (Person p : personer) {
            personsString.append(p.getId()).append(splitter).append(p.getNavn()).append(splitter).append(p.getBy()).append(splitter);
        }
        outstream.writeBytes(personsString.toString() + '\n');
    }

    public static void fillArraylist() {
        personer.add(new Person(0, "Kasper", "Aarhus"));
        personer.add(new Person(1, "Alexander", "Aarhus"));
        personer.add(new Person(2, "Mathias", "Aarhus"));
        personer.add(new Person(3, "Mariana", "Aarhus"));
    }

}
