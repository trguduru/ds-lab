package org.tguduru.ds.lab.queue;

import java.util.Arrays;

/**
 * Queues implementation using arrays.
 * @author Guduru, Thirupathi Reddy
 * @modified 6/19/16.
 */
public class ArrayQueue implements Queue<Integer> {
    private int noOfElements = 3;
    private Integer [] queue = new Integer[noOfElements];
    private int lastIndex = 0;
    @Override
    public void enqueue(Integer element) {
        if(element == null)
            throw new RuntimeException("Cannot add it to queue as element is null");
        if(lastIndex == noOfElements)
            throw new RuntimeException("Queue is full");
        queue[lastIndex] = element;
        lastIndex++;
    }

    @Override
    public Integer dequeue() {
        if(lastIndex == 0)
            throw new RuntimeException("Queue is empty");
        Integer temp = queue[0];
        moveArray();
        lastIndex--;
        return temp;
    }

    private void moveArray() {
        for(int i = 0 ; i <= lastIndex; i++){
            queue[i] = queue[i+1];
        }
    }

    @Override
    public long size() {
        return queue.length;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == 0;
    }

    @Override
    public Integer first() {
        return queue[0];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Queue=").append(Arrays.toString(queue));
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(100);
        System.out.println(queue);
        queue.enqueue(200);
        queue.enqueue(40);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();//throws error as empty queue
    }
}
