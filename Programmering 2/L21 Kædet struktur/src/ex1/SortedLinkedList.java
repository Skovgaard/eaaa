package ex1;

public class SortedLinkedList {

    private Node first;
    private Node last;
    private int count;

    public SortedLinkedList() {
        // TODO: lav mig
        first = null;
        last = null;
        count = 0;
    }

    /**
     * Tilføjer et element til listen, så listen fortsat er sorteret i * henhold til den naturlige ordning på elementerne.
     *
     * @param element det der indsættes
     */
    public void addElement(String element) {
        if (first == null) {
            addFirst(element);
            last = first;
        } else {
            Node previousNode = null;
            Node currentNode = first;
            while (((String) currentNode.data).compareTo(element) < 0) {
                if (currentNode.next == null) {
                    addLast(element);
                    return;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            Node newNode = new Node(element, currentNode);
            if (previousNode == null) {
                addFirst(element);
                return;
            } else
                previousNode.next = newNode;
            count++;
        }
    }

    private void addFirst(String element) {
        first = new Node(element, first);
        count++;
    }

    private void addLast(String element) {
        Node newNode = new Node(element, null);
        last.next = newNode;
        last = newNode;
        count++;
    }

    /**
     * Fjerner et element fra listen.
     *
     * @param element det element der fjernes
     * @return true hvis elementet blev fjernet, men ellers false.
     */
    public boolean removeElement(String element) {
        if (first == null) {
            return false;
        } else if (first.data.equals(element)) {
            first = first.next;
        } else {
            Node previousNode = first;
            Node currentNode = first.next;
            while (!currentNode.data.equals(element)) {
                if (currentNode.next == null)
                    return false;
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            previousNode.next = currentNode.next;
            if (currentNode == last)
                last = previousNode;
        }
        count--;
        return true;
    }

    /**
     * Returnerer antallet af elementer i listen.
     */
    public int countElements() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (first != null) {
            stringBuilder.append(first.data);
            Node node = first.next;
            while (node != null) {
                stringBuilder.append(", ").append(node.data);
                node = node.next;
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}



