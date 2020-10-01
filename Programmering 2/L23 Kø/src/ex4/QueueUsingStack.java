package ex4;

import ex1.Queue;

public class QueueUsingStack implements Queue {

    private ArrayStack enqueueStack = new ArrayStack();
    private ArrayStack dequeueStack = new ArrayStack();

    @Override
    public void enqueue(Object element) {
        enqueueStack.push(element);
    }

    @Override
    public Object dequeue() {
        moveToDequeueStack();
        return dequeueStack.pop();
    }

    @Override
    public Object getFront() {
        moveToDequeueStack();
        return dequeueStack.peek();
    }

    private void moveToDequeueStack() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return enqueueStack.size() + dequeueStack.size() == 0;
    }

    @Override
    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }
}
