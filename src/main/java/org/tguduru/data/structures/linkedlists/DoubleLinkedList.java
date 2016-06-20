package org.tguduru.data.structures.linkedlists;

/**
 * Double Linked List Implementation
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 6/19/16.
 */
public class DoubleLinkedList {
    class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;

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
            sb.append(", next=").append(next);
            sb.append(", previous=").append(previous);
            sb.append('}');
            return sb.toString();
        }
    }

    private Node<Integer> head;
    private Node<Integer> tail;
    public void addFirst(){

    }
}
