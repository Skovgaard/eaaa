package opg10;

import java.io.*;
import java.net.*;

public class TCPClient {

    private static final String IP = "localhost";

    public static void main(String[] argv) throws Exception {
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket(IP, 6789);
//        clientSocket.setTcpNoDelay(true);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');

//        outToServer.writeBytes("HaHa");
//        Thread.sleep(100);
//        outToServer.writeBytes("HeHe");
//        Thread.sleep(100);
//        outToServer.writeBytes("HiHi");
//        Thread.sleep(100);
//        outToServer.writeBytes("HoHo" + '\n');

//        for (int i = 0; i < 100000; i++) {
//            outToServer.writeBytes("HoHoHoHoHoHoHoHoHoHo" + '\n');
//        }
//        System.out.println("Hej");

        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }
}


