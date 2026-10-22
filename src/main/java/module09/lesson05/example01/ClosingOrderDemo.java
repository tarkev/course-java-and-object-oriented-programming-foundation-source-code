package module09.lesson05.example01;

public class ClosingOrderDemo {

    public static void main(String[] args) {
        try (DemoResource first = new DemoResource("A");
                DemoResource second = new DemoResource("B");
                DemoResource third = new DemoResource("C")) {
            System.out.println("Use resources");
            throw new IllegalStateException("Processing failed");
        } catch (IllegalStateException exception) {
            System.out.println("Catch: " + exception.getMessage());
        } finally {
            System.out.println("Finally");
        }
    }
}
