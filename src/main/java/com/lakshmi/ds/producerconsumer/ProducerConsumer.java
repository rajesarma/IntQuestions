package com.lakshmi.ds.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    static class Producer extends Thread {
        protected BlockingQueue<Integer> queue;
        protected int capacity;

        Producer(BlockingQueue<Integer> queue, int capacity) { // constructor
            this.queue = queue;
            this.capacity = capacity;
        }
        public void run() { // overriding run method
            while (true) {
                for(int i = 1; i <= capacity; i++) {
                    try {
                        System.out.println("Producer is running " + i);
                        queue.put(i); // to produce data
                        // produce data with an interval of 1 sec
                        Thread.sleep(1000);
                    }
                    // to handle exception
                    catch (InterruptedException exp) {
                        System.out.println("An interruption occurred at Producer");
                    }
                }
            }
        }
    }

    static class Consumer extends Thread {
        protected BlockingQueue<Integer> queue;
        Consumer(BlockingQueue<Integer> queue) { // constructor
            this.queue = queue;
        }
        public void run() { // overriding run method
            try {
                while (true) {
                    Integer elem = queue.take(); // to consume data
                    System.out.println("Consumer is running " + elem);
                }
            }
            // to handle exception
            catch (InterruptedException exp) {
                System.out.println("An interruption occurred at Producer");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        // passing object of BlockingQueue as arguments
        Producer threadProd = new Producer(queue, 4);
        Consumer threadCon = new Consumer(queue);

        // to start the process
        threadProd.start();
        threadCon.start();

        // to exit the process after 5 sec
        Thread.sleep(5000);
        System.exit(0);
    }
}
