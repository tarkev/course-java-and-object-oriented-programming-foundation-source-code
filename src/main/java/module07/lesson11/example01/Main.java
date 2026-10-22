package module07.lesson11.example01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> future = executor.submit(() -> {
            Thread.sleep(1_000);
            return "Done";
        });

        System.out.println("Submitted");
        String result = future.get();
        System.out.println(result);

        executor.shutdown();
    }
}
