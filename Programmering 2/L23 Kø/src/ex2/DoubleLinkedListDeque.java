package ex2;

import java.util.NoSuchElementException;

public class DoubleLinkedListDeque implements Deque {

    private Node first;
    private Node last;
    private int currentSize;

    public DoubleLinkedListDeque() {
        currentSize = 0;
    }

    @Override
    public void addFirst(Object newElement) {
        Node node = new Node(newElement, null, first);
        if (isEmpty())
            last = node;
        else
            first.previous = node;
        first = node;
        currentSize++;
    }

    @Override
    public void addLast(Object newElement) {
        Node node = new Node(newElement, last, null);
        if (isEmpty())
            first = node;
        else
            last.next = node;
        last = node;
        currentSize++;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        Object element = first.data;
        if (first.next != null) {
            first.next.previous = null;
            first = first.next;
        } else
            first = null;
        currentSize--;
        return element;
    }

    @Override
    public Object removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        Object element = last.data;
        if (last.previous != null) {
            last.previous.next = null;
            last = last.previous;
        } else
            last = null;
        currentSize--;
        return element;
    }

    @Override
    public Object getFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return first.data;
    }

    @Override
    public Object getLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        return last.data;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (!isEmpty()) {
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
