package opg2;

public class Main {

    public static void main(String[] args) {

        Faelles faelles = new Faelles();

        MyThread myThread1 = new MyThread(0, "Tråd 1", faelles);
        MyThread myThread2 = new MyThread(1, "Tråd 2", faelles);

        myThread1.start();
        myThread2.start();

    }
}
