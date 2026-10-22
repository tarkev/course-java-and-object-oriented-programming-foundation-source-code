package module08.lesson02.example02.course;

public class Main {

    public static void main(String[] args) {
        Course course = new Course("Java and OOP Foundation");

        course.submitForReview();

        System.out.println("Course submitted.");
    }
}
