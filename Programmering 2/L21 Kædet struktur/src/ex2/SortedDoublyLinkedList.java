package ex2;

public class SortedDoublyLinkedList {

    public Node first;
    private Node last;
    private int count;

    /**
     * Laver en tom sorteret doubly linked list.
     */
    public SortedDoublyLinkedList() {
        Node sentinelFirst = new Node();
        Node sentinelLast = new Node();
        sentinelFirst.previous = null;
        sentinelFirst.next = sentinelLast;
        sentinelLast.previous = sentinelFirst;
        sentinelLast.next = null;
        this.first = sentinelFirst;
        this.last = sentinelLast;
        count = 0;
    }

    /**
     * Tilføjer et element til listen, så listen fortsat er sorteret * i henhold til den naturlige ordning på elementerne.
     *
     * @param element det der indsættes
     */
    public void addElement(String element) {
        // TODO: lav mig - FIX HER?
        if (first.next.data == null)
            addFirst(element);
        else {
            Node position = first.next;
            while (position.data.compareTo(element) < 0) {
                if (position.next.data == null) {
                    addLast(element);
                    return;
                }
                position = position.next;
            }
            if (position.previous.data == null)
                addFirst(element);
            else {
                Node newNode = new Node();
                newNode.data = element;
                newNode.previous = position.previous;
                newNode.next = position;
                position.previous.next = newNode;
                position.previous = newNode;
                count++;
            }
        }
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
        } else if (first.next.data.equals(element)) {
            removeFirst();
        } else {
            Node currentNode = first.next.next;
            while (!currentNode.data.equals(element)) {
                if (currentNode.next.next == null)
                    return false;
                currentNode = currentNode.next;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
        count--;
        return true;
    }

    private void addFirst(String element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.previous = first;
        newNode.next = first.next;
        newNode.previous.next = newNode;
        newNode.next.previous = newNode;
        count++;
    }

    private void addLast(String element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.previous = last.previous;
        newNode.next = last;
        newNode.previous.next = newNode;
        newNode.next.previous = newNode;
        count++;
    }

    public String removeFirst() {
        Node firstDataNode = first.next;
        firstDataNode.next.previous = first;
        first.next = firstDataNode.next;
        count--;
        return firstDataNode.data;
    }

    public String removeLast() {
        Node lastDataNode = last.previous;
        lastDataNode.previous.next = last;
        last.previous = lastDataNode.previous;
        count--;
        return lastDataNode.data;
    }

    public int countElements() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (first.next.data != null) {
            Node node = first.next;
            stringBuilder.append(node.data);
            node = node.next;
            while (node.data != null) {
                stringBuilder.append(", ").append(node.data);
                node = node.next;
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private class Node {
        public String data;
        public Node next;
        public Node previous;
    }

}