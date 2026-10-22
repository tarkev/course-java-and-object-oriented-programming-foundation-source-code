package module10.lesson11.example04;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Enrollment> initial = new ArrayList<>();
        Learner learner = new Learner("Sumu", initial);
        initial.add(new Enrollment("JAVA-OOP"));

        learner.enroll(new Enrollment("SPRING"));
        System.out.println(learner.getEnrollments());

        try {
            learner.getEnrollments().clear();
        } catch (UnsupportedOperationException exception) {
            System.out.println("Snapshot cannot be changed");
        }

        try {
            learner.enroll(new Enrollment("SPRING"));
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

record Enrollment(String courseCode) {
}

final class Learner {

    private final String name;
    private final List<Enrollment> enrollments;

    Learner(String name, List<Enrollment> enrollments) {
        this.name = name;
        this.enrollments = new ArrayList<>(enrollments);
    }

    void enroll(Enrollment enrollment) {
        if (enrollments.contains(enrollment)) {
            throw new IllegalStateException(
                    name + " is already enrolled in " + enrollment.courseCode());
        }

        enrollments.add(enrollment);
    }

    List<Enrollment> getEnrollments() {
        return List.copyOf(enrollments);
    }
}
