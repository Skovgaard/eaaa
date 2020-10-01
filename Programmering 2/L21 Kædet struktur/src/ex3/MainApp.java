package ex3;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Opg 3:");
        System.out.println();
        SortedLinkedList sortedLinkedList = new SortedLinkedList();

        System.out.println("Tilføjer b, a, c til sortedLinkedList");
        sortedLinkedList.addElement("b");
        sortedLinkedList.addElement("a");
        sortedLinkedList.addElement("c");

        System.out.println("sortedLinkedList = " + sortedLinkedList.toString());

        System.out.println();
        SortedLinkedList sortedLinkedList2 = new SortedLinkedList();

        System.out.println("Tilføjer g, f, h til ny sortedLinkedList2");
        sortedLinkedList2.addElement("g");
        sortedLinkedList2.addElement("f");
        sortedLinkedList2.addElement("h");

        System.out.println("sortedLinkedList2 = " + sortedLinkedList2.toString());

        System.out.println();
        System.out.println("Kører addAll(sortedLinkedList2) to sortedLinkedList");
        sortedLinkedList.addAll(sortedLinkedList2);
        System.out.println("sortedLinkedList = " + sortedLinkedList.toString());
        System.out.println("Liste størrelse: " + sortedLinkedList.countElements());

    }

}
