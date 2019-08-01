package org.tguduru.ds.lab.crackingcode.stack;

import java.util.Stack;

/**
 * Implement an algorithm to sort a stack in ascending order.
 * @author Guduru, Thirupathi Reddy
 * @modified 7/10/16.
 */
public class SortStack {
    Stack<Integer> s;
    public SortStack(){
        s = new Stack<>();
    }
    public void push(Integer ele){
        s.push(ele);
    }

    public void print(){
        while(!s.isEmpty()){
            System.out.print(s.pop() + "->");
        }
    }
    public void sort(){
        Stack<Integer> buffer = new Stack<>();
        while(!s.isEmpty()){
            Integer temp = s.pop();
            while(!buffer.isEmpty() && buffer.peek() > temp){
                s.push(buffer.pop());
            }
            buffer.push(temp);
        }
        while(!buffer.isEmpty()){ // putting back sorted order on to main stack
            s.push(buffer.pop());
        }
    }

    public static void main(String[] args) {
        SortStack sortStack = new SortStack();
        sortStack.push(10);
        sortStack.push(7);
        sortStack.push(11);
        sortStack.push(23);
        sortStack.sort();
        sortStack.print();
    }
}
