package module05.lesson10.example07;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, "Java Basics"));
        LearningPath path = new LearningPath(courses);

        courses.clear();
        System.out.println(path.getCourses().size());

        List<Course> snapshot = path.getCourses();
        System.out.println(snapshot.get(0).getTitle());
    }
}

final class LearningPath {
    private final List<Course> courses;

    LearningPath(List<Course> courses) {
        if (courses == null) {
            throw new IllegalArgumentException("Courses are required.");
        }
        this.courses = new ArrayList<>(courses);
    }

    List<Course> getCourses() {
        return List.copyOf(courses);
    }
}

final class Course {
    private final long id;
    private final String title;

    Course(long id, String title) {
        this.id = id;
        this.title = title;
    }

    long getId() {
        return id;
    }

    String getTitle() {
        return title;
    }
}
