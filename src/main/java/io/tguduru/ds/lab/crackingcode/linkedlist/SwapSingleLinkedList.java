package io.tguduru.ds.lab.crackingcode.linkedlist;

import io.tguduru.ds.lab.linkedlists.Node;

/**
 * Swap the nodes with the given position Kth position in a Single Linked List.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/29/16.
 */
public class SwapSingleLinkedList extends LinkedList {

    public static void main(String[] args) {
        SwapSingleLinkedList linkedList = new SwapSingleLinkedList();
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(8);
        linkedList.printList();
        System.out.println("swapping");
        linkedList.swapKthNode(2);
        linkedList.printList();
        System.out.println("swapping again");
        linkedList.swapKthNode(1);
        linkedList.printList();
    }

    public void swapKthNode(int k) {
        if (head == null)
            throw new RuntimeException("List is empty");
        if (k * 2 > size)
            throw new RuntimeException("Invalid position to swap");

        Node<Integer> first = head;
        int n = 1;
        while (n != k) {
            first = first.getNextNode();
            n++;
        }

        Node<Integer> last = head;
        //this is the last Kth element in a list
        int lastPosition = size - k + 1;
        n = 1;
        while (n != lastPosition) {
            last = last.getNextNode();
            n++;
        }
        int temp = first.getData();
        first.setData(last.getData());
        last.setData(temp);
    }
}
