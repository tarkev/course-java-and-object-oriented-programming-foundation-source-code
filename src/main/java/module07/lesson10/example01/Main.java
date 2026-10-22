package module07.lesson10.example01;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> System.out.println("Worker running"));

        worker.start();
        worker.join();

        System.out.println("Worker finished");
    }
}
