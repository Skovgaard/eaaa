package ex2;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> fifteen = new BinaryTree<>(15, null, null);
        BinaryTree<Integer> twentyfive = new BinaryTree<>(25, null, null);
        BinaryTree<Integer> eightyeight = new BinaryTree<>(88, null, null);

        BinaryTree<Integer> eleven = new BinaryTree<>(11, null, fifteen);
        BinaryTree<Integer> thirty = new BinaryTree<>(30, twentyfive, null);
        BinaryTree<Integer> ninety = new BinaryTree<>(90, eightyeight, null);

        BinaryTree<Integer> twentytwo = new BinaryTree<>(22, eleven, thirty);
        BinaryTree<Integer> seventyseven = new BinaryTree<>(77, null, ninety);

        BinaryTree<Integer> fortyfive = new BinaryTree<>(45, twentytwo, seventyseven);

        System.out.println("Height:" + fortyfive.height());

        System.out.println("Preorder:");
        fortyfive.printPreorder();

        System.out.println("Inorder:");
        fortyfive.printInorder();

        System.out.println("Postorder:");
        fortyfive.printPostorder();

    }


}
