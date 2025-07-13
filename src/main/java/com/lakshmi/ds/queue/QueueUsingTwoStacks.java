package com.lakshmi.ds.queue;

import java.util.Stack;

public class QueueUsingTwoStacks {
    Stack<Object> s1 = new Stack<>();
    Stack<Object> s2 = new Stack<>();

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    // enque
    public void enQueue(Object data) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(data);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // dequeue
    public Object deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return s1.pop();

    }

    // peek
    public Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return s1.pop();
    }

    public int size() {
        return s1.size();
    }

    public void show() {
        printStack(s1);
    }

    public static void printStack(Stack<Object> s) {
        if (s.isEmpty()) {
            return;
        }
        Object x = s.peek();
        // Pop the top element
        s.pop();

        System.out.print(x + " "); // Print the current top of the stack i.e., x
        printStack(s); // Proceed to print remaining stack
        s.push(x); // Push the element back
        System.out.println();
    }
}
