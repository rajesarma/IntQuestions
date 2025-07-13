package com.lakshmi.ds.queue;

public class PriorityQueue {
    PriorityNode node;

    public PriorityNode newPriorityNode(int d, int p) {
        PriorityNode temp = new PriorityNode();
        temp.data = d;
        temp.priority = p;
        temp.next = null;
        return temp;
    }

    // Return the value at head
    public int peek(PriorityNode head) {
        return head.data;
    }

    // Removes the element with the highest priority from the list
    public PriorityNode pop(PriorityNode head) {
        head = head.next;
        return head;
    }

    // Function to push according to priority
    public PriorityNode push(PriorityNode head, int d, int p) {
        PriorityNode start = head;
        PriorityNode temp = newPriorityNode(d, p);

        // Special Case: The head of list has lesser priority than new PriorityNode. 
        // So insert new PriorityNode before head PriorityNode and change head PriorityNode.
        if (head.priority < p) {
            temp.next = head;
            head = temp;
        } else {
            // Traverse the list and find a position to insert new PriorityNode
            while (start.next != null && start.next.priority > p) {
                start = start.next;
            }

            // Either at the ends of the list or at required position
            temp.next = start.next;
            start.next = temp;
        }
        return head;
    }

    // Function to check is list is empty
    public int isEmpty(PriorityNode head) {
        return (head == null) ? 1 : 0;
    }

    public static void main(String[] args) {
        // Create a Priority Queue
        // 7.4.5.6
        PriorityQueue priorityQueue = new PriorityQueue();

        PriorityNode pq = priorityQueue.newPriorityNode(4, 1);
        pq = priorityQueue.push(pq, 5, 2);
        pq = priorityQueue.push(pq, 6, 3);
        pq = priorityQueue.push(pq, 7, 0);

        while (priorityQueue.isEmpty(pq) == 0) {
            System.out.printf("%d ", priorityQueue.peek(pq));
            pq = priorityQueue.pop(pq);
        }
    }
}