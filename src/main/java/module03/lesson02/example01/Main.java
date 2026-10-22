package module03.lesson02.example01;

public class Main {

    public static void main(String[] args) {
        Enrollment enrollment = new Enrollment();
        enrollment.learnerName = "Nur";
        enrollment.courseTitle = "Java and OOP Foundation";
        enrollment.completedLessons = 16;
        enrollment.totalLessons = 20;

        System.out.println("Learner: " + enrollment.learnerName);
        System.out.println("Course: " + enrollment.courseTitle);
        System.out.println(
                "Progress: " + enrollment.calculateProgress() + "%");

        enrollment.completeLesson();

        System.out.println(
                "Updated progress: " + enrollment.calculateProgress() + "%");
        System.out.println("Completed: " + enrollment.isCompleted());
    }
}
