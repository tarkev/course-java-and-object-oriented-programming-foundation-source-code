package module10.lesson07.example01.course.storage;

import module10.lesson07.example01.course.Course;
import module10.lesson07.example01.course.CourseCode;
import module10.lesson07.example01.course.CourseRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class InMemoryCourseRepository implements CourseRepository {

    private final Map<CourseCode, Course> courses = new LinkedHashMap<>();

    @Override
    public Optional<Course> findByCode(CourseCode courseCode) {
        return Optional.ofNullable(courses.get(courseCode));
    }

    @Override
    public void save(Course course) {
        courses.put(course.getCode(), course);
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }
}
