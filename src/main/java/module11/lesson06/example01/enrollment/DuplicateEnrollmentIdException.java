package module11.lesson06.example01.enrollment;

public final class DuplicateEnrollmentIdException extends RuntimeException {

    public DuplicateEnrollmentIdException(EnrollmentId enrollmentId) {
        super("Enrollment id already exists: " + enrollmentId + ".");
    }
}
