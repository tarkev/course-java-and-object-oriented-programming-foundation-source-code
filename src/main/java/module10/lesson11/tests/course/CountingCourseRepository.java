package module10.lesson11.tests.course;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class CountingCourseRepository implements CourseRepository {

    private final Map<CourseCode, Course> courses = new LinkedHashMap<>();
    private int saveCount;

    @Override
    public Optional<Course> findByCode(CourseCode courseCode) {
        return Optional.ofNullable(courses.get(courseCode));
    }

    @Override
    public void save(Course course) {
        saveCount++;
        courses.put(course.getCode(), course);
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }

    int getSaveCount() {
        return saveCount;
    }
}
