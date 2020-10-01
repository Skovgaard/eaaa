package ex2;

public class LinkedBag<E> implements Bag<E> {

    private Node first;
    private Node last;
    private int maxSize;
    private int currentSize;

    public LinkedBag() {
        first = null;
        last = null;
        maxSize = 10;
        currentSize = 0;
    }

    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public boolean isFull() {
        return currentSize == maxSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean add(E newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isFull())
            return false;
        if (isEmpty()) {
            first = newNode;
        } else
            last.next = newNode;
        last = newNode;
        currentSize++;
        return true;
    }

    @Override
    public E remove() {
        E removedData = first.data;
        first = first.next;
        currentSize--;
        return removedData;
    }

    @Override
    public boolean remove(E anEntry) {
        Node previouseNode = null;
        Node node = first;
        while (node != null) {
            if (node.data.equals(anEntry)) {
                if (previouseNode != null) previouseNode.next = node.next;
                if (node == first) first = node.next;
                if (node == last) last = previouseNode;
                currentSize--;
                return true;
            }
            previouseNode = node;
            node = node.next;
        }
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        currentSize = 0;
    }

    @Override
    public int getFrequencyOf(E anEntry) {
        int count = 0;
        Node node = first;
        while (node != null) {
            if (node.data.equals(anEntry))
                count++;
            node = node.next;
        }
        return count;
    }

    @Override
    public boolean contains(E anEntry) {
        Node node = first;
        while (node != null) {
            if (node.data.equals(anEntry))
                return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[currentSize];
        Node node = first;
        for (int i = 0; i < currentSize; i++) {
            array[i] = node.data;
            node = node.next;
        }
        return array;
    }

    private class Node {

        public E data;
        private Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
