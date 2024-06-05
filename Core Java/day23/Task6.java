package day23;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class PrimeCalculator implements Runnable {
    private final int start;
    private final int end;
    private final List<Integer> primes;

    public PrimeCalculator(int start, int end, List<Integer> primes) {
        this.start = start;
        this.end = end;
        this.primes = primes;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                synchronized (primes) {
                    primes.add(i);
                }
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

public class Task6 {
    public static void main(String[] args) {
        int maxNumber = 100000;
        int poolSize = 4;
        List<Integer> primes = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        int range = maxNumber / poolSize;
        for (int i = 0; i < poolSize; i++) {
            int start = i * range + 1;
            int end = (i == poolSize - 1) ? maxNumber : start + range - 1;
            executorService.submit(new PrimeCalculator(start, end, primes));
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

        CompletableFuture.runAsync(() -> writeToFile(primes))
                .thenRun(() -> System.out.println("Prime numbers written to file."));
    }

    private static void writeToFile(List<Integer> primes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("primes.txt"))) {
            for (int prime : primes) {
                writer.write(prime + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
