package module08.lesson02.example01;

public class Main {

    public static void main(String[] args) {
        publishCourse();
        System.out.println("Course published.");
    }

    static void publishCourse() {
        validateCourse();
        System.out.println("Course validated.");
    }

    static void validateCourse() {
        throw new IllegalStateException("Course has no lessons.");
    }
}
