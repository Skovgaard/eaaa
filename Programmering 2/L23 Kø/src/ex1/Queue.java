package ex1;

public interface Queue {
    /**
     * Add element in the back of the queue.
     */
    public void enqueue(Object element);

    /**
     * Remove and return element from the front of the queue.
     */
    public Object dequeue();

    /**
     * Return the element in the front of the queue without removing it.
     */
    public Object getFront();

    /**
     * Tests if the queue is empty.
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     */
    public int size();
}
