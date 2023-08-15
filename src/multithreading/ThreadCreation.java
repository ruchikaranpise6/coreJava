package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCreation {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable runnable = () -> System.out.println("Runnable running");
        executorService.submit(runnable);

        Thread t1 = new Thread(() -> System.out.println("Thread running"));
        executorService.submit(t1);

        CompletableFuture.runAsync(() -> {
            System.out.println("Complete future");
        }, executorService);

        executorService.shutdown();
    }
}
