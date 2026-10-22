package module05.lesson11.example11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<Long, List<Course>> groupByInstructor(List<Course> courses) {
        if (courses == null) {
            return Map.of();
        }

        Map<Long, List<Course>> groups = new HashMap<>();
        for (Course course : courses) {
            if (course == null) {
                continue;
            }
            List<Course> group = groups.get(course.getInstructorId());
            if (group == null) {
                group = new ArrayList<>();
                groups.put(course.getInstructorId(), group);
            }
            group.add(course);
        }

        Map<Long, List<Course>> result = new HashMap<>();
        for (Map.Entry<Long, List<Course>> entry : groups.entrySet()) {
            result.put(entry.getKey(), List.copyOf(entry.getValue()));
        }
        return Map.copyOf(result);
    }

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java Basics", 10L),
                new Course("Spring Boot", 20L),
                new Course("Java Collections", 10L));

        Map<Long, List<Course>> groups = groupByInstructor(courses);
        System.out.println(groups.size());
        for (Course course : groups.get(10L)) {
            System.out.println(course.getTitle());
        }
        System.out.println(groups.get(20L).size());
    }
}

final class Course {
    private final String title;
    private final long instructorId;

    Course(String title, long instructorId) {
        this.title = title;
        this.instructorId = instructorId;
    }

    String getTitle() {
        return title;
    }

    long getInstructorId() {
        return instructorId;
    }
}
