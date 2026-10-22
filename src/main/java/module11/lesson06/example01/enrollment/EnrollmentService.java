package module11.lesson06.example01.enrollment;

import module11.lesson06.example01.course.Course;
import module11.lesson06.example01.course.CourseCode;
import module11.lesson06.example01.course.CourseNotFoundException;
import module11.lesson06.example01.course.CourseRepository;
import module11.lesson06.example01.learner.Learner;
import module11.lesson06.example01.learner.LearnerId;
import module11.lesson06.example01.learner.LearnerNotFoundException;
import module11.lesson06.example01.learner.LearnerRepository;

import java.util.List;

public final class EnrollmentService {

    private final CourseRepository courseRepository;
    private final LearnerRepository learnerRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(
            CourseRepository courseRepository,
            LearnerRepository learnerRepository,
            EnrollmentRepository enrollmentRepository) {
        if (courseRepository == null
                || learnerRepository == null
                || enrollmentRepository == null) {
            throw new IllegalArgumentException(
                    "Enrollment service repositories are required.");
        }

        this.courseRepository = courseRepository;
        this.learnerRepository = learnerRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public void enroll(
            EnrollmentId enrollmentId,
            LearnerId learnerId,
            CourseCode courseCode) {
        if (enrollmentId == null || learnerId == null || courseCode == null) {
            throw new IllegalArgumentException(
                    "Enrollment id, learner id, and course code are required.");
        }

        if (enrollmentRepository.findById(enrollmentId).isPresent()) {
            throw new DuplicateEnrollmentIdException(enrollmentId);
        }

        requireLearner(learnerId);
        Course course = requireCourse(courseCode);

        if (!course.isPublished()) {
            throw new CourseNotAvailableForEnrollmentException(courseCode);
        }

        if (enrollmentRepository.existsByLearnerAndCourse(learnerId, courseCode)) {
            throw new DuplicateEnrollmentException(learnerId, courseCode);
        }

        Enrollment enrollment =
                new Enrollment(enrollmentId, learnerId, courseCode);
        enrollmentRepository.save(enrollment);
    }

    public void completeEnrollment(EnrollmentId enrollmentId) {
        Enrollment enrollment = requireEnrollment(enrollmentId);
        enrollment.complete();
        enrollmentRepository.save(enrollment);
    }

    public void cancelEnrollment(EnrollmentId enrollmentId) {
        Enrollment enrollment = requireEnrollment(enrollmentId);
        enrollment.cancel();
        enrollmentRepository.save(enrollment);
    }

    public EnrollmentSummary findEnrollment(EnrollmentId enrollmentId) {
        return requireEnrollment(enrollmentId).summary();
    }

    public List<EnrollmentSummary> findAllEnrollments() {
        return enrollmentRepository.findAll()
                .stream()
                .map(Enrollment::summary)
                .toList();
    }

    private Learner requireLearner(LearnerId learnerId) {
        return learnerRepository.findById(learnerId)
                .orElseThrow(() -> new LearnerNotFoundException(learnerId));
    }

    private Course requireCourse(CourseCode courseCode) {
        return courseRepository.findByCode(courseCode)
                .orElseThrow(() -> new CourseNotFoundException(courseCode));
    }

    private Enrollment requireEnrollment(EnrollmentId enrollmentId) {
        if (enrollmentId == null) {
            throw new IllegalArgumentException("Enrollment id is required.");
        }

        return enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentNotFoundException(enrollmentId));
    }
}
