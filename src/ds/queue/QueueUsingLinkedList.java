package ds.queue;

public class QueueUsingLinkedList {
    Node head = null;
    Node tail = null;

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    // enque
    public void enQueue(Object data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // dequeue
    public Object deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        Object front = head.data;
        if (head == tail) {
            head = tail = null;
        }
        head = head.next;
        return front;
    }

    // peek
    public Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return head.data;
    }

    public int size() {
        int count = 0;
        Node n = head;
        while (n.next != null) {
            n = n.next;
            count++;
        }
        return count;
    }

    public void show() {
        Node n = head;
        while (n.next != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    static class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }
    }
}
