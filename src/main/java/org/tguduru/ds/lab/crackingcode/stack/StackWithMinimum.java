package org.tguduru.ds.lab.crackingcode.stack;

import java.util.Arrays;

/**
 * Implement a stack with min(),push(),pop() all achieves O(1) time.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/8/16.
 */
public class StackWithMinimum {
    Stack stack[] = new Stack[20];
    int size = 0;

    class Stack {
        int element;
        int minimum;

        public Stack(int element, int minimum) {
            this.element = element;
            this.minimum = minimum;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Stack{");
            sb.append("element=").append(element);
            sb.append(", minimum=").append(minimum);
            sb.append('}');
            return sb.toString();
        }
    }

    public Stack peek() {
        if (size == 0)
            return null;
        else return stack[size - 1];
    }

    public int min() {
        if (size == 0)
            return Integer.MAX_VALUE;
        else return peek().minimum;

    }

    public void push(int element) {
        int m = Math.min(element, min());
        Stack stack = new Stack(element, m);
        this.stack[size] = stack;
        size++;
    }

    public Stack pop() {
        if (size == 0)
            throw new RuntimeException("Stack is empty");
        Stack s = stack[size - 1];
        size--;
        return s;
    }

    public static void main(String[] args) {
        StackWithMinimum stack = new StackWithMinimum();
        stack.push(10);
        stack.push(25);
        stack.push(30);
        stack.push(5);
        Arrays.stream(stack.stack).forEach(System.out::println);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());

    }
}
