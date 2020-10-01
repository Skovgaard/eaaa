package talk19u.opg5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPServer {

    private final static String MY_HOST = "10.24.66.14";
    private final static int PORT = 12345;

    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(PORT);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            int index = sentence.indexOf("\u0000");
            System.out.println("RECEIVED: " + sentence.substring(0, index));
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = "My ip is: " + MY_HOST;
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
