package day23; 
class ThreadLifecycle implements Runnable {
    private final Object monitor = new Object();

    @Override
    public void run() {
        try {
            System.out.println("State: RUNNABLE");

            // Simulate RUNNABLE state
            System.out.println("Thread is running...");

            // Simulate TIMED_WAITING state using sleep
            System.out.println("State: TIMED_WAITING (sleep)");
            Thread.sleep(1000);

            // Simulate WAITING state using wait
            synchronized (monitor) {
                System.out.println("State: WAITING (wait)");
                monitor.wait();
            }

            // Simulate BLOCKED state
            synchronized (monitor) {
                System.out.println("State: BLOCKED (trying to enter synchronized block)");
                // This block simulates a blocked state when another thread holds the monitor
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted.");
        }

        System.out.println("State: TERMINATED");
    }

    public void notifyThread() {
        synchronized (monitor) {
            monitor.notify();
        }
    }
public class Task2{
    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycle runnableInstance = new ThreadLifecycle();
        Thread thread = new Thread(runnableInstance);

        System.out.println("State: NEW");

        thread.start();

        Thread.sleep(500); // Give the thread time to enter WAITING state

        System.out.println("Notifying the thread to wake up from WAITING state...");
        runnableInstance.notifyThread();

        thread.join(); // Wait for the thread to terminate
        System.out.println("Main thread has finished.");
    }
}
}