package ds.producerconsumer;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
    private final int MAX_CAPACITY;
    Queue<Integer> queue = new LinkedList<>();
    ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int MAX_CAPACITY){
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    public int put(int num) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == MAX_CAPACITY) {
                System.out.println("produce: await adding, count is max");
                notFull.await();
            }
            System.out.println("added data ! " + num);
            queue.add(num);
//            notFull.signal();
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
        return 0;
    }

    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                System.out.println("consume: await removing, count is 0");
                notEmpty.await();
            }
            System.out.println("removed data ! " + queue.poll());
//            notEmpty.signal();
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
        return 0;
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        final MyBlockingQueue queue = new MyBlockingQueue(n);
        List<Callable<Integer>> callableList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = new Random().nextInt(n * n);
            if (num % 2 == 0) {
                callableList.add(() -> queue.put(num));
            } else {
                callableList.add(queue::take);
            }
        }
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = executorService.invokeAll(callableList);
        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);
    }


    /*private void addData(int num) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("An interruption occurred at Producer");
        }
        System.out.println("added data ! " + queue.offer(num));
        count += 1;
    }

    private void removeData() {
        System.out.println("removed data ! " + queue.poll());
        count -= 1;
    }*/
}
