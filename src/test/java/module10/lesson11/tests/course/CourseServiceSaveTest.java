package module10.lesson11.tests.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseServiceSaveTest {

    private final CourseCode code = new CourseCode("JAVA-OOP");

    private CountingCourseRepository repository;
    private CourseService service;

    @BeforeEach
    void setUp() {
        repository = new CountingCourseRepository();
        service = new CourseService(repository);
    }

    @Test
    void createCourseSavesExactlyOnce() {
        service.createCourse(code, "Java and OOP Foundation", 499_000L);

        assertEquals(1, repository.getSaveCount());
    }

    @Test
    void rejectedDuplicateIsNotSaved() {
        service.createCourse(code, "Java and OOP Foundation", 499_000L);

        assertThrows(DuplicateCourseException.class,
                () -> service.createCourse(code, "Duplicate", 100_000L));
        assertEquals(1, repository.getSaveCount());
    }

    @Test
    void publishCourseSavesThePublishedCourse() {
        service.createCourse(code, "Java and OOP Foundation", 499_000L);

        service.publishCourse(code);

        assertEquals(2, repository.getSaveCount());
        Course saved = repository.findByCode(code).orElseThrow();
        assertEquals(CourseStatus.PUBLISHED, saved.getStatus());
    }
}
