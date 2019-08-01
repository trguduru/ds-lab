package org.tguduru.ds.lab.stack;

import org.tguduru.ds.lab.linkedlists.Node;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 6/16/16.
 */
public class LinkedListStack {
    private Node<Integer> head;

    public void addFirst(Node<Integer> node) {
        if (node == null)
            throw new RuntimeException("Cannot push null element");
        if (head == null) {
            head = node;
            return;
        }
        node.setNextNode(head);
        head = node;
    }

    public Node<Integer> removeFirst(){
        Node<Integer> temp;
        if(head == null){
            throw new RuntimeException("Stack is empty");
        }
        if(head.getNextNode() == null){
            temp = head;
            head = head.getNextNode();
            return temp;
        }
        temp = head.getNextNode();
        head = head.getNextNode();
        return temp;
    }

    public void printStack() {
        if (head == null)
            throw new RuntimeException("Stack is empty");
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " --> ");
            temp = temp.getNextNode();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        Node<Integer> node = new Node<>();
        node.setData(100);
        stack.addFirst(node);
        stack.printStack();

        Node<Integer> node1 = new Node<>();
        node1.setData(200);
        stack.addFirst(node1);
        stack.printStack();

        Node<Integer> node2 = new Node<>();
        node2.setData(50);
        stack.addFirst(node2);
        stack.printStack();

        System.out.println(stack.removeFirst());
        stack.printStack();

        System.out.println(stack.removeFirst());
        stack.printStack();

        System.out.println(stack.removeFirst());
        stack.printStack();
    }
}
