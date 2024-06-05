package day23;

import java.util.LinkedList;
import java.util.Queue;

class SharedResource {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int MAX_SIZE = 5;

    // Synchronized method for producing items
    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == MAX_SIZE) {
            wait(); // Wait until there is space in the queue
        }
        queue.add(value); // Add the produced item to the queue
        System.out.println("Produced: " + value);
        notifyAll(); // Wake up all waiting threads
    }

    // Synchronized method for consuming items
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait until there is an item in the queue
        }
        int value = queue.poll(); // Remove and return the consumed item from the queue
        System.out.println("Consumed: " + value);
        notifyAll(); // Wake up all waiting threads
        return value; // Return the consumed item
    }
}

class Producer implements Runnable {
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource; // Initialize with shared resource
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) { // Produce 10 items
                resource.produce(i); // Produce item and add to the shared resource
                Thread.sleep(100); // Sleep for 100 milliseconds
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle thread interruption
        }
    }
}

class Consumer implements Runnable {
    private final SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource; // Initialize with shared resource
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) { // Consume 10 items
                resource.consume(); // Consume item from the shared resource
                Thread.sleep(150); // Sleep for 150 milliseconds
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle thread interruption
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource(); // Create shared resource
        Thread producerThread = new Thread(new Producer(resource)); // Create producer thread
        Thread consumerThread = new Thread(new Consumer(resource)); // Create consumer thread

        producerThread.start(); // Start producer thread
        consumerThread.start(); // Start consumer thread

        try {
            producerThread.join(); // Wait for producer to finish
            consumerThread.join(); // Wait for consumer to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle thread interruption
        }

        System.out.println("Main thread has finished.");
    }
}

