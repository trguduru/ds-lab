package org.tguduru.data.structures.crackingcode.linkedlist;

import org.tguduru.data.structures.linkedlists.Node;

/**
 * Deletes a node in a linked list, only that node has given
 * @author Guduru, Thirupathi Reddy
 * @modified 7/8/16.
 */
public class DeleteNodeLinkedList extends LinkedList {
    public void deleteANode(Node<Integer> node){
        if(node == null)
            return;
        Node<Integer> next = node.getNextNode();
        if(next == null)
            throw new RuntimeException("cannot delete a node");
        node.setData(next.getData());
        node.setNextNode(next.getNextNode());
    }

    public static void main(String[] args) {
        DeleteNodeLinkedList linkedList = new DeleteNodeLinkedList();
        Node<Integer> node1 = new Node<>(4);
        Node<Integer> node2 = new Node<>(3);
        Node<Integer> node3 = new Node<>(5);
        Node<Integer> node4 = new Node<>(8);

        linkedList.addNode(node1);
        linkedList.addNode(node2);
        linkedList.addNode(node3);
        linkedList.addNode(node4);

        linkedList.printList();

        linkedList.deleteANode(node2);
        linkedList.printList();
        linkedList.deleteANode(node4);
linkedList.printList();
    }

}
