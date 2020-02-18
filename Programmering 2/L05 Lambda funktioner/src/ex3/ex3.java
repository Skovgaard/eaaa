package ex3;

import java.util.*;

public class ex3 {

    public static void main(String[] args) {

        System.out.println("Ex3");

        System.out.println("a)");
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        Iterator<Integer> listIterator = list.iterator();
        System.out.print("[");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next());
            if (listIterator.hasNext())
                System.out.print(", ");
        }
        System.out.print("]\n");

        System.out.println("b)");
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 4);
        map.put(3, 9);
        map.put(4, 16);
        map.put(5, 25);
        map.put(6, 36);

        Iterator<Integer> mapIterator = map.keySet().iterator();
        while (mapIterator.hasNext()) {
            Integer i = mapIterator.next();
            System.out.printf("(%d,%d) ", i, map.get(i));

        }

    }

}
