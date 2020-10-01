package opg2;

import java.util.Random;

public class Faelles {

    private int globalCounter = 0;

    public boolean[] flag = {false, false};
    public int turn = 0;

    public void tagerRandomTid(int max) {
        Random random = new Random();
        int nyMax = Math.abs((random.nextInt()) % max + 1);

        for (int i = 0; i < nyMax; i++) {
            for (int j = 0; j < nyMax; j++) {
                int a = 0;
                a = a + 2;
                a = a - 2;
            }
        }
    }

    public int getGlobalCounter() {
        return globalCounter;
    }

    public void kritiskSection() {
        int temp;
        temp = globalCounter;
        tagerRandomTid(42);
        globalCounter = temp + 1;
    }
}
