package module09.lesson09.example10.repository;

import module09.lesson09.example10.course.Course;
import module09.lesson09.example10.course.CourseCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class InMemoryCourseRepository implements CourseRepository {

    private final Map<CourseCode, Course> courses = new HashMap<>();

    @Override
    public void save(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course is required.");
        }

        courses.put(course.getCode(), course);
    }

    @Override
    public Optional<Course> findByCode(CourseCode courseCode) {
        return Optional.ofNullable(courses.get(requireCode(courseCode)));
    }

    @Override
    public List<Course> findAll() {
        return List.copyOf(courses.values());
    }

    @Override
    public boolean deleteByCode(CourseCode courseCode) {
        return courses.remove(requireCode(courseCode)) != null;
    }

    private CourseCode requireCode(CourseCode courseCode) {
        if (courseCode == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        return courseCode;
    }
}
