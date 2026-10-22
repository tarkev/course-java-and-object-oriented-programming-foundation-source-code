package module03.lesson05.example01;

public class Main {

    public static void main(String[] args) {
        Enrollment enrollment =
                new Enrollment("Nur", "Java and OOP Foundation", 20);

        boolean updated = enrollment.completeLessons(8);

        if (!updated) {
            System.out.println("Progress update failed.");
            return;
        }

        System.out.println("Learner: " + enrollment.getLearnerName());
        System.out.println("Course: " + enrollment.getCourseTitle());
        System.out.println(
                "Completed lessons: " + enrollment.getCompletedLessons());
        System.out.println(
                "Progress: " + enrollment.calculateProgress() + "%");
        System.out.println(
                "Remaining lessons: " + enrollment.calculateRemainingLessons());
        System.out.println("Active: " + enrollment.isActive());
    }
}
