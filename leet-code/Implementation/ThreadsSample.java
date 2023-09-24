package Implementation;

public class ThreadsSample {

    private static int sharedVariable = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1: Acquiring the lock");
                    // Check a condition (e.g., sharedVariable < 5)
                    while (sharedVariable < 5) {
                        System.out.println("Thread 1: Waiting");
                        lock.wait(); // Release the lock and wait
                    }
                    System.out.println("Thread 1: Resumed");
                    // Perform some work
                    sharedVariable++;
                    System.out.println("Thread 1: Incremented sharedVariable to " + sharedVariable);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 2: Acquiring the lock");
                    // Perform some work
                    sharedVariable++;
                    System.out.println("Thread 2: Incremented sharedVariable to " + sharedVariable);
                    // Notify waiting threads
                    lock.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();

        // Adding a delay to allow thread1 to start and enter the waiting state
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        thread2.start();
    }

}
