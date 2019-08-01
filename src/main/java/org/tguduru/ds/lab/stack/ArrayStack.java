package org.tguduru.ds.lab.stack;

/**
 * Implementation of stack using arrays.
 * <p>
 * Its fixed in size so if the stack grows we need to create a new array and copy stack on to it.
 * Java {@link java.util.Stack} implementation does the same thing. It uses {@link java.util.Vector} under the hood.
 * To avoid the growth problem use the {@link java.util.LinkedList} data structure to build the stack. See {@link LinkedListStack} for implementation.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 6/16/16.
 */
public class ArrayStack<E> {
    private int size = 0;
    private Object[] stack;

    public ArrayStack() {
        stack = new Object[50];
    }

    public void push(E element) {
        if (element == null)
            throw new RuntimeException("Cannot push null element onto a stack");
        stack[size] = element;
        size++;
    }

    public E pop() {
        if (size == 0)
            throw new RuntimeException("Empty Stack, cannot pop");
        E element = (E) stack[size - 1];
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(100);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Stack Empty:" + stack.isEmpty());
        // System.out.println(stack.pop()); , will throw Exception
        stack.push(200);
        stack.push(300);
        stack.push(400);
        System.out.println(stack.pop());
        stack.push(null); // will throw error
    }
}
