package org.tguduru.data.structures.crackingcode.stack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implementation of set of stacks, each stack has a threshold, if the stack reaches a threshold it will create a new stack.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/8/16.
 */
public class SetOfStacks {
    class Stack<E> {
        Object elements[] = new Object[10];
        int size = 0;

        public void push(E element) {
            if (size == 10)
                throw new RuntimeException("Stack is full");
            elements[size] = element;
            size++;
        }

        public E pop() {
            if (size == 0)
                throw new RuntimeException("Stack is empty");
            Object element = elements[size - 1];
            elements[size - 1] = null;
            size--;
            return (E) element;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Stack{");
            sb.append("elements=").append(Arrays.toString(elements));
            sb.append('}');
            return sb.toString();
        }
    }

    private ArrayList<Stack<Integer>> stacks = new ArrayList<>();

    public void push(Integer element) {
        if (stacks.size() == 0) {
            Stack<Integer> stack = new Stack<>();
            stack.push(element);
            stacks.add(stack);
        } else {
            Stack<Integer> stack = stacks.get(stacks.size() - 1);
            if (stack.size == 10) {
                Stack<Integer> newStack = new Stack<>();
                newStack.push(element);
                stacks.add(newStack);
            } else
                stack.push(element);
        }

    }

    public Integer pop() {
        if (stacks.size() == 0)
            throw new RuntimeException("Stacks are empty");

        Stack<Integer> stack = stacks.get(stacks.size() - 1);
        Integer ele = stack.pop();
        if(stack.size == 0) // after pop if the stack is empty set it to null
            stacks.remove(stacks.size() - 1);

        return ele;
    }

    public Integer pop(int stackIndex) {
        if (stackIndex < 0 || stackIndex > stacks.size())
            throw new RuntimeException("Invalid stack index, should be less than or equals : " + stacks.size());
        Stack<Integer> stack = stacks.get(stackIndex - 1);
        Integer ele = stack.pop();
        if(stack.size == 0) // after pop if the stack is empty set it to null
            stacks.remove(stackIndex - 1);

        return ele;
    }

    public void printStacks() {
        stacks.forEach(System.out::println);
    }

    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks();
        stacks.push(10);
        stacks.push(10);
        stacks.push(10);
        stacks.push(10);
        stacks.push(10);
        stacks.push(10);
        stacks.push(10);
        stacks.push(10);
        stacks.push(10);
        stacks.push(10);
        stacks.push(10);
        stacks.printStacks();
        stacks.pop();
        System.out.println("After pop");
        stacks.printStacks();
        System.out.println("After push");
        stacks.push(11);
        stacks.printStacks();
     //   stacks.pop(10); // throws error
    }
}
