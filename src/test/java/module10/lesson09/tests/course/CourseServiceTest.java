package module10.lesson09.tests.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import module10.lesson09.tests.course.storage.InMemoryCourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseServiceTest {

    private CourseRepository repository;
    private CourseService service;

    @BeforeEach
    void setUp() {
        repository = new InMemoryCourseRepository();
        service = new CourseService(repository);
    }

    @Test
    void duplicateCodeWithDifferentSpacingIsRejected() {
        service.createCourse(
                new CourseCode("JAVA-OOP"), "Java and OOP Foundation", 499_000L);

        assertThrows(DuplicateCourseException.class,
                () -> service.createCourse(
                        new CourseCode(" java-oop "), "Duplicate", 100_000L));
        assertEquals(1, service.findAll().size());
    }

    @Test
    void publishCourseSavesThePublishedCourse() {
        CourseCode code = new CourseCode("JAVA-OOP");
        service.createCourse(code, "Java and OOP Foundation", 499_000L);

        service.publishCourse(code);

        Course saved = repository.findByCode(code).orElseThrow();
        assertEquals(CourseStatus.PUBLISHED, saved.getStatus());
    }
}
