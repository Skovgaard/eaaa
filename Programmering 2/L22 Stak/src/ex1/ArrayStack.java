package ex1;

import java.util.NoSuchElementException;

public class ArrayStack implements Stack {

    private Object[] elements;
    private int currentSize;

    public ArrayStack() {
        final int INITIAL_SIZE = 10;
        elements = new Object[INITIAL_SIZE];
        currentSize = 0;
    }

    @Override
    public void push(Object element) {
        growIfNecessary();
        elements[currentSize] = element;
        currentSize++;
    }

    @Override
    public Object pop() {
        if (currentSize == 0)
            throw new NoSuchElementException();
        Object element = elements[currentSize - 1];
        elements[currentSize - 1] = null;
        currentSize--;
        return element;
    }

    @Override
    public Object peek() {
        if (currentSize == 0)
            throw new NoSuchElementException();
        return elements[currentSize - 1];
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

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
        if (currentSize > 0)
            stringBuilder.append(elements[0]);
        for (int i = 1; i < currentSize; i++) {
            stringBuilder.append(", ").append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
