package opg;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Binært træ er en datastruktur træ, hvor en node max kan have 2 børn/grene");

        BinaryTree<String> two = new BinaryTree<>("2");
        BinaryTree<String> four = new BinaryTree<>("4");

        BinaryTree<String> plus3 = new BinaryTree<>("+", two, four);
        BinaryTree<String> seven = new BinaryTree<>("7");
        BinaryTree<String> three = new BinaryTree<>("3");
        BinaryTree<String> eight = new BinaryTree<>("8");


        BinaryTree<String> times = new BinaryTree<>("*", plus3, seven);
        BinaryTree<String> plus2 = new BinaryTree<>("+", three, eight);

        BinaryTree<String> binaryTreeRoot = new BinaryTree<>("+", times, plus2);


        System.out.println("count '+': " + binaryTreeRoot.countElements("+"));

        System.out.println("value: " + binaryTreeRoot.value());

        binaryTreeRoot.printPreorder();

        System.out.println("Kan evt. tælde antallet af + / * i en 'højde' og ligge en til, idet de altid har 1 barn og tal er blade");
        System.out.println("Ellers kan man køre recursivt igennem noderne fra binaryTreeRoot med Math.max af de 2 under noder");

        System.out.println("height: " + binaryTreeRoot.height());

    }

}
