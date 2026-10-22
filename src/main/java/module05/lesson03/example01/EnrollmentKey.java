// Generated from modules/05-generics-collections-and-core-data-structures/03-working-with-set.md by tools/extract_code.py. Edit the lesson, not this file.
package module05.lesson03.example01;

import java.util.Objects;

public final class EnrollmentKey {

    private final long learnerId;
    private final long courseId;

    public EnrollmentKey(long learnerId, long courseId) {
        if (learnerId <= 0) {
            throw new IllegalArgumentException("Learner ID must be positive.");
        }

        if (courseId <= 0) {
            throw new IllegalArgumentException("Course ID must be positive.");
        }

        this.learnerId = learnerId;

        this.courseId = courseId;
    }

    public long getLearnerId() {
        return learnerId;
    }

    public long getCourseId() {
        return courseId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof EnrollmentKey key)) {
            return false;
        }

        return learnerId == key.learnerId && courseId == key.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(learnerId, courseId);
    }

    @Override
    public String toString() {
        return "EnrollmentKey{learnerId=" + learnerId
                + ", courseId=" + courseId + '}';
    }
}
