package org.tguduru.ds.lab.crackingcode.linkedlist;

import org.tguduru.ds.lab.linkedlists.Node;

/**
 * Find out whether the linked list has a circular loop or not
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/8/16.
 */
public class CircularLoopList extends LinkedList {
    public Node<Integer> findCircularLoop(Node<Integer> head) {
        if (head == null)
            return null;
        Node<Integer> t1 = head;
        Node<Integer> t2 = head;
        while (t2.getNextNode() != null) {
            t1 = t1.getNextNode();
            t2 = t2.getNextNode().getNextNode();
            if (t1 == t2) {
                break;
            }
        }
        if (t2.getNextNode() == null)
            return null;

        t1 = head;
        while (t1 != t2) {
            t1 = t1.getNextNode();
            t2 = t2.getNextNode();
        }
        return t2;
    }

    public static void main(String[] args) {
        CircularLoopList list = new CircularLoopList();
        Node<Integer> node1 = new Node<>(3);
        Node<Integer> node2 = new Node<>(6);
        Node<Integer> node3 = new Node<>(8);
        Node<Integer> node4 = new Node<>(10);

        list.addNode(node1);
        list.addNode(node2);
        list.addNode(node3);
        list.addNode(node4);
        list.addNode(node2);

        // list.printList(); this will be in a infinite loop

        Node<Integer> loopNode = list.findCircularLoop(list.getHead());
        System.out.println(loopNode.getData());
    }
}
