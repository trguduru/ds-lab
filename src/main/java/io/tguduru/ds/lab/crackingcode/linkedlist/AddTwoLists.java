package io.tguduru.ds.lab.crackingcode.linkedlist;

import io.tguduru.ds.lab.linkedlists.Node;

/**
 * Adds Two linked lists
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/8/16.
 */
public class AddTwoLists {


    public static Node<Integer> addTwoLists(Node<Integer> l1, Node<Integer> l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return null;
        Node<Integer> result = new Node<>(carry);
        int value = carry;
        if (l1 != null)
            value += l1.getData();
        if (l2 != null)
            value += l2.getData();
        result.setData(value % 10);
        Node<Integer> temp = addTwoLists(l1 == null ? null : l1.getNextNode(), l2 == null ? null : l2.getNextNode(), value >= 10 ? 1 : 0);
        result.setNextNode(temp);
        return result;
    }

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        Node<Integer> node1 = new Node<>(4);
        Node<Integer> node2 = new Node<>(5);
        Node<Integer> node3 = new Node<>(6);
        Node<Integer> node4 = new Node<>(7);
        linkedList1.addNode(node1);
        linkedList1.addNode(node2);
        linkedList1.addNode(node3);
        linkedList1.addNode(node4);

        LinkedList linkedList2 = new LinkedList();
        Node<Integer> node21 = new Node<>(4);
        Node<Integer> node22 = new Node<>(5);
        Node<Integer> node23 = new Node<>(6);
        Node<Integer> node24 = new Node<>(6);
        linkedList2.addNode(node21);
        linkedList2.addNode(node22);
        linkedList2.addNode(node23);
        linkedList2.addNode(node24);

        Node<Integer> result = addTwoLists(linkedList1.getHead(),linkedList2.getHead(),0);
        Node<Integer> temp = result;
        while(temp != null){
            System.out.print(temp.getData());
            temp = temp.getNextNode();
            if(temp != null)
                System.out.print("-->");
        }
    }
}
