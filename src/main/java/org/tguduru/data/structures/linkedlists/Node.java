package org.tguduru.data.structures.linkedlists;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 6/19/16.
 */
public class Node<E> {
    private E data;
    private Node<E> nextNode;

    public Node() {
    }

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("data=").append(data);
        sb.append(", nextNode=").append(nextNode);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;

        if (!data.equals(node.data)) return false;
        return nextNode.equals(node.nextNode);

    }

    @Override
    public int hashCode() {
        int result = data.hashCode();
        result = 31 * result + nextNode.hashCode();
        return result;
    }
}
