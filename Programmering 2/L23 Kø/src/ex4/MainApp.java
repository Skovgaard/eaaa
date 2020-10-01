package ex4;

public class MainApp {

    public static void main(String[] args) {

        QueueUsingStack queueUsingStack = new QueueUsingStack();

        queueUsingStack.enqueue(1);
        queueUsingStack.enqueue(2);
        queueUsingStack.enqueue(3);

        System.out.println("Front: " + queueUsingStack.getFront());
        System.out.println("Pop: " + queueUsingStack.dequeue());
        System.out.println("Pop: " + queueUsingStack.dequeue());
        System.out.println("Pop: " + queueUsingStack.dequeue());

    }
}
