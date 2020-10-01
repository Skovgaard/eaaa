package ex6;

import ex1.Bil;
import ex2.Dictionary;
import ex2.HashMapDictionary;
import ex3.LinkedListDictionary;
import ex4.ArrayDictionary;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Dictionary<Bil, Integer>> dictionaryList = new LinkedList<>();

        Dictionary<Bil, Integer> hashMapDictionary = new HashMapDictionary<>();
        Dictionary<Bil, Integer> linkedListDictionary = new LinkedListDictionary<>();
        Dictionary<Bil, Integer> arrayDictionary = new ArrayDictionary<>();

        dictionaryList.add(hashMapDictionary);
        dictionaryList.add(linkedListDictionary);
        dictionaryList.add(arrayDictionary);

        Bil b1 = new Bil("1", "BMW", "M3", "Blå");
        Bil b2 = new Bil("2", "BMW", "M4", "Sort");
        Bil b3 = new Bil("3", "BMW", "M5", "Hvid");

        for (Dictionary<Bil, Integer> bilIntegerDictionary : dictionaryList) {
            bilIntegerDictionary.put(b1, 1);
        }

        for (Dictionary<Bil, Integer> bilIntegerDictionary : dictionaryList) {
            bilIntegerDictionary.put(b1, 2);
        }

        for (Dictionary<Bil, Integer> bilIntegerDictionary : dictionaryList) {
            bilIntegerDictionary.put(b2, 1);
        }

        for (Dictionary<Bil, Integer> bilIntegerDictionary : dictionaryList) {
            bilIntegerDictionary.put(b3, 3);
        }

        for (Dictionary<Bil, Integer> bilIntegerDictionary : dictionaryList) {
            bilIntegerDictionary.remove(b1);
        }

        for (Dictionary<Bil, Integer> bilIntegerDictionary : dictionaryList) {
            System.out.println(bilIntegerDictionary.toString());
        }

        for (Dictionary<Bil, Integer> bilIntegerDictionary : dictionaryList) {
            System.out.println(bilIntegerDictionary.size());
        }

    }

}
