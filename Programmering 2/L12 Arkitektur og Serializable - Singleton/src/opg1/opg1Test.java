package opg1;

import java.io.*;

public class opg1Test {

    public static void main(String[] args) {

        System.out.println("Opg1:");
        MyTime myTime = new MyTime();
        myTime.increase();
        System.out.println("Time increased");
        myTime.increase();
        System.out.println("Time increased");

        String path = "L12 Arkitektur og Serializable - Singleton/output/myTime.ser";

        myTime.saveTime();
        System.out.println("Time saved: " + myTime.getTime());
        System.out.println("Saving time to file");
        writeToFile(path, myTime);

        System.out.println("Loading time from file");
        myTime = readFromFile(path);
        if (myTime != null) {
            System.out.println("Time after save/load: " + myTime.getTime());
            myTime.reset();
            System.out.println("Time reset");
            myTime.saveTime();
            System.out.println("Time saved: " + myTime.getTime());
        }

        System.out.println("Saving time to file");
        writeToFile(path, myTime);

        System.out.println("Loading time from file");
        myTime = readFromFile(path);
        if (myTime != null) {
            System.out.println("Times saved: " + myTime.getTimes());
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
