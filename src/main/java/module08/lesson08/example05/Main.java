package module08.lesson08.example05;

public class Main {

    public static void main(String[] args) {
        for (EnrollmentStatus status : EnrollmentStatus.values()) {
            System.out.println(status + ": " + getLearnerMessage(status));
        }
    }

    static String getLearnerMessage(EnrollmentStatus status) {
        return switch (status) {
            case PENDING -> "Your enrollment is waiting for confirmation.";
            case ACTIVE -> "You can start learning now.";
            case CANCELLED -> "Your enrollment was cancelled.";
            case COMPLETED -> "Congratulations, you completed the course.";
        };
    }
}

enum EnrollmentStatus {
    PENDING, ACTIVE, CANCELLED, COMPLETED
}
