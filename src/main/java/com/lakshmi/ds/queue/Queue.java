package com.lakshmi.ds.queue;

public class Queue {

    Object[] arr;
    int size;
    int rear = -1;

    public Queue(int size) {
        arr = new Object[size];

        this.size = size;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    // enque
    public void enQueue(Object data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        rear++;
        arr[rear] = data;
    }

    // dequeue
    public Object deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        Object front = arr[0];
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
            arr[i + 1] = null;
        }
        rear--;
        return front;
    }

    // peek
    public Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[0];
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
