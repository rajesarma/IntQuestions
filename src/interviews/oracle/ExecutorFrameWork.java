package interviews.oracle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFrameWork {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int count = 0;
        Future<?> submits = null;
        for (int i = 0; i < 100; i++) {
            final int index = i;
            submits = executorService.submit(() -> System.out.println(index));
            count++;
//            if (count == 100) {
//            while (executorService.awaitTermination(1, TimeUnit.NANOSECONDS));
//                executorService.shutdown();
        }

        /*for (Future s: submits ) {

        }*/

//        submits.isDone()


//        if (executorService) {
            System.out.println("Hello World!!");
//        }
    }
}
