package ex3;

import java.util.List;

public class Controller {

    private static Storage storage;

    public static void addPerson(Person person) {
        Storage.addPerson(person);
    }

    public static List<Person> getPersons() {
        return Storage.getPersons();
    }

}
