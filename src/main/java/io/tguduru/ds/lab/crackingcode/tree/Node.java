package io.tguduru.ds.lab.crackingcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 7/17/16.
 */
public class Node<E> {
    E element;
    Node<E> left;
    Node<E> right;
    Node<E> parent;

    public Node(E element) {
        this.element = element;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public List<Node<E>> getChildren() {
        List<Node<E>> nodes = new ArrayList<>();
        if (left != null) nodes.add(left);
        if (right != null) nodes.add(right);
        return nodes;
    }
}
