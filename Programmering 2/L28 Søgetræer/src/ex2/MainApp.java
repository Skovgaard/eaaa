package ex2;

public class MainApp {

    public static void main(String[] args) {

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(45);
        binarySearchTree.add(22);
        binarySearchTree.add(77);
        binarySearchTree.add(11);
        binarySearchTree.add(30);
        binarySearchTree.add(90);
        binarySearchTree.add(15);
        binarySearchTree.add(25);
        binarySearchTree.add(88);

        System.out.println("max: " + binarySearchTree.findMax());

        while (!binarySearchTree.isEmpty()) {
            System.out.println(binarySearchTree.removeMin());
        }
    }
}
