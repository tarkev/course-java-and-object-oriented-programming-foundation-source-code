package module11.lesson10.tests.course.storage;

import module11.lesson10.tests.course.Course;
import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.course.CourseRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class InMemoryCourseRepository implements CourseRepository {

    private final Map<CourseCode, Course> courses = new LinkedHashMap<>();

    @Override
    public void save(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course is required.");
        }

        courses.put(course.getCode(), course);
    }

    @Override
    public Optional<Course> findByCode(CourseCode courseCode) {
        if (courseCode == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        return Optional.ofNullable(courses.get(courseCode));
    }

    @Override
    public List<Course> findAll() {
        return List.copyOf(courses.values());
    }
}
