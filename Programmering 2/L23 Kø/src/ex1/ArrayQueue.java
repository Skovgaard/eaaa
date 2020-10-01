package ex1;

import java.util.NoSuchElementException;

/**
 * An implementation of a queue as a array.
 */
public class ArrayQueue implements Queue {

    private Object[] elements;
    private int currentSize;

    /**
     * Constructs an empty queue.
     */
    public ArrayQueue() {
        elements = new Object[10];
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
        growIfNecessary();
        elements[currentSize] = newElement;
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
        Object element = elements[0];
        int i = 0;
        while (elements[i] != null) {
            elements[i] = elements[i + 1];
            i++;
        }
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
        return elements[0];
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

    private void growIfNecessary() {
        if (currentSize == elements.length) {
            Object[] newElements = new Object[2 * elements.length];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (!isEmpty())
            stringBuilder.append(elements[0]);
        int i = 1;
        while (elements[i] != null) {
            stringBuilder.append(", ").append(elements[i]);
            i++;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
