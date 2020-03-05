package ex2;

public class ex2Test {

    public static void main(String[] args) {

        Counter counter1 = Counter.getInstance();
        Counter counter2 = Counter.getInstance();

        System.out.println("Ex2:");
        counter1.count();
        System.out.println("counter1.count: " + counter1.getValue());
        counter2.count();
        System.out.println("counter2.count: " + counter2.getValue());
        counter1.times2();
        System.out.println("counter1.times2: " + counter1.getValue());
        counter2.zero();
        System.out.println("counter2.zero: " + counter2.getValue());
        System.out.println("counter1 == counter2: " + (counter1 == counter2));
    }
}
