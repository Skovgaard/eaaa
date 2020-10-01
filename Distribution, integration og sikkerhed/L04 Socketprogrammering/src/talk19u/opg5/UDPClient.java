package talk19u.opg5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPClient {

    private final static String HOST = "localhost";
    private final static String BROADCAST_HOST = "255.255.255.255";
    private final static int PORT = 12345;

    public static void main(String[] args) throws Exception {
//        sendBesked();
        udsendBroadcast("Test broadcast");
    }

    public static void sendBesked() throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName(HOST);
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, PORT);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }

    public static void udsendBroadcast(String tekstbesked) throws IOException, InterruptedException {
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.setBroadcast(true);
        InetAddress IPAddress = InetAddress.getByName(BROADCAST_HOST);
        byte[] sendData = new byte[1024];
        sendData = tekstbesked.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, PORT);
        for (int i = 0; i < 3; i++) {
            clientSocket.send(sendPacket);
            new ConnectionReceiveThread(clientSocket).start();
            Thread.sleep(1000);
        }
    }
}

