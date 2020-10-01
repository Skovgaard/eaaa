package ex4;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Opg 4:");
        System.out.println();
        SortedLinkedList sortedLinkedList = new SortedLinkedList();

        System.out.println("Tilføjer b, a, c til sortedLinkedList");
        sortedLinkedList.addElement("b");
        sortedLinkedList.addElement("a");
        sortedLinkedList.addElement("c");

        System.out.println("sortedLinkedList = " + sortedLinkedList.toString());

        System.out.println("Count rekursivt: " + sortedLinkedList.countElementsRecursively());

    }

}
