package ex3;

/**
 * A binary tree in which each node has two children.
 */
public class IntegerBinaryTree {
    private Node root;

    /**
     * Constructs an empty tree.
     */
    public IntegerBinaryTree() {
        root = null;
    }

    /**
     * Constructs a tree with one node and no children.
     *
     * @param rootData the data for the root
     */
    public IntegerBinaryTree(int rootData) {
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
    public IntegerBinaryTree(int rootData, IntegerBinaryTree left, IntegerBinaryTree right) {
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
    public boolean isintmpty() {
        return root == null;
    }

    /**
     * Gets the data at the root of this tree.
     *
     * @return the root data
     */
    public int data() {
        return root.data;
    }

    /**
     * Gets the left subtree of this tree.
     *
     * @return the left child of the root
     */
    public IntegerBinaryTree left() {
        IntegerBinaryTree result = new IntegerBinaryTree();
        result.root = root.left;
        return result;
    }

    /**
     * Gets the right subtree of this tree.
     *
     * @return the right child of the root
     */
    public IntegerBinaryTree right() {
        IntegerBinaryTree result = new IntegerBinaryTree();
        result.root = root.right;
        return result;
    }

    /**
     * @param rootData the new data for the root
     * @return the data previous in the root
     */
    public int replace(int rootData) {
        int oldRootData = root.data;
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
            return size(n.left) + 1 + size(n.right);
    }

    public int height() {
        // Del-løs-kombiner? Menes merge sort? Har brugt recursion
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

    public int sum() {
        return sum(root);
    }

    private int sum(Node n) {
        if (n == null)
            return 0;
        else
            return sum(n.left) + n.data + sum(n.right);
    }

    public double average() {
        return (double) sum() / size();
    }

    private class Node {
        public int data;
        public Node left;
        public Node right;
    }
}
