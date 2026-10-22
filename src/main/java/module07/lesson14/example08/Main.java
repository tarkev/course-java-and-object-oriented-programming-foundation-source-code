package module07.lesson14.example08;

public class Main {

    enum EnrollmentStatus {
        ACTIVE, COMPLETED, CANCELLED, PAUSED
    }

    static String label(EnrollmentStatus status) {
        return switch (status) {
            case ACTIVE -> "In progress";
            case COMPLETED -> "Completed";
            case CANCELLED -> {
                String note = "Cancelled";
                yield note + " (no access)";
            }
            case PAUSED -> "Paused";
        };
    }

    public static void main(String[] args) {
        System.out.println(label(EnrollmentStatus.ACTIVE));
        System.out.println(label(EnrollmentStatus.CANCELLED));
        System.out.println(label(EnrollmentStatus.PAUSED));
    }
}
