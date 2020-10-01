package ex3;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Ex3 part 1");
        ArrayDropOutStack arrayDropOutStack = new ArrayDropOutStack(5);

        System.out.println(arrayDropOutStack);

        arrayDropOutStack.push(1);
        arrayDropOutStack.push(2);
        arrayDropOutStack.push(3);
        arrayDropOutStack.push(4);
        arrayDropOutStack.push(5);

        System.out.println(arrayDropOutStack);

        arrayDropOutStack.push(6);

        System.out.println(arrayDropOutStack);
        System.out.println(arrayDropOutStack.pop());

        arrayDropOutStack.push(7);
        arrayDropOutStack.push(7);
        arrayDropOutStack.push(7);
        System.out.println(arrayDropOutStack);
        System.out.println(arrayDropOutStack.pop());

        System.out.println(arrayDropOutStack);

        System.out.println("Ex3 part 3");

        DoubleLinkedListDropOutStack doubleLinkedListDropOutStack = new DoubleLinkedListDropOutStack(5);

        doubleLinkedListDropOutStack.push(1);
        doubleLinkedListDropOutStack.push(2);
        doubleLinkedListDropOutStack.push(3);

        System.out.println(doubleLinkedListDropOutStack.toString());

        System.out.println(doubleLinkedListDropOutStack.peek());
        System.out.println(doubleLinkedListDropOutStack.toString());

        System.out.println(doubleLinkedListDropOutStack.pop());
        System.out.println(doubleLinkedListDropOutStack.toString());

        doubleLinkedListDropOutStack.push(4);
        System.out.println(doubleLinkedListDropOutStack.toString());

        doubleLinkedListDropOutStack.push(5);
        doubleLinkedListDropOutStack.push(6);
        doubleLinkedListDropOutStack.push(7);

        System.out.println(doubleLinkedListDropOutStack.toString());
    }
}
