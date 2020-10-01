package ex3;

import ex1.Bil;
import ex2.Dictionary;

public class Main {

    public static void main(String[] args) {

        Dictionary<Bil, Integer> linkedListDictionary = new LinkedListDictionary<>();

        linkedListDictionary.put(new Bil("1", "BMW", "M3", "Blå"), 1);
        linkedListDictionary.put(new Bil("1", "BMW", "M3", "Blå"), 2);
        linkedListDictionary.put(new Bil("1", "BMW", "M3", "Blå"), 3);
        linkedListDictionary.put(new Bil("2", "BMW", "M4", "Sort"), 1);
        linkedListDictionary.put(new Bil("2", "BMW", "M4", "Sort"), 2);
        linkedListDictionary.put(new Bil("3", "BMW", "M5", "Hvid"), 1);
        linkedListDictionary.put(new Bil("3", "BMW", "M5", "Hvid"), 2);

        System.out.println(linkedListDictionary);

        System.out.println("Tidskompleksiteten er O(n) af næsten alle metoder");

    }

}
