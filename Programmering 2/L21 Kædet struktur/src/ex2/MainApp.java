package ex2;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Opg 2:");
        System.out.println();
        SortedDoublyLinkedList sortedDoublyLinkedList = new SortedDoublyLinkedList();

        System.out.println("Tilføjer a, c, d, g, h, f, b, e");
        sortedDoublyLinkedList.addElement("a");
        sortedDoublyLinkedList.addElement("c");
        sortedDoublyLinkedList.addElement("d");
        sortedDoublyLinkedList.addElement("g");
        sortedDoublyLinkedList.addElement("h");
        sortedDoublyLinkedList.addElement("f");
        sortedDoublyLinkedList.addElement("b");
        sortedDoublyLinkedList.addElement("e");

        System.out.println("sortedLinkedList = " + sortedDoublyLinkedList.toString());
        System.out.println("Liste størrelse: " + sortedDoublyLinkedList.countElements());

        System.out.println();
        System.out.println("Fjerner første element: " + sortedDoublyLinkedList.removeFirst());

        System.out.println("sortedLinkedList = " + sortedDoublyLinkedList.toString());
        System.out.println("Liste størrelse: " + sortedDoublyLinkedList.countElements());

        System.out.println();
        System.out.println("Fjerner sidste element: " + sortedDoublyLinkedList.removeLast());

        System.out.println("sortedLinkedList = " + sortedDoublyLinkedList.toString());
        System.out.println("Liste størrelse: " + sortedDoublyLinkedList.countElements());

        System.out.println();
        System.out.println("Fjerner d");
        sortedDoublyLinkedList.removeElement("d");

        System.out.println("sortedLinkedList = " + sortedDoublyLinkedList.toString());
        System.out.println("Liste størrelse: " + sortedDoublyLinkedList.countElements());

        System.out.println();
        System.out.println("Fjerner e med retur boolean: " + sortedDoublyLinkedList.removeElement("e"));
        System.out.println("Fjerner å med retur boolean: " + sortedDoublyLinkedList.removeElement("å"));

    }

}
