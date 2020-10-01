package ex2;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Ex 2");

        DoubleLinkedListDeque doubleLinkedListDeque = new DoubleLinkedListDeque();

        doubleLinkedListDeque.addFirst(3);
        doubleLinkedListDeque.addFirst(2);
        doubleLinkedListDeque.addFirst(1);
        System.out.println(doubleLinkedListDeque.toString());

        doubleLinkedListDeque.addLast(4);
        doubleLinkedListDeque.addLast(5);
        doubleLinkedListDeque.addLast(6);
        System.out.println(doubleLinkedListDeque.toString());

        System.out.println("Remove first: " + doubleLinkedListDeque.removeFirst());
        System.out.println("Remove last: " + doubleLinkedListDeque.removeLast());
        System.out.println(doubleLinkedListDeque.toString());

        System.out.println("Get first: " + doubleLinkedListDeque.getFirst());
        System.out.println("Get last: " + doubleLinkedListDeque.getLast());
        System.out.println("Size: " + doubleLinkedListDeque.size());

        System.out.println("Tidskompleksitet:");
        System.out.println("addFirst(e): O(1)");
        System.out.println("addLast(e): O(1)");
        System.out.println("removeFirst(): O(1)");
        System.out.println("removeLast(): O(1)");
        System.out.println("getFirst(): O(1)");
        System.out.println("getLast(): O(1)");
        System.out.println("size(): O(1)");
        System.out.println("isEmpty(): O(1)");

    }
}
