package org.tguduru.ds.lab.linkedlists;

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
            sb.append('}');
            return sb.toString();
        }
    }

    private Node<Integer> head;
    private Node<Integer> tail;
    private long size = 0;

    public void addFirst(Integer data) {
        if (data == null)
            throw new RuntimeException("Cannot add null element");
        Node<Integer> node = new Node<>();
        node.setData(data);
        if (head == null)
            head = tail = node;
        else {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
        size++;
    }

    public Integer removeFirst() {
        Integer tempData;
        if (head == null) {
            throw new RuntimeException("LinkedList is empty");
        }
        size--;
        if (head.getNext() == null) {
            tempData = head.getData();
            head = null;
            return tempData;
        }
        Node<Integer> temp = head.getNext();
        temp.setPrevious(null);
        tempData = head.getData();
        head = temp;
        return tempData;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DoubleLinkedList{");
        sb.append("head=").append(head);
        sb.append(", tail=").append(tail);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(100);
        doubleLinkedList.addFirst(300);
        doubleLinkedList.addFirst(150);
        System.out.println(doubleLinkedList);
        doubleLinkedList.removeFirst();
        System.out.println(doubleLinkedList);
    }
}
