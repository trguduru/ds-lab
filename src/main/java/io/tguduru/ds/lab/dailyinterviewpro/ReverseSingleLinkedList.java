package io.tguduru.ds.lab.dailyinterviewpro;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a singly-linked list, reverse the list. This can be done iteratively or recursively. Can you get both solutions?
 * <p>
 * Example:
 * Input: 4 -> 3 -> 2 -> 1 -> 0 -> NULL
 * Output: 0 -> 1 -> 2 -> 3 -> 4 -> NULL
 *
 * @author Guduru, Thirupathi Reddy
 * created 2/27/20
 */
public class ReverseSingleLinkedList {
    static class Node<E> {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("[");
            sb.append(data);
            sb.append("] -> ").append(next);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Node<Long> root = new Node<>(15L);
        Node<Long> tail = root;
        tail = addNode(tail,25L);
        tail = addNode(tail,35L);
        tail = addNode(tail,45L);
        System.out.println(root);

        //optimal solution
        Node<Long> reversedRoot = reverse(root);
        System.out.println(reversedRoot);

        //reverseListUsingStack(linkedList);
    }

    private static Node<Long> addNode(Node<Long> tail, long l) {
        Node<Long> node = new Node<>(l);
        tail.next = node;
        tail = node;
        return tail;
    }


    //using additional data structure - time and space as O(n).
    private static void reverseListUsingStack(LinkedList<Long> linkedList) {
        Stack<Long> stack = new Stack<>();
        while (linkedList.size() != 0) {
            stack.push(linkedList.getFirst());
            linkedList.removeFirst();
        }

        LinkedList<Long> reversedList = new LinkedList<>();
        while (stack.size() != 0) {
            reversedList.add(stack.pop());
        }
        System.out.println(reversedList);
    }

    //time O(n) and space O(1)
    // NOTE: **** This is optimal solution
    private static Node<Long> reverse(Node<Long> node) {
        Node<Long> reversed = null;
        Node<Long> current = node;
        Node<Long> next;
        while (current != null) {
            next = current.next;
            current.next = reversed;
            reversed = current;
            current = next;
        }
        return reversed;
    }
}
