package ex4student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Ex4 {

    public static void main(String[] args) {

        System.out.println("Ex4");

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

        System.out.println("a)");
        System.out.println("Prøver at remove fra en liste den itererer (kan ikke ændre mens den er i brug)");
        System.out.println();

		/*
		// OBS: Throws exception.
		for (Runner runner : runners) {
			if (runner.getLapTime() > 40)
				runners.remove(runner);
		}
		System.out.println(runners);
		System.out.println();
		*/

        List<Runner> runnersB = new ArrayList<>(runners);

        System.out.println("b)");
        Iterator<Runner> runnerIterator = runnersB.iterator();
        while (runnerIterator.hasNext()) {
            if (runnerIterator.next().getLapTime() >= 40)
                runnerIterator.remove();
        }
        System.out.println(runnersB);
        System.out.println();

        System.out.println("c) og d)");

        List<Runner> runnersD = new ArrayList<>(runners);
        removeIf(runnersD, r -> r.getLapTime() >= 40);
        System.out.println(runnersD);
        System.out.println("resultat fra b) og c) ens: " + runnersB.equals(runnersD));
        System.out.println();

        System.out.println("e)");

        List<Runner> runnersE = new ArrayList<>(runners);
        runnersE.removeIf(r -> r.getLapTime() >= 40);
        System.out.println(runnersE);
        System.out.println("resultat fra d) og e) ens: " + runnersD.equals(runnersE));
        System.out.println();
    }

    /**
     * Removes runners that satisfies the given filter. * Returns true, if any runner is removed.
     */
    public static boolean removeIf(List<Runner> runners, Predicate<Runner> filter) {
        boolean result = false;
        Iterator<Runner> runnerIterator = runners.iterator();
        while (runnerIterator.hasNext()) {
            if (filter.test(runnerIterator.next())) {
                runnerIterator.remove();
                result = true;
            }
        }
        return result;
    }
}