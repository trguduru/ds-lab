package io.tguduru.ds.lab.queue;

import java.util.Arrays;

/**
 * Implements Queue using an array in a circular fashion. Instead of moving the array we can just move the queue first index pointer.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 6/19/16.
 */
public class CircularArrayQueue implements Queue<Integer> {
    private int noOfElements = 3;
    private Integer[] queue = new Integer[noOfElements];
    private int firstIndex = 0;
    private int size = 0;

    @Override
    public void enqueue(Integer element) {
        if (element == null)
            throw new RuntimeException("Cannot add");
        if (size == noOfElements)
            throw new RuntimeException("Queue is full");

        int lastIndex = (firstIndex + size) % noOfElements;
        queue[lastIndex] = element;
        size++;
    }

    @Override
    public Integer dequeue() {
        Integer temp = queue[firstIndex];
        queue[firstIndex] = null;
        firstIndex = (firstIndex + 1) % noOfElements;
        size--;
        return temp;
    }

    @Override
    public long size() {
        return queue.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Integer first() {
        return queue[firstIndex];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("queue=").append(Arrays.toString(queue));
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularArrayQueue queue = new CircularArrayQueue();
        queue.enqueue(10);
        queue.enqueue(30);
        queue.enqueue(15);
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(20);
        System.out.println(queue);
        System.out.println("First: " + queue.first()); // should return 15
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(33);
        System.out.println(queue);
        System.out.println("First: " + queue.first());

    }
}
