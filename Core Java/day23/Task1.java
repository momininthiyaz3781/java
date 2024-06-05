package day23;

 
class NumberPrinter implements Runnable{
	private final String threadName;
	public NumberPrinter(String threadName) {
		this.threadName=threadName;
	}
	@Override
public void run() {
		try {
			for(int i=1;i<=10;i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println(threadName+"was interrupted");
		}
	}
}
public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Thread thread1 =new Thread(new NumberPrinter("Thread 1"));
Thread thread2 = new Thread(new NumberPrinter("Thread 2"));
thread1.start();
thread2.start();
	}

}