package org.tguduru.ds.lab.crackingcode.queue;

import java.util.Stack;

/**
 * Implement a Queue using two Stacks.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/9/16.
 */
public class QueueUsingStacks {
    Stack<Integer> s1, s2;

    public QueueUsingStacks()
    {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(Integer ele) {
        s1.push(ele);
    }

    public Integer dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else
            return s2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        queue.enqueue(8);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
