package module10.lesson06.example01.repository;

import module10.lesson06.example01.course.Course;
import module10.lesson06.example01.course.CourseCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class InMemoryCourseRepository implements CourseRepository {

    private final Map<CourseCode, Course> courses = new HashMap<>();

    @Override
    public Optional<Course> findByCode(CourseCode code) {
        return Optional.ofNullable(courses.get(code));
    }

    @Override
    public void save(Course course) {
        courses.put(course.getCode(), course);
    }
}
