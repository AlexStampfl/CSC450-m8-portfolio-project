public class myThreads extends Thread {

    private String task;

    // Constructor
    public myThreads(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        if (task.equalsIgnoreCase("countUp")) {
            countUp();
        } else if (task.equalsIgnoreCase("countDown")) {
            countDown();
        }
    }
    
    void countUp() {
        System.out.println("\nThread 1 has started: ");
        for (int i = 0; i <= 20; i++) {
            System.out.println("CountUp: " + i);
        }
        System.out.println("Thread 1 has ended. \n");
    }

    void countDown() {
        System.out.println("Thread 2 has started: ");
        for (int i = 20; i >= 0; i--) {
            System.out.println("CountDown: " + i);
        }
        System.out.println("Thread 2 has ended. ");
    }

    public static void main(String[] args) {

        // Create threads
        myThreads t1 = new myThreads("countUp");
        myThreads t2 = new myThreads("countDown");

        t1.start();
        try {
            t1.join(); // Waits for the thread to terminate
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // countDown();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n-- Threads have finished execution --");

    }
}