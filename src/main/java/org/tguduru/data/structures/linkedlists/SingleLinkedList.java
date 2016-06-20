package org.tguduru.data.structures.linkedlists;

/**
 * Example of single linked list
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 6/6/16.
 */
public class SingleLinkedList {

    private Node rootNode;

    public SingleLinkedList() {
        rootNode = null;
    }

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addNode(100);
        linkedList.printList();
        System.out.println();
        linkedList.addNode(200);
        linkedList.printList();
    }

    public void addNode(long value) {
        if (value == 0)
            throw new RuntimeException("Cannot insert 0 as value");
        if (rootNode == null) {
            rootNode = new Node();
            rootNode.setData(value);
        } else {
            Node temp = rootNode.getNextNode();
            while (temp != null && temp.getNextNode() != null) {
                temp = temp.getNextNode();
            }
            Node node = new Node();
            node.setData(value);
            if (temp != null)
                temp.setNextNode(node);
            else rootNode.setNextNode(node);
        }
    }

    public void printList() {
        if (rootNode == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = rootNode;
        while (temp != null) {
            System.out.print(temp.getData() + " --> ");
            temp = temp.getNextNode();
        }
    }

}
