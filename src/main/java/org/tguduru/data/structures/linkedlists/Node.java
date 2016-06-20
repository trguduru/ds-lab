package org.tguduru.data.structures.linkedlists;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 6/19/16.
 */
public class Node<E> {
    private E data;
    private Node nextNode;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
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
}
