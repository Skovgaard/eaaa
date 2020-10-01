package ex1;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Ex 1.1");

        ArrayQueue arrayQueue = new ArrayQueue();

        System.out.println(arrayQueue.toString());

        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue.toString());

        System.out.println(arrayQueue.getFront());

        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.toString());

        System.out.println("Ex 1.2");

        LinkedListQueue linkedListQueue = new LinkedListQueue();

        System.out.println(linkedListQueue.toString());

        linkedListQueue.enqueue(1);
        linkedListQueue.enqueue(2);
        linkedListQueue.enqueue(3);
        System.out.println(linkedListQueue.toString());

        System.out.println(linkedListQueue.getFront());

        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.toString());

    }
}
