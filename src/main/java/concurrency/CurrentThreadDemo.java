package concurrency;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        System.out.println("Testing");
        Thread thread = Thread.currentThread();
        System.out.println(thread);

        thread.setName("Var Thread");
        System.out.println("After name change: " + thread);

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

    }

}
