package ex2;

public class Counter {

    private static Counter counter;

    private int value = 0;

    public void count() {
        value++;
    }

    public void times2() {
        value = value * 2;
    }

    public void zero() {
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public static Counter getInstance() {
        if (counter == null)
            counter = new Counter();
        return counter;
    }

}
