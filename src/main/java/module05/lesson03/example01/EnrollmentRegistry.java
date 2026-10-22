// Generated from modules/05-generics-collections-and-core-data-structures/03-working-with-set.md by tools/extract_code.py. Edit the lesson, not this file.
package module05.lesson03.example01;

import java.util.HashSet;
import java.util.Set;

public final class EnrollmentRegistry {

    private final Set<EnrollmentKey> enrollments;

    public EnrollmentRegistry() {
        this.enrollments = new HashSet<>();
    }

    public boolean enroll(long learnerId, long courseId) {
        EnrollmentKey key = new EnrollmentKey(learnerId, courseId);

        return enrollments.add(key);
    }

    public boolean isEnrolled(long learnerId, long courseId) {
        EnrollmentKey key = new EnrollmentKey(learnerId, courseId);

        return enrollments.contains(key);
    }

    public boolean cancelEnrollment(long learnerId, long courseId) {
        EnrollmentKey key = new EnrollmentKey(learnerId, courseId);

        return enrollments.remove(key);
    }

    public int getEnrollmentCount() {
        return enrollments.size();
    }

    public Set<EnrollmentKey> getEnrollments() {
        return Set.copyOf(enrollments);
    }
}
