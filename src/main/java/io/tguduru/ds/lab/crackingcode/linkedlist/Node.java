package io.tguduru.ds.lab.crackingcode.linkedlist;

/**
 * A {@link Node} represents the double linked list
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/29/16.
 */
public class Node<E> {
    E data;
    Node<E> next;
    Node<E> previous;

    public Node(E data) {
        this.data = data;
        next = null;
        previous = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
