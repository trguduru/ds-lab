package org.tguduru.ds.lab.queue.priority;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 7/5/16.
 */
public class PriorityQueueImpl<K, V> implements PriorityQueue<K, V> {

    class Node {
        Entry<K, V> entry;
        Node previous;
        Node next;

        public Entry<K, V> getEntry() {
            return entry;
        }

        public void setEntry(Entry<K, V> entry) {
            this.entry = entry;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private int size;
    private Node first;
    private Node last;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Entry<K, V> insert(Entry<K, V> entry) {
        if(entry == null)
            throw new RuntimeException("Cannot add null element");
        addEntry(entry);
        return entry;
    }

    private void addEntry(Entry<K, V> entry) {
        if(first == null) {
            first = new Node();
            first.setEntry(entry);
            return;
        }
        Node temp = first;
        while(temp.getNext() != null){
            int result = temp.getEntry().compareTo(entry);
            if(result == 0){
                Node node = new Node();
                node.setEntry(entry);
                Node next = first.getNext();
                if(next == null) {
                    first.setNext(node);
                    node.setPrevious(first);
                }
                else{
                    first.setNext(node);
                    node.setNext(next);
                    node.setPrevious(first);
                    next.setPrevious(node);
                }

            }

        }
    }

    @Override
    public Entry<K, V> first() {
        return first.getEntry();
    }

    @Override
    public Entry<K, V> removeFirst() {
        if(first == null)
            throw new RuntimeException("Queue is empty");
        Entry<K,V> firstEntry = first.getEntry();
        first = first.getNext();
        first.setPrevious(null);
        return firstEntry;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer, String> priorityQueue = new PriorityQueueImpl<>();
        Entry<Integer, String> entry = new EntryImpl<>(1, "First");
    }
}
