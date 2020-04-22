package io.tguduru.ds.lab.queue;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 6/19/16.
 */
public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    long size();
    boolean isEmpty();
    E first();
}
