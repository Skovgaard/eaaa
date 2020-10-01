package ex2;

import ex1.Bil;

public class Main {

    public static void main(String[] args) {

        Dictionary<Bil, Integer> hashMapDictionary = new HashMapDictionary<>();

        hashMapDictionary.put(new Bil("1", "BMW", "M3", "Blå"), 1);
        hashMapDictionary.put(new Bil("1", "BMW", "M3", "Blå"), 2);
        hashMapDictionary.put(new Bil("1", "BMW", "M3", "Blå"), 3);
        hashMapDictionary.put(new Bil("2", "BMW", "M4", "Sort"), 1);
        hashMapDictionary.put(new Bil("2", "BMW", "M4", "Sort"), 2);
        hashMapDictionary.put(new Bil("3", "BMW", "M5", "Hvid"), 1);
        hashMapDictionary.put(new Bil("3", "BMW", "M5", "Hvid"), 2);

        System.out.println(hashMapDictionary);

    }

}
