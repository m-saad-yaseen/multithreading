import java.lang.Runnable;

public class MultiThreading {
    public static void main(String[] args) {
        final Thread thread = new Thread(new Runnable () {
            public void run() {
                System.out.println("I am running in a thread " + Thread.currentThread().getName());
                System.out.println("Thread priority is: " + Thread.currentThread().getPriority());
                throw new RuntimeException("Intentional Exception");
            }
        });
        thread.setName("Misbehaving Thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread.");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread.");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Critical Error");
            }
        });
    }
}
