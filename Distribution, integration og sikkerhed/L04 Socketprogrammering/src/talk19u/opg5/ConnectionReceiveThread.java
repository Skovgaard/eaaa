package talk19u.opg5;

import java.io.IOException;
import java.net.*;

public class ConnectionReceiveThread extends Thread {

    private DatagramSocket socket;
    private static final int TIMEOUT = 2000;

    public ConnectionReceiveThread(DatagramSocket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.setSoTimeout(TIMEOUT);
                socket.receive(receivePacket);
                String modifiedSentence = new String(receivePacket.getData());
                int index = modifiedSentence.indexOf("\u0000");
                System.out.println("FROM SERVER: " + modifiedSentence.substring(0, index));
            }
        } catch (SocketTimeoutException e) {
//            e.printStackTrace();
            System.out.println("Timeout of " + TIMEOUT );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
