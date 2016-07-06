package org.tguduru.data.structures.queue.priority;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 7/5/16.
 */
public class EntryImpl<K, V> implements Entry<K, V> {
    K key;
    V value;

    public EntryImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
