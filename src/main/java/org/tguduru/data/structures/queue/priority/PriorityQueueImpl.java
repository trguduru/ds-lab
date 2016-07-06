package org.tguduru.data.structures.queue.priority;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 7/5/16.
 */
public class PriorityQueueImpl<K, V> implements PriorityQueue<K, V> {

    class Node

    private int size;
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Entry<K, V> insert(Entry<K, V> entry) {
        return null;
    }

    @Override
    public Entry<K, V> min() {
        return null;
    }

    @Override
    public Entry<K, V> removeMin() {
        return null;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer, String> priorityQueue = new PriorityQueueImpl<>();
        Entry<Integer, String> entry = new EntryImpl<>(1, "First");
    }
}
