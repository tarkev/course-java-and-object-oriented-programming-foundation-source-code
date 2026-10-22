// Generated from modules/05-generics-collections-and-core-data-structures/04-working-with-map.md by tools/extract_code.py. Edit the lesson, not this file.
package module05.lesson04.example01;

import java.util.LinkedHashMap;
import java.util.Map;

public final class CourseCatalog {

    private final Map<CourseCode, Course> coursesByCode;

    public CourseCatalog() {
        this.coursesByCode = new LinkedHashMap<>();
    }

    public boolean register(Course course) {
        if (course == null) {
            return false;
        }

        Course existing = coursesByCode.putIfAbsent(course.getCode(), course);

        return existing == null;
    }

    public Course findByCode(CourseCode courseCode) {
        if (courseCode == null) {
            return null;
        }

        return coursesByCode.get(courseCode);
    }

    public boolean contains(CourseCode courseCode) {
        if (courseCode == null) {
            return false;
        }

        return coursesByCode.containsKey(courseCode);
    }

    public boolean remove(CourseCode courseCode) {
        if (courseCode == null) {
            return false;
        }

        return coursesByCode.remove(courseCode) != null;
    }

    public int getCourseCount() {
        return coursesByCode.size();
    }

    public void printCourses() {
        for (Map.Entry<CourseCode, Course> entry : coursesByCode.entrySet()) {
            System.out.println(
                    entry.getKey() + " → " + entry.getValue().getTitle());
        }
    }

    public Map<CourseCode, Course> getCoursesByCode() {
        return Map.copyOf(coursesByCode);
    }
}
