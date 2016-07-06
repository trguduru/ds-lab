package org.tguduru.data.structures.tree;

import org.tguduru.data.structures.linkedlists.Position;

import java.util.Iterator;

/**
 * This implements the balanced BinaryTree.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 6/25/16.
 */
public class BinaryTreeImpl<E> extends AbstractBinaryTree<E> implements BinaryTree<E> {

    private Node<E> root;
    private int size = 0;

    public static void main(String[] args) {
        BinaryTreeImpl<Integer> binaryTree = new BinaryTreeImpl<>();
        System.out.println(binaryTree.isEmpty());
        binaryTree.add(10);
        binaryTree.add(15);
        System.out.println(binaryTree.size());
        binaryTree.print();
    }

    class Node<E> implements Position<E> {
        private Node<E> left;
        private Node<E> right;
        private Node<E> parent;
        private E data;

        public Node(Node<E> left, Node<E> right, Node<E> parent, E data) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.data = data;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        @Override
        public E getElement() {
            return data;
        }
    }

    @Override
    public Position<E> right(Position<E> position) {
        if (position == null)
            throw new RuntimeException("cannot find right node for a given null node");
        Node<E> node = (Node<E>) position;
        return node.getRight();
    }

    @Override
    public Position<E> left(Position<E> position) {
        if (position == null)
            throw new RuntimeException("cannot find left node for a given null node");
        Node<E> node = (Node<E>) position;
        return node.getLeft();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Position<E> parent(Position<E> position) throws IllegalStateException {
        if (position == null)
            throw new RuntimeException("Cannot find parent for null position");
        if (position == root)
            return root;
        Node<E> node = (Node<E>) position;
        return node.getParent();
    }

    @Override
    public Position<E> root() {
        if (root == null)
            throw new RuntimeException("Empty Tree");
        return root;
    }

    @Override
    public void add(E data) {
        if (data == null)
            throw new RuntimeException("Cannot add null element to a tree");
        Node<E> newNode = new Node<>(null, null, null, data);
        size++;
        if (root == null) {
            root = newNode;
            return;
        }
        Node<E> parent = findParentForAdd(root);
        newNode.setParent(parent);
        parent.setLeft(newNode);
    }

    private Node<E> findParentForAdd(Node<E> node) {
        if (node.getLeft() == null)
            return node;
        if(node.getLeft() != null && node.getRight() == null)
            return node;
        else
        return findParentForAdd(node.getLeft());
    }

    private Node<E> findPlace(Node<E> node) {
        if (node.getLeft() == null)
            return node;
        if (node.getRight() == null)
            return node;
        return findPlace(node.getParent());
    }


    @Override
    public Position<E> find(E data) {
        return null;
    }

    public void print() {
        if (root == null)
            System.out.println("Empty Tree");
        Node<E> temp = findParentForAdd(root);
        while (temp != null) {
            System.out.println(temp.getElement() + " \\");
            if (sibling(temp) != null)
                System.out.println("--" + sibling(temp).getElement());
            temp = temp.getParent();
        }
    }
}
