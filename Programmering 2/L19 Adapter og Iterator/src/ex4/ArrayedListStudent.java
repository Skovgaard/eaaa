package ex4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * null is not allowed as a value in the list.
 */
public class ArrayedListStudent<T> implements Iterable<T> {
    // array to store the entries in;
    // not-empty entries have indices in [0, size-1]
    private T[] items;
    // number of entries in the list and also
    // index of the first empty slot in items
    private int size;

    /**
     * Creates an ArrayedList with capacity 16.
     */
    public ArrayedListStudent() {
        this(16);
    }

    /**
     * Creates an ArrayedList with the given capacity.
     * Pre: capacity >= 1.
     */
    public ArrayedListStudent(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        items = temp;
        size = 0;
    }

    private void increaseCapacity() {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[2 * items.length];
        for (int i = 0; i < size; i++) {
            temp[i] = this.items[i];
        }
        items = temp;
    }

    /**
     * Adds the entry at the end of this list.
     */
    public void add(T entry) {
        if (size == items.length) {
            this.increaseCapacity();
        }

        items[size] = entry;
        size++;
    }

    /**
     * Adds the entry at the index.
     * Throws IndexOutOfBoundsException,
     * if index is not in [0, size()].
     */
    public void add(int index, T entry) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == size) {
            this.add(entry);
            return;
        }

        if (size == items.length) {
            this.increaseCapacity();
        }

        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = entry;
        size++;
    }

    /**
     * Removes and returns the entry at the index.
     * Throws IndexOutOfBoundsException,
     * if this list is empty or index is not in [0, size()-1].
     */
    public T remove(int index) {
        if (index < 0 || index > size - 1 || size == 0)
            throw new IndexOutOfBoundsException();

        T entry = items[index];
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        items[size - 1] = null;
        size--;
        return entry;
    }

    /**
     * Replaces and returns the old entry at the index
     * with the specified entry.
     * Throws IndexOutOfBoundsException,
     * if this list is empty or index is not in [0, size()-1].
     */
    public T replace(int index, T entry) {
        if (index < 0 || index > size - 1 || size == 0)
            throw new IndexOutOfBoundsException();

        T oldEntry = items[index];
        items[index] = entry;
        return oldEntry;
    }

    /**
     * Returns the entry at the index.
     * Throws IndexOutOfBoundsException,
     * if this list is empty or index is not in [0, size()-1].
     */
    public T get(int index) {
        if (index < 0 || index > size - 1 || size == 0)
            throw new IndexOutOfBoundsException();

        T entry = items[index];
        return entry;
    }

    /**
     * Returns true, if the entry is in this list.
     */
    public boolean contains(T entry) {
        boolean found = false;
        int i = 0;
        while (!found && i < size) {
            if (items[i].equals(entry)) {
                found = true;
            }
            i++;
        }
        return found;
    }

    /**
     * Returns the number of entries in this list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true, if this list is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all entries from this list.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
    }

    /**
     * Returns an array containing all entries
     * in the same order as in this list.
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] copy = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            copy[i] = items[i];
        }
        return copy;
    }

    @Override
    public String toString() {
        if (this.isEmpty())
            return ("[]");

        StringBuilder sb = new StringBuilder("[");
        sb.append(items[0]);
        for (int i = 1; i < size; i++) {
            sb.append(", " + items[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    //-------------------------------------------------------------------------
    // Ex. 3

    // TODO
    @Override
    public Iterator<T> iterator() {
        return new ArrayListStudentIterator();
    }

    private class ArrayListStudentIterator implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return items[index++];
        }
    }

}
