package ex4;

import ex1.Bil;
import ex2.Dictionary;

public class Main {

    public static void main(String[] args) {

        Dictionary<Bil, Integer> arrayDictionary = new ArrayDictionary<>();

        arrayDictionary.put(new Bil("1", "BMW", "M3", "Blå"), 1);
        arrayDictionary.put(new Bil("1", "BMW", "M3", "Blå"), 2);
        arrayDictionary.put(new Bil("1", "BMW", "M3", "Blå"), 3);
        arrayDictionary.put(new Bil("2", "BMW", "M4", "Sort"), 1);
        arrayDictionary.put(new Bil("2", "BMW", "M4", "Sort"), 2);
        arrayDictionary.put(new Bil("3", "BMW", "M5", "Hvid"), 1);
        arrayDictionary.put(new Bil("3", "BMW", "M5", "Hvid"), 2);
        arrayDictionary.put(new Bil("5", "BMW", "M6", "Rød"), 7);

        System.out.println(arrayDictionary);

        System.out.println("Tidskompleksiteten er O(n) (hashing er (1), men skal stadig igennem hver arrayliste) af næsten alle metoder");

    }

}
