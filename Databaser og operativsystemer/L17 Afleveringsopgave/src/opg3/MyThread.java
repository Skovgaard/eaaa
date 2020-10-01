package opg3;

public class MyThread extends Thread {

    private Faelles x;

    public MyThread(String navn, Faelles x) {
        super(navn);
        this.x = x;
    }

    public void run() {
        for (int j = 0; j < 100; j++) {
            x.kritiskSection();
            x.tagerRandomTid(42);
        }
        System.out.println(x.getGlobalCounter());
    }

}
