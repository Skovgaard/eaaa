package opg2;

public class MyThread extends Thread {

    private Faelles x;

    private int id;

    public MyThread(int id, String navn, Faelles x) {
        super(navn);
        this.id = id;
        this.x = x;
    }

    public void run() {
        for (int j = 0; j < 100; j++) {

            // Petersons algorithm:
            x.flag[id] = true;
            int otherId = id == 0 ? 1 : 0;
            x.turn = otherId;

            while (x.flag[otherId] && x.turn == otherId) {
                // busy wait
            }

            // Kritisk section
            x.kritiskSection();

            x.flag[id] = false;

            // end

            x.tagerRandomTid(42);
        }
        System.out.println(x.getGlobalCounter());
    }

}
