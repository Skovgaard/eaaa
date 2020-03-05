package opg1;

import java.io.*;

public class opg1Test {

    public static void main(String[] args) {

        MyTime myTime = new MyTime();
        myTime.increase();
        myTime.increase();
        System.out.println(myTime.getTime());

        String path = "L12 Arkitektur og Serializable - Singleton/output/myTime.ser";

        writeToFile(path, myTime);

        MyTime myTime2 = readFromFile(path);
        if (myTime2 != null) {
            System.out.println(myTime2.getTime());
        }

    }

    public static void writeToFile(String path, MyTime myTime) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(myTime);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MyTime readFromFile(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Object object = objectInputStream.readObject();
            if (object instanceof MyTime)
                return (MyTime) object;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
