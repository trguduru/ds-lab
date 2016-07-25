package org.tguduru.data.structures.queue.priority;

/**
 * An entry which will be inserted into a {@link PriorityQueue}
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 6/28/16.
 */
public interface Entry<K, V> extends Comparable<Entry<K,V>> {
    K getKey();

    V getValue();
}
