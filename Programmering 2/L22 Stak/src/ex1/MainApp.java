package ex1;

public class MainApp {

    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack();

        System.out.println("Empty? " + arrayStack.isEmpty());

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);

        System.out.println("ArrayStack: " + arrayStack.toString());

        System.out.println("Pop: " + arrayStack.pop());
        System.out.println("Pop: " + arrayStack.pop());
        System.out.println("Peek: " + arrayStack.peek());

        System.out.println("Size: " + arrayStack.size());

        System.out.println("Pop: " + arrayStack.pop());
        System.out.println("Peek: " + arrayStack.peek());

    }

}
