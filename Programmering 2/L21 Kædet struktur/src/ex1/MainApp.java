package ex1;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Opg 1:");
        System.out.println();
        SortedLinkedList sortedLinkedList = new SortedLinkedList();

        System.out.println("Tilføjer b, a, h, c, d, e, a, c");
        sortedLinkedList.addElement("b");
        sortedLinkedList.addElement("a");
        sortedLinkedList.addElement("h");
        sortedLinkedList.addElement("c");
        sortedLinkedList.addElement("d");
        sortedLinkedList.addElement("e");
        sortedLinkedList.addElement("a");
        sortedLinkedList.addElement("c");

        System.out.println("sortedLinkedList = " + sortedLinkedList.toString());
        System.out.println("Liste størrelse: " + sortedLinkedList.countElements());

        System.out.println();
        System.out.println("Fjerner c");
        sortedLinkedList.removeElement("c");
        System.out.println("sortedLinkedList = " + sortedLinkedList.toString());
        System.out.println("Liste størrelse: " + sortedLinkedList.countElements());

        System.out.println();
        System.out.println("Fjerner a, d, h");
        sortedLinkedList.removeElement("a");
        sortedLinkedList.removeElement("d");
        sortedLinkedList.removeElement("h");
        System.out.println("sortedLinkedList = " + sortedLinkedList.toString());
        System.out.println("Liste størrelse: " + sortedLinkedList.countElements());

        System.out.println();
        System.out.println("Fjerner e med retur boolean: " + sortedLinkedList.removeElement("e"));
        System.out.println("Fjerner å med retur boolean: " + sortedLinkedList.removeElement("å"));
    }

}
