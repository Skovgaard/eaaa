package ex3;

import java.util.List;

public class Controller {

    private static Controller controller;

    private static Storage storage;

    public void addPerson(Person person) {
        storage.addPerson(person);
    }

    public List<Person> getPersons() {
        return storage.getPersons();
    }

    public static void init() {
        storage = Storage.getInstance();
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
}
