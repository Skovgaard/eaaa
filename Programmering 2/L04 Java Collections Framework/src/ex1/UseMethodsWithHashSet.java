package ex1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UseMethodsWithHashSet {

    public static void main(String[] args) {

        //ex1
        Set<Integer> set = new HashSet<>(Arrays.asList(34, 12, 23, 45, 67, 34, 98));
        System.out.println("ex1:");
        System.out.println(set);
        set.add(23);
        System.out.println(set);
        set.remove(67);
        System.out.println(set);
        System.out.println("Set contains 23: " + set.contains(23));
        System.out.println("Set size: " + set.size());
    }
}
