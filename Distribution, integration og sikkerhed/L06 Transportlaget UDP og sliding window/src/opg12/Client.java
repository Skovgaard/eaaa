package opg12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    private static final int PORT = 12345;
    private static ArrayList<Person> personer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("10.24.68.154", PORT);
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        modtagPersoner(personer, inFromServer);
        clientSocket.close();
    }

    public static void modtagPersoner(ArrayList<Person> personer, BufferedReader instream) throws IOException {
        String[] personString = instream.readLine().split(",");
        for (int i = 0; i < personString.length; i += 3) {
            int id = Integer.parseInt(personString[i]);
            String navn = personString[i + 1];
            String by = personString[i + 2];
            personer.add(new Person(id, navn, by));
        }
        System.out.println(personer.toString());
    }
}
