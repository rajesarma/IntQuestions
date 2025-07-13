package ds.queue;

public class CircularQueue {

    Object[] arr;
    int size;
    int rear = -1;
    int front = -1;

    public CircularQueue(int size) {
        arr = new Object[size];
        this.size = size;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return front == (rear + 1) % size;
    }

    // enque
    public void enQueue(Object data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    // dequeue
    public Object deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        Object data = arr[front];
        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % size;
        }

        return data;
    }

    // peek
    public Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
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
