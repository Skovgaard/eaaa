package ex3;

import java.util.LinkedList;
import java.util.List;

public class Storage {

    private static Storage storage;

    private static List<Person> persons = new LinkedList<>();

    public static void addPerson(Person person) {
        persons.add(person);
    }

    public static List<Person> getPersons() {
        return persons;
    }

    public static Storage getInstance() {
        if (storage == null)
            storage = new Storage();
        return storage;
    }
}
