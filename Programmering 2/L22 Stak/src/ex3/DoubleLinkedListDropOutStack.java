package ex3;

import java.util.NoSuchElementException;

public class DoubleLinkedListDropOutStack implements Stack {

    private Node first;
    private Node last;
    private int count;
    private int maxSize = 5;

    public DoubleLinkedListDropOutStack(int maxSize) {
        first = null;
        last = null;
        count = 0;
        this.maxSize = maxSize;
    }

    @Override
    public void push(Object element) {
        Node node = new Node(element, last, null);
        if (node.previous != null)
            node.previous.next = node;
        last = node;
        if (isEmpty())
            first = node;
        if (count < maxSize)
            count++;
        else {
            first.next.previous = null;
            first = first.next;
        }
    }

    @Override
    public Object pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        Node element = last;
        element.previous.next = null;
        last = element.previous;
        count--;
        return element.data;
    }

    @Override
    public Object peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return last.data;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

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
        private Node previous;
        private Node next;

        public Node(Object data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }
}
