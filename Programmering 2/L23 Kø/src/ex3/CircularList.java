package ex3;

import java.util.Random;

public class CircularList {

    private Node first;
    private Node last;
    private int currentSize;

    public CircularList() {
        currentSize = 0;
    }

    public void add(Object element) {
        Node node = new Node(element, first);
        if (isEmpty()) {
            first = node;
            node.next = node;
        } else {
            last.next = node;
        }
        last = node;
        currentSize++;
    }

    public int randomStartIndex() {
        int randomInt = new Random().nextInt(currentSize);
        moveStartByIndexes(randomInt);
        return randomInt;
    }

    private void moveStartByIndexes(int n) {
        int i = n;
        while (i != 0) {
            first = first.next;
            last = last.next;
            i--;
        }
    }

    public Object removeFromNIndexes(int n) {
        int i = n;
        Node prevNode = last;
        Node node = first;
        while (i != 0) {
            prevNode = prevNode.next;
            node = node.next;
            i--;
        }
        prevNode.next = node.next;
        if (currentSize == 1) {
            first = null;
            last = null;
        } else {
            moveStartByIndexes(n);
        }
        if (node == first)
            first = node.next;
        if (node == last)
            last = prevNode;
        currentSize--;
        return node.data;
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (!isEmpty()) {
            stringBuilder.append(first.data);
            Node node = first;
            while (node.next != null && node.next != first) {
                stringBuilder.append(", ").append(node.next.data);
                node = node.next;
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static class Node {

        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
