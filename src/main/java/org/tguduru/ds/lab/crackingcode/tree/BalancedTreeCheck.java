package org.tguduru.ds.lab.crackingcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Check whether the given Tree is balanced tree or not.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/17/16.
 */
public class BalancedTreeCheck<E> {
    private Node<E> root;
    private int size;

    public BalancedTreeCheck() {
        root = null;
        size = 0;
    }

    public Node<E> add(E ele) {
        if (ele == null)
            throw new RuntimeException("Cannot add null element");
        Node<E> node = new Node<>(ele);
        size++;
        if (root == null) {
            root = node;
            return root;
        }
        Node<E> parent = findParent(root);
        if (parent.getLeft() == null) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
        node.setParent(parent);
        return node;

    }

    /**
     * find the parent using breadth first search.
     *
     * @param node
     * @return
     */
    private Node<E> findParent(Node<E> node) {
        if (node.getLeft() == null || node.getRight() == null)
            return node;
        List<Node<E>> nodes = new ArrayList<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            List<Node<E>> tempNodeList = new ArrayList<>();
            for (Node<E> n : nodes) {
                if (n.getLeft() == null || n.getRight() == null)
                    return n;
                for (Node<E> s : n.getChildren()) {
                    if (s.getLeft() == null || s.getRight() == null)
                        return s;
                    else
                        tempNodeList.add(s);
                }
            }
            nodes = tempNodeList;
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public Node<E> getRoot() {
        return root;
    }

    public int maxDepth(Node<E> node) {
        if (node == null)
            return 0;
        return 1 + Math.max(maxDepth(node.getLeft()), maxDepth(node.getRight()));
    }

    public int minDepth(Node<E> node) {
        if (node == null)
            return 0;
        return 1 + Math.min(minDepth(node.getLeft()), minDepth(node.getRight()));
    }

    public static void main(String[] args) {
        BalancedTreeCheck<Integer> tree = new BalancedTreeCheck<>();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(60);
        tree.add(70);

        System.out.println(tree.maxDepth(tree.getRoot()));
        System.out.println(tree.minDepth(tree.getRoot()));
        System.out.println(tree.maxDepth(tree.getRoot()) - tree.minDepth(tree.getRoot()) <= 1 ? "Tree is balanced" : " Tree is not balanced");
    }

}
