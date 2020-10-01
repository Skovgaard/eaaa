package ex3;

public class Main {

    public static void main(String[] args) {

        IntegerBinaryTree fifteen = new IntegerBinaryTree(15, null, null);
        IntegerBinaryTree twentyfive = new IntegerBinaryTree(25, null, null);
        IntegerBinaryTree eightyeight = new IntegerBinaryTree(88, null, null);

        IntegerBinaryTree eleven = new IntegerBinaryTree(11, null, fifteen);
        IntegerBinaryTree thirty = new IntegerBinaryTree(30, twentyfive, null);
        IntegerBinaryTree ninety = new IntegerBinaryTree(90, eightyeight, null);

        IntegerBinaryTree twentytwo = new IntegerBinaryTree(22, eleven, thirty);
        IntegerBinaryTree seventyseven = new IntegerBinaryTree(77, null, ninety);

        IntegerBinaryTree fortyfive = new IntegerBinaryTree(45, twentytwo, seventyseven);

        System.out.println("Sum: " + fortyfive.sum());

        System.out.println("Average: " + fortyfive.average());

    }

}
