package ex2student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex2 {

    public static void main(String[] args) {
        List<Runner> runners = new ArrayList<>();
        runners.addAll(Arrays.asList(
                new Runner("Ib", 30),
                new Runner("Per", 50),
                new Runner("Ole", 27),
                new Runner("Ulla", 40),
                new Runner("Jens", 35),
                new Runner("Hans", 28)));
        System.out.println(runners);
        System.out.println();

        System.out.println("Ex2");
        System.out.println("a)");
        runners.forEach(r -> System.out.println(r.toString()));
        System.out.println();

        System.out.println("b)");
//        runners.forEach(r -> System.out.print(r.getLapTime() < 30 ? r.toString() + "\n" : ""));
        runners.forEach(r -> {
            if (r.getLapTime() < 30) System.out.println(r.toString());
        });
        System.out.println();

        System.out.println("c)");
//        runners.sort((r1, r2) -> Integer.compare(r1.getLapTime(), r2.getLapTime()));
        runners.sort(Comparator.comparingInt(Runner::getLapTime));
        runners.forEach(r -> System.out.println(r.toString()));
        System.out.println();

        System.out.println("d)");
        final int[] sum = {0};
        runners.forEach(r -> sum[0] += r.getLapTime());
        System.out.println("Sum af runners lapTime: " + sum[0]);

    }
}