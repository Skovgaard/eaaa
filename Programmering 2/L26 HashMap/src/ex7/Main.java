package ex7;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Bil> set = new HashSet<>();
        set.add(new Bil("1", "BMW", "M3", "Blå"));
        set.add(new Bil("1", "BMW", "M3", "Blå"));
        set.add(new Bil("2", "BMW", "M4", "Sort"));
        set.add(new Bil("2", "BMW", "M4", "Sort"));
        set.add(new Bil("3", "BMW", "M5", "Hvid"));
        set.add(new Bil("3", "BMW", "M5", "Hvid"));

        System.out.println(set);

        System.out.println("Uden hashcode og equals: Alle 6 bliver tilføjet (doublicates)");
        System.out.println("Uden hashcode: Samme - og ordenen bliver flyttet rundt");
        System.out.println("Uden equals: Samme - alle 6");

    }
}
