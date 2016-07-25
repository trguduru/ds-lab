package org.tguduru.data.structures.tree;

/**
 * Implement a simple binary search tree
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 6/27/16.
 */
public class SimpleBinarySearchTree {
    private Node root;
    private int size = 0;

    public static void main(String[] args) {
        SimpleBinarySearchTree tree = new SimpleBinarySearchTree();
        tree.add(new Node(10));
        tree.add(new Node(20));
        tree.add(new Node(5));
        tree.add(new Node(15));
        tree.add(new Node(30));
        tree.add(new Node(9));
        tree.add(new Node(17));
        System.out.println("Pre Order Traversal");
        tree.preOrderTraversal(tree.root);
        System.out.println();
        System.out.println("Post Order Traversal");
        tree.postOrderTraversal(tree.root);
        System.out.println();
        System.out.println("In Order Traversal");
        tree.inOrderTraversal(tree.root);
        System.out.println();
        System.out.println("Searching");
        System.out.println(tree.find(17));
        System.out.println("Deleting 15");
        tree.delete(15);
        tree.inOrderTraversal(tree.root);
        System.out.println();
        System.out.println("Deleting 55, should error out as not found");
        tree.delete(55);

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

    public Node find(Integer ele) {
        if (root == null)
            return null;
        return findNode(root, ele);
    }

    private Node findNode(Node node, Integer ele) {
        if (node == null)
            return null;
        if (node.getData() < ele)
            return findNode(node.getRight(), ele);
        else if (node.getData() > ele)
            return findNode(node.getLeft(), ele);
        else
            return node;
    }

    public void delete(Integer ele) {
        Node node = find(ele);
        if (node == null) {
            System.out.println("Element not found");
            return;
        }
        if (node.getLeft() == null && node.getRight() == null) { // no children
            Node parent = node.getParent();
            if (parent.getLeft() == node) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            node.setParent(null);
        } else {
            Node minNode = findMin(node);
            node.setData(minNode.getData());
            minNode.getParent().setLeft(null);
            minNode.setParent(null);
        }

    }

    private Node findMin(Node node) {
        if (node.getLeft() == null)
            return node;
        else
            return findMin(node.getLeft());
    }

    public void preOrderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.getData() + " --> ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    public void inOrderTraversal(Node node) {
        if (node == null)
            return;
        inOrderTraversal(node.getLeft());
        System.out.print(node.getData() + " --> ");
        inOrderTraversal(node.getRight());
    }

    public void postOrderTraversal(Node node) {
        if (node == null)
            return;
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.print(node.getData() + " --> ");
    }

    static class Node {
        private Integer data;
        private Node left;
        private Node right;
        private Node parent;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("data=").append(data);
            sb.append('}');
            return sb.toString();
        }

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
