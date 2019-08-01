package io.tguduru.ds.lab.queue;

import io.tguduru.ds.lab.linkedlists.Node;

/**
 * Queue implementation using {@link LInkedListQueue}
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 6/19/16.
 */
public class LInkedListQueue implements Queue<Integer> {

    private Node<Integer> root = null;
    private Node<Integer> tail = null;
    private long size = 0;

    @Override
    public void enqueue(Integer element) {
        if (element == null)
            throw new RuntimeException("Cannot add null element");
        Node<Integer> node = new Node<>();
        node.setData(element);
        if (root == null)
            root = tail = node;
        else {
            tail.setNextNode(node);
            tail = node;
        }
        size++;
    }

    @Override
    public Integer dequeue() {
        if (root == null)
            throw new RuntimeException("Queue is empty");
        Node<Integer> temp = root;
        root = root.getNextNode();
        size--;
        return temp.getData();
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Integer first() {
        if (root == null)
            throw new RuntimeException("Queue is empty");
        return root.getData();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Queue{");
        Node<Integer> temp = root;
        while (temp != null) {
            sb.append(temp.getData() + " , ");
            temp = temp.getNextNode();
        }
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        LInkedListQueue queue = new LInkedListQueue();
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(55);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
    }
}
