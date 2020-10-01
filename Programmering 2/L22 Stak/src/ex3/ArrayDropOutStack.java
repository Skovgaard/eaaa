package ex3;

import java.util.NoSuchElementException;

public class ArrayDropOutStack implements Stack {

    private Object[] elements;
    private int currentSize;
    private int topIndex;

    public ArrayDropOutStack(int size) {
        elements = new Object[size];
        currentSize = 0;
        topIndex = 0;
    }

    @Override
    public void push(Object element) {
        elements[topIndex] = element;
        topIndex++;
        topIndex = topIndex % elements.length;
        if (currentSize < elements.length)
            currentSize++;
    }

    @Override
    public Object pop() {
        Object element = elements[(elements.length + topIndex - 1) % elements.length];
        elements[(elements.length + topIndex - 1) % elements.length] = null;
        currentSize--;
        topIndex--;
        topIndex = topIndex % elements.length;
        return element;
    }

    @Override
    public Object peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return elements[(elements.length + topIndex - 1) % elements.length];
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (currentSize > 0) {
            int pos = (elements.length + topIndex - currentSize) % elements.length;
            stringBuilder.append(elements[pos]);
            int counter = 1;
            while (counter < currentSize) {
                pos = (pos + 1) % elements.length;
                stringBuilder.append(", ").append(elements[pos]);
                counter++;
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
