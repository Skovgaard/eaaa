package ex1;

import java.util.NoSuchElementException;

public class LinkedListQueue implements Queue {

    private Node first;
    private Node last;
    private int currentSize;

    /**
     * Constructs an empty queue.
     */
    public LinkedListQueue() {
        currentSize = 0;
    }

    /**
     * Checks whether this queue is empty.
     *
     * @return true if this queue is empty
     */
    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Adds an element to the tail of this queue.
     *
     * @param newElement the element to add
     */
    @Override
    public void enqueue(Object newElement) {
        Node node = new Node(newElement, null);
        if (isEmpty())
            first = node;
        else
            last.next = node;
        last = node;
        currentSize++;
    }

    /**
     * Removes an element from the head of this queue.
     *
     * @return the removed element
     */
    @Override
    public Object dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        Object element = first.data;
        first = first.next;
        currentSize--;
        return element;
    }

    /**
     * Returns the head of this queue. The queue is unchanged.
     *
     * @return the head element
     */
    @Override
    public Object getFront() {
        if (isEmpty())
            throw new NoSuchElementException();
        return first.data;
    }

    /**
     * The number of elements on the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (!isEmpty()) {
            stringBuilder.append(first.data);
            Node node = first;
            while (node.next != null) {
                stringBuilder.append(", ").append(node.next.data);
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
