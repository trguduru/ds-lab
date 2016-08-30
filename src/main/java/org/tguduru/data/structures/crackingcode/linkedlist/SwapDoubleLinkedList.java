package org.tguduru.data.structures.crackingcode.linkedlist;

/**
 * Implements an algorithm to swap the K th element in a given double linked list.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/29/16.
 */
public class SwapDoubleLinkedList {
    private Node<Integer> first;
    private Node<Integer> last;
    private int size;

    public static void main(String[] args) {
        SwapDoubleLinkedList swapDoubleLinkedList = new SwapDoubleLinkedList();
        swapDoubleLinkedList.add(10);
        swapDoubleLinkedList.add(15);
        swapDoubleLinkedList.add(22);
        swapDoubleLinkedList.add(25);
        swapDoubleLinkedList.printList();
        swapDoubleLinkedList.swapKthElement(2);
        System.out.println();
        System.out.println("After swap");
        swapDoubleLinkedList.printList();
        System.out.println();
        swapDoubleLinkedList.swapKthElement(1);
        swapDoubleLinkedList.printList();
    }

    public void add(Integer e) {
        Node<Integer> node = new Node<>(e);
        if (first == null) {
            first = last = node;
        } else {
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }
        size++;
    }

    public void printList() {
        if (first == null)
            throw new RuntimeException("List is empty");
        Node<Integer> temp = first;
        while (temp != null) {
            System.out.print(temp.getData());
            temp = temp.getNext();
            if (temp != null) {
                System.out.print("-->");
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void swapKthElement(int k) {
        if (k * 2 > size)
            throw new RuntimeException("Invalid swap position");
        Node<Integer> firstNthNode = getFirstNthNode(k);
        Node<Integer> lastNthNode = getLastNthNode(k);
        int temp = firstNthNode.getData();
        firstNthNode.setData(lastNthNode.getData());
        lastNthNode.setData(temp);
    }

    private Node<Integer> getLastNthNode(int k) {
        if (last == null)
            throw new RuntimeException("Last node is null");

        //starting the first element.
        int n = 1;
        Node<Integer> temp = last;
        while (n != k) {
            temp = temp.getPrevious();
            n++;
        }
        return temp;
    }

    private Node<Integer> getFirstNthNode(int k) {
        if (first == null)
            throw new RuntimeException("First node is null");
        int n = 1;
        Node<Integer> temp = first;
        while (n != k) {
            temp = temp.getNext();
            n++;
        }
        return temp;
    }
}
