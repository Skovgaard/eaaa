package ex3;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Ex3");

        CircularList circularList = new CircularList();

        circularList.add(new Person("A"));
        circularList.add(new Person("B"));
        circularList.add(new Person("C"));
        circularList.add(new Person("D"));
        circularList.add(new Person("E"));
        circularList.add(new Person("F"));
        circularList.add(new Person("G"));
        circularList.add(new Person("H"));

        System.out.println(circularList.toString());

        System.out.println(circularList.randomStartIndex());

        System.out.println(circularList.toString());

        System.out.println("Eat order:");
        while (!circularList.isEmpty()) {
            System.out.println(circularList.removeFromNIndexes(5));
        }
    }
}
