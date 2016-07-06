package org.tguduru.data.structures.tree;

/**
 * Implement a simple binary tree
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 6/27/16.
 */
public class SimpleBinaryTree {
    private Node root;
    private int size = 0;

    public static void main(String[] args) {
        SimpleBinaryTree tree = new SimpleBinaryTree();
        tree.add(new Node(10));
        tree.add(new Node(20));
        tree.add(new Node(5));
        tree.add(new Node(15));
        tree.add(new Node(30));
        tree.add(new Node(9));
        tree.add(new Node(17));
        tree.print();
    }

    public void add(Node node) {
        if (node == null)
            throw new RuntimeException("Cannot add null node");
        if (root == null) {
            root = node;
            return;
        }
        addNode(root, node);
        size++;
    }

    public int getSize() {
        return size;
    }

    private void addNode(Node parent, Node node) {
        if (node.getData() < parent.getData()) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
                node.setParent(parent);
                return;
            } else
                addNode(parent.getLeft(), node);
        } else {
            if (parent.getRight() == null) {
                parent.setRight(node);
                node.setParent(parent);
                return;
            } else
                addNode(parent.getRight(), node);

        }
    }

    public void print() {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }
        printPreorder(root);
    }

    private void printPreorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.getData() + " --> ");
        printPreorder(node.getLeft());
        printPreorder(node.getRight());
    }

    static class Node {
        private Integer data;
        private Node left;
        private Node right;
        private Node parent;

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node(Integer data) {
            this.data = data;
        }
    }
}
