package ex1student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1 {

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Bent", 25), new Person("Susan", 34),
                new Person("Mikael", 60), new Person("Klaus", 44),
                new Person("Birgitte", 17), new Person("Liselotte", 9));
        List<Person> persons = new ArrayList<Person>(list);
        System.out.println(persons);
        System.out.println();

        System.out.println("ex1");
        System.out.println("Find first person with age = 44: " + findFirst(list, p -> p.getAge() == 44));
        System.out.println("Find first person with name starting with 'S': " + findFirst(list, p -> p.getName().startsWith("S")));
        System.out.println("Find first person with name containing more than 'i': " + findFirst(list, p -> p.getName().indexOf("i") != p.getName().lastIndexOf("i")));
        System.out.println("Find first person with an age equal the length of the name: " + findFirst(list, p -> p.getName().length() == p.getAge()));

//        List<Person> list1 = findAll(persons, p -> p.getAge() < 30);

        System.out.println("Find all persons with name containing letter 'i': " + findAll(list, p -> p.getName().contains("i")));
        System.out.println("Find all persons with name starting with 'S': " + findAll(list, p -> p.getName().startsWith("S")));
        System.out.println("Find all persons with name of length 5: " + findAll(list, p -> p.getName().length() == 5));
        System.out.println("Find all persons with name of length  >= 6 and age < 40: " + findAll(list, p -> p.getName().length() >= 6 && p.getAge() < 40));
    }

    /**
     * Returns from the list the first person
     * that satisfies the predicate.
     * Returns null, if no person satisfies the predicate.
     */
    public static Person findFirst(List<Person> list, Predicate<Person> filter) {
        for (Person p : list) {
            if (filter.test(p))
                return p;
        }
        return null;
    }

    private static List<Person> findAll(List<Person> list, Predicate<Person> filter) {
        List<Person> persons = new LinkedList<>();
        for (Person p : list) {
            if (filter.test(p))
                persons.add(p);
        }
        return persons;
    }

}
