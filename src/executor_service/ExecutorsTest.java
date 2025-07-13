package executor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorsTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<>();
        int num = 10;
        for (int i = 0; i < num; i++) {
            Future<Integer> submit = service.submit(new Task());
            futures.add(submit);
        }

        for (Future<Integer> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        boolean allDone = true;
        for(Future<Integer> future : futures){
            allDone &= future.isDone(); // check if future is done
        }

        if (allDone) {
            System.out.println("All tasks submitted.");
        }


        /*int futureCount = 0;
        while (futureCount < num) {
            for (Future<Integer> future : futures) {
                if (future.isDone()){
                    futureCount++;
                }
            }
        }
        if (futureCount == num){
            service.shutdown();
        }
        System.out.println("All tasks submitted.");
        */
    }

    private static class Task implements Callable<Integer> {
        @Override
        public Integer call() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            return new Random().nextInt();
        }
    }
}
