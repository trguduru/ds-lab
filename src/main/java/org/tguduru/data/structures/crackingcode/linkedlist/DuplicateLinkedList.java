package org.tguduru.data.structures.crackingcode.linkedlist;

import org.tguduru.data.structures.linkedlists.Node;

import java.util.Hashtable;

/**
 * Remove duplicates from a linked list.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/7/16.
 */
public class DuplicateLinkedList extends LinkedList {


    /**
     * this one uses {@link Hashtable} to remove duplicates. Its complexity is O(n) but uses more space.
     */
    public void deleteDuplicatesWithBuffer() {
        if (head == null) return;
        Hashtable<Integer, Boolean> hashtable = new Hashtable<>();
        Node<Integer> previous = null;
        Node<Integer> current = head;
        while (current != null) {
            if (hashtable.containsKey(current.getData())) {
                previous.setNextNode(current.getNextNode());
            } else {
                hashtable.put(current.getData(), true);
                previous = current;
            }
            current = current.getNextNode();
        }
    }

    /**
     * This one don't use any buffer, but it will loop through twice, so the complexity is O(n^2).
     */
    public void deleteDuplicates() {
        if (head == null)
            throw new RuntimeException("List is empty");
        Node<Integer> previous = head;
        Node<Integer> current = previous.getNextNode();
        while (current != null) {
            Node<Integer> temp = head;
            while (temp != current) { //skips if its the current and node is same
                if (temp.getData() == current.getData()) {
                    previous.setNextNode(current.getNextNode());
                    current = current.getNextNode();
                    break;
                }
                temp = temp.getNextNode();
            }
            if (temp == current) { // move the node pointer
                previous = current;
                current = current.getNextNode();
            }
        }
    }


    public static void main(String[] args) {
        DuplicateLinkedList linkedList = new DuplicateLinkedList();
        Node<Integer> node = new Node<>();
        node.setData(7);
        linkedList.addNode(node);
        Node<Integer> node1 = new Node<>();
        node1.setData(3);
        linkedList.addNode(node1);
        Node<Integer> node2 = new Node<>();
        node2.setData(5);
        linkedList.addNode(node2);
        Node<Integer> node3 = new Node<>();
        node3.setData(3);
        linkedList.addNode(node3);
        Node<Integer> node4 = new Node<>();
        node4.setData(7);
        linkedList.addNode(node4);
        Node<Integer> node5 = new Node<>();
        node5.setData(9);
        linkedList.addNode(node5);
        Node<Integer> node6 = new Node<>();
        node6.setData(5);
        linkedList.addNode(node6);
        linkedList.printList();
        linkedList.deleteDuplicatesWithBuffer();
        System.out.println("Deleted duplicates with buffer");
        linkedList.printList();
        System.out.println("Added some more");
        Node<Integer> node7 = new Node<>();
        node7.setData(5);
        linkedList.addNode(node7);
        linkedList.printList();
        linkedList.deleteDuplicates();
        System.out.println("Deleted duplicates without buffer");
        linkedList.printList();
    }
}
