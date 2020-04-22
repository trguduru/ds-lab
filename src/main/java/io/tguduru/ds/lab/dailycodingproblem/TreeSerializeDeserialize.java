package io.tguduru.ds.lab.dailycodingproblem;

/**
 * This problem was asked by Google.
 * <p>
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserialize the string back into the tree.
 * <p>
 * For example, given the following Node class
 * <p>
 * class Node:
 * def __init__(self, val, left=None, right=None):
 * self.val = val
 * self.left = left
 * self.right = right
 * <p>
 * The following test should pass:
 * <p>
 * node = Node('root', Node('left', Node('left.left')), Node('right'))
 * assert deserialize(serialize(node)).left.left.val == 'left.left'
 *
 * @author Guduru, Thirupathi Reddy
 * created 9/16/19
 */
public class TreeSerializeDeserialize {

    Node root;

    private String nodeString = "Node";


    static class Node {
        long value;
        Node left;
        Node right;

        public long getValue() {
            return value;
        }

        public Node setValue(long value) {
            this.value = value;
            return this;
        }

        public Node getLeft() {
            return left;
        }

        public Node setLeft(Node left) {
            this.left = left;
            return this;
        }

        public Node getRight() {
            return right;
        }

        public Node setRight(Node right) {
            this.right = right;
            return this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("value=").append(value);
            sb.append(", left=").append(left);
            sb.append(", right=").append(right);
            sb.append('}');
            return sb.toString();
        }
    }

    public void addNode(long value) {
        Node n = new Node();
        n.setValue(value);
        if (root == null) {
            root = n;
        } else {
            addNodeToTree(root, n);
        }
    }

    private void addNodeToTree(Node node, Node newNode) {
        if (node.getValue() < newNode.getValue()) { //traverse right
            Node temp = node.getRight();
            if (temp == null)
                node.setRight(newNode);
            else
                addNodeToTree(temp, newNode);
        } else { //traverse left
            Node temp = node.getLeft();
            if (temp == null)
                node.setLeft(newNode);
            else
                addNodeToTree(temp, newNode);
        }
    }

    public String serialize(Node n) {
        if (n == null)
            return null;
        StringBuilder s = new StringBuilder(nodeString).append("(");
        s.append("'").append(n.getValue()).append("',");
        buildNodeString(n.getLeft(), s);
        s.append(",");
        buildNodeString(n.getRight(), s);
        s.append(")");
        return s.toString();
    }

    private void buildNodeString(Node n, StringBuilder s) {
        if (n != null) {
            s.append(nodeString).append("(").append("'").append(n.getValue()).append("'");
            if (n.getLeft() != null) {
                s.append(",");
                buildNodeString(n.getLeft(), s);
            } else {
                s.append(",");
            }
            if (n.getRight() != null) {
                s.append(",");
                buildNodeString(n.getRight(), s);
            } else {
                s.append(",");
            }
        }
        s.append(")");

    }

    public Node deserialize(String s) {
        if (s == null)
            return null;
        Node n = new Node();
        int valueStartIndex = s.indexOf("'");
        int valueEndIndex = s.indexOf("'",valueStartIndex+1);

        System.out.println(valueStartIndex);
        System.out.println(valueEndIndex);

        String rootValue = s.substring(valueStartIndex+1,valueEndIndex);
        n.setValue(Long.parseLong(rootValue));
        return n;
    }

    public static void main(String[] args) {
        TreeSerializeDeserialize treeSerializeDeserialize = new TreeSerializeDeserialize();
        treeSerializeDeserialize.addNode(10);
        treeSerializeDeserialize.addNode(15);
        treeSerializeDeserialize.addNode(8);
        treeSerializeDeserialize.addNode(9);
        treeSerializeDeserialize.addNode(13);

        String s = treeSerializeDeserialize.serialize(treeSerializeDeserialize.root);
        System.out.println("Serialized : --- " + s);

        Node n = treeSerializeDeserialize.deserialize(s);
        System.out.println("Deserialized : --- " + n);
    }
}
