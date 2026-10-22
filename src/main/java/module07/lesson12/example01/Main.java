package module07.lesson12.example01;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread worker = Thread.ofVirtual()
                .name("course-worker")
                .start(() -> System.out.println("Loading courses"));

        worker.join();
        System.out.println(worker.getName() + " virtual: " + worker.isVirtual());
    }
}
