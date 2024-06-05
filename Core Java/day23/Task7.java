package day23;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }
}

final class ImmutableData {
    private final int value;

    public ImmutableData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Task7 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 1000; i++) {
            executorService.submit(counter::increment);
            executorService.submit(counter::decrement);
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

        System.out.println("Final count: " + counter.getCount());

        ImmutableData data = new ImmutableData(42);
        System.out.println("Immutable data value: " + data.getValue());
    }
}
