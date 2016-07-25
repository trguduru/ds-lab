package org.tguduru.data.structures.crackingcode.linkedlist;

import org.tguduru.data.structures.linkedlists.Node;

/**
 * Finds the nth to last element in a given linked list.
 * @author Guduru, Thirupathi Reddy
 * @modified 7/7/16.
 */
public class FindNToLastLinkedList extends LinkedList {

    public Node<Integer> findNthToLast(int n){
        if( head == null || n <1)
            return null;
        Node<Integer> p1 = head;
        Node<Integer> p2 = head;
        for(int i = 0 ; i < n-1; i++){
            if(p2.getNextNode() == null)
                return null;
            p2 = p2.getNextNode();
        }
        while(p2.getNextNode() != null){
            p1 = p1.getNextNode();
            p2 = p2.getNextNode();
        }
        return p1;
    }


    public static void main(String[] args) {
        FindNToLastLinkedList linkedList = new FindNToLastLinkedList();
        Node<Integer> node1 = new Node<>();
        node1.setData(3);
        linkedList.addNode(node1);

        Node<Integer> node2 = new Node<>();
        node2.setData(4);
        linkedList.addNode(node2);

        Node<Integer> node3 = new Node<>();
        node3.setData(5);
        linkedList.addNode(node3);

        Node<Integer> node4 = new Node<>();
        node4.setData(7);
        linkedList.addNode(node4);

        linkedList.printList();
        Node<Integer> nth = linkedList.findNthToLast(2);
        System.out.println(nth.getData());
    }
}
