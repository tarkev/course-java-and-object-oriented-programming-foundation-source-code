package module05.lesson03.example01;

public class Main {

    public static void main(String[] args) {
        EnrollmentRegistry registry = new EnrollmentRegistry();

        boolean firstEnrollment = registry.enroll(101L, 501L);
        boolean duplicateEnrollment = registry.enroll(101L, 501L);
        boolean anotherCourse = registry.enroll(101L, 502L);
        boolean anotherLearner = registry.enroll(102L, 501L);

        System.out.println("First enrollment: " + firstEnrollment);
        System.out.println("Duplicate enrollment: " + duplicateEnrollment);
        System.out.println("Another course: " + anotherCourse);
        System.out.println("Another learner: " + anotherLearner);
        System.out.println(
                "Enrollment count: " + registry.getEnrollmentCount());
        System.out.println(
                "Learner 101 in course 501: " + registry.isEnrolled(101L, 501L));

        boolean cancelled = registry.cancelEnrollment(101L, 501L);

        System.out.println("Cancelled: " + cancelled);
        System.out.println(
                "Enrollment count: " + registry.getEnrollmentCount());
    }
}
