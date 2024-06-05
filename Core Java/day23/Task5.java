package day23;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ComplexTask implements Runnable {
    private final int taskId;

    public ComplexTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
        performComplexCalculation();
        System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
    }

    private void performComplexCalculation() {
        long sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += Math.sqrt(i);
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        int poolSize = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);

        for (int i = 1; i <= 10; i++) {
            executorService.submit(new ComplexTask(i));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks submitted.");
    }
}
