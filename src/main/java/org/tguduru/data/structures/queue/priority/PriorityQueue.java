package org.tguduru.data.structures.queue.priority;

/**
 * Implements a Queue using Priority.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 6/28/16.
 */
public interface PriorityQueue<K, V> {
    int size();

    boolean isEmpty();

    Entry<K, V> insert(Entry<K, V> entry);

    Entry<K, V> min();

    Entry<K, V> removeMin();
}
