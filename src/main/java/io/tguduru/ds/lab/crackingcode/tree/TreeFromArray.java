package io.tguduru.ds.lab.crackingcode.tree;

/**
 * Implement an algorithm to create a binary tree
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/17/16.
 */
public class TreeFromArray<E> {


    public Node<E> buildTree(E[] array, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node<E> node = new Node<E>(array[mid]);
        node.setLeft(buildTree(array, start, mid - 1));
        node.setRight(buildTree(array, mid + 1, end));
        return node;
    }

    public void inOrderTraversal(Node<E> node) {
        if (node == null)
            return;
        inOrderTraversal(node.getLeft());
        System.out.print(node.element + " --> ");
        inOrderTraversal(node.getRight());
    }

    public static void main(String[] args) {
        TreeFromArray<Integer> tree = new TreeFromArray<>();
        Integer[] array = {3, 4, 5, 6, 7, 8, 9};
        Node<Integer> root = tree.buildTree(array, 0, array.length - 1);
        tree.inOrderTraversal(root);
    }

}
