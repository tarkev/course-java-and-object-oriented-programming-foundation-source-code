package module11.lesson10.tests.enrollment;

public record EnrollmentId(long value) {

    public EnrollmentId {
        if (value <= 0) {
            throw new IllegalArgumentException("Enrollment id must be positive.");
        }
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
