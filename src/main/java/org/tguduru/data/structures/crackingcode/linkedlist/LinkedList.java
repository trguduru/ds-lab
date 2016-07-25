package org.tguduru.data.structures.crackingcode.linkedlist;

import org.tguduru.data.structures.linkedlists.Node;

/**
 * Base class for all linked list problems.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/8/16.
 */
public class LinkedList {
    protected Node<Integer> head;


    public void addNode(Node<Integer> node) {
        if (head == null) {
            head = node;
            return;
        }
        Node<Integer> temp = head;
        while (temp.getNextNode() != null) {
            temp = temp.getNextNode();
        }
        temp.setNextNode(node);
    }


    public void printList() {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.getData());
            temp = temp.getNextNode();
            if (temp != null)
                System.out.print("-->");
        }
        System.out.println();
    }

    public Node<Integer> getHead() {
        return head;
    }
}
