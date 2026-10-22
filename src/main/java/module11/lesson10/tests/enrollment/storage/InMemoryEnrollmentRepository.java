package module11.lesson10.tests.enrollment.storage;

import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.enrollment.Enrollment;
import module11.lesson10.tests.enrollment.EnrollmentId;
import module11.lesson10.tests.enrollment.EnrollmentRepository;
import module11.lesson10.tests.learner.LearnerId;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class InMemoryEnrollmentRepository implements EnrollmentRepository {

    private final Map<EnrollmentId, Enrollment> enrollments =
            new LinkedHashMap<>();

    @Override
    public void save(Enrollment enrollment) {
        if (enrollment == null) {
            throw new IllegalArgumentException("Enrollment is required.");
        }

        enrollments.put(enrollment.getId(), enrollment);
    }

    @Override
    public Optional<Enrollment> findById(EnrollmentId enrollmentId) {
        if (enrollmentId == null) {
            throw new IllegalArgumentException("Enrollment id is required.");
        }

        return Optional.ofNullable(enrollments.get(enrollmentId));
    }

    @Override
    public boolean existsByLearnerAndCourse(
            LearnerId learnerId, CourseCode courseCode) {
        if (learnerId == null || courseCode == null) {
            throw new IllegalArgumentException(
                    "Learner id and course code are required.");
        }

        return enrollments.values()
                .stream()
                .anyMatch(enrollment ->
                        enrollment.getLearnerId().equals(learnerId)
                                && enrollment.getCourseCode().equals(courseCode));
    }

    @Override
    public List<Enrollment> findAll() {
        return List.copyOf(enrollments.values());
    }
}
