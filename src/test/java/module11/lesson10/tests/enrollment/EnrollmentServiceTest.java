package module11.lesson10.tests.enrollment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.course.CourseNotFoundException;
import module11.lesson10.tests.course.CourseRepository;
import module11.lesson10.tests.course.CourseService;
import module11.lesson10.tests.course.Lesson;
import module11.lesson10.tests.course.LessonId;
import module11.lesson10.tests.course.storage.InMemoryCourseRepository;
import module11.lesson10.tests.enrollment.storage.InMemoryEnrollmentRepository;
import module11.lesson10.tests.learner.EmailAddress;
import module11.lesson10.tests.learner.LearnerId;
import module11.lesson10.tests.learner.LearnerNotFoundException;
import module11.lesson10.tests.learner.LearnerRepository;
import module11.lesson10.tests.learner.LearnerService;
import module11.lesson10.tests.learner.storage.InMemoryLearnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class EnrollmentServiceTest {

    private static final CourseCode JAVA_OOP = new CourseCode("JAVA-OOP");
    private static final CourseCode SPRING = new CourseCode("SPRING-BOOT");
    private static final CourseCode NOPE = new CourseCode("NOPE");
    private static final LearnerId SAKIB = new LearnerId(1L);
    private static final LearnerId UNKNOWN = new LearnerId(7L);
    private static final EnrollmentId FIRST = new EnrollmentId(1001L);
    private static final EnrollmentId SECOND = new EnrollmentId(1002L);

    private CourseService courses;
    private EnrollmentService service;

    @BeforeEach
    void setUp() {
        CourseRepository courseRepository = new InMemoryCourseRepository();
        LearnerRepository learnerRepository = new InMemoryLearnerRepository();
        courses = new CourseService(courseRepository);
        service = new EnrollmentService(courseRepository, learnerRepository,
                new InMemoryEnrollmentRepository());

        courses.createCourse(JAVA_OOP, "Java and OOP Foundation", 499_000L);
        courses.addLesson(JAVA_OOP,
                new Lesson(new LessonId(1L), "Introduction", "What Java is."));
        courses.publishCourse(JAVA_OOP);
        courses.createCourse(SPRING, "Spring Boot", 599_000L);
        new LearnerService(learnerRepository).registerLearner(
                SAKIB, "Sakib", new EmailAddress("sakib@example.com"));
    }

    @Test
    void enrollSavesAnActiveEnrollment() {
        service.enroll(FIRST, SAKIB, JAVA_OOP);

        assertEquals(new EnrollmentSummary(FIRST, SAKIB, JAVA_OOP,
                EnrollmentStatus.ACTIVE), service.findEnrollment(FIRST));
    }

    @Test
    void usedEnrollmentIdIsCheckedFirst() {
        service.enroll(FIRST, SAKIB, JAVA_OOP);

        DuplicateEnrollmentIdException exception = assertThrows(
                DuplicateEnrollmentIdException.class,
                () -> service.enroll(FIRST, UNKNOWN, NOPE));

        assertEquals("Enrollment id already exists: 1001.",
                exception.getMessage());
    }

    @Test
    void unknownLearnerIsCheckedBeforeTheCourse() {
        LearnerNotFoundException exception = assertThrows(
                LearnerNotFoundException.class,
                () -> service.enroll(FIRST, UNKNOWN, NOPE));

        assertEquals("Learner not found: 7.", exception.getMessage());
    }

    @Test
    void unknownCourseIsRejected() {
        CourseNotFoundException exception = assertThrows(
                CourseNotFoundException.class,
                () -> service.enroll(FIRST, SAKIB, NOPE));

        assertEquals("Course not found: NOPE.", exception.getMessage());
    }

    @Test
    void draftCourseIsNotAvailable() {
        CourseNotAvailableForEnrollmentException exception = assertThrows(
                CourseNotAvailableForEnrollmentException.class,
                () -> service.enroll(FIRST, SAKIB, SPRING));

        assertEquals("Course is not available for enrollment: SPRING-BOOT.",
                exception.getMessage());
    }

    @Test
    void availabilityIsCheckedBeforeAnExistingEnrollment() {
        service.enroll(FIRST, SAKIB, JAVA_OOP);
        courses.archiveCourse(JAVA_OOP);

        assertThrows(CourseNotAvailableForEnrollmentException.class,
                () -> service.enroll(SECOND, SAKIB, JAVA_OOP));
    }

    @Test
    void completedEnrollmentStillBlocksASecondOne() {
        service.enroll(FIRST, SAKIB, JAVA_OOP);
        service.completeEnrollment(FIRST);

        DuplicateEnrollmentException exception = assertThrows(
                DuplicateEnrollmentException.class,
                () -> service.enroll(SECOND, SAKIB, JAVA_OOP));

        assertEquals("Learner 1 is already enrolled in course JAVA-OOP.",
                exception.getMessage());
    }

    @Test
    void rejectedEnrollmentSavesNothing() {
        assertThrows(CourseNotAvailableForEnrollmentException.class,
                () -> service.enroll(FIRST, SAKIB, SPRING));

        assertEquals(List.of(), service.findAllEnrollments());
    }
}
