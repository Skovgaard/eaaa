package ex2;

/**
 * A binary tree in which each node has two children.
 */
public class BinaryTree<E> {
    private Node root;

    /**
     * Constructs an empty tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Constructs a tree with one node and no children.
     *
     * @param rootData the data for the root
     */
    public BinaryTree(E rootData) {
        root = new Node();
        root.data = rootData;
        root.left = null;
        root.right = null;
    }

    /**
     * Constructs a binary tree.
     *
     * @param rootData the data for the root
     * @param left     the left subtree
     * @param right    the right subtree
     */
    public BinaryTree(E rootData, BinaryTree<E> left, BinaryTree<E> right) {
        root = new Node();
        root.data = rootData;
        if (left != null) {
            root.left = left.root;
        }
        if (right != null) {
            root.right = right.root;
        }
    }

    /**
     * Checks whether this tree is empty.
     *
     * @return true if this tree is empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Gets the data at the root of this tree.
     *
     * @return the root data
     */
    public E data() {
        return root.data;
    }

    /**
     * Gets the left subtree of this tree.
     *
     * @return the left child of the root
     */
    public BinaryTree<E> left() {
        BinaryTree<E> result = new BinaryTree<E>();
        result.root = root.left;
        return result;
    }

    /**
     * Gets the right subtree of this tree.
     *
     * @return the right child of the root
     */
    public BinaryTree<E> right() {
        BinaryTree<E> result = new BinaryTree<E>();
        result.root = root.right;
        return result;
    }

    /**
     * @param rootData the new data for the root
     * @return the data previous in the root
     */
    public E replace(E rootData) {
        E oldRootData = root.data;
        root.data = rootData;
        return oldRootData;

    }

    /**
     * @param n
     * @return true in n has no children
     */
    private boolean isLeaf(Node n) {
        return n.left == null && n.right == null;
    }

    /**
     * @param n
     * @return true in n has at least one child
     */
    private boolean isInternal(Node n) {
        return n.left != null || n.right != null;
    }

    /**
     * @return the number of nodes in the tree
     */
    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if (n == null)
            return 0;
        else
            return (size(n.left) + 1 + size(n.right));
    }

    public int height() {
        return height(root);
    }

    private int height(Node n) {
        if (n == null)
            return 0;
        else
            return Math.max(height(n.left) + 1, height(n.right) + 1);
    }


    public void printPreorder() {
        printPreorder(root);
        System.out.println();
    }

    private void printPreorder(Node n) {
        if (n.left != null) printPreorder(n.left);
        System.out.print(n.data + " ");
        if (n.right != null) printPreorder(n.right);
    }

    public void printInorder() {
        printInorder(root);
        System.out.println();
    }

    private void printInorder(Node n) {
        System.out.print(n.data + " ");
        if (n.left != null) printInorder(n.left);
        if (n.right != null) printInorder(n.right);
    }

    public void printPostorder() {
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(Node n) {
        if (n.left != null) printPostorder(n.left);
        if (n.right != null) printPostorder(n.right);
        System.out.print(n.data + " ");
    }

    private class Node {
        public E data;
        public Node left;
        public Node right;
    }
}
