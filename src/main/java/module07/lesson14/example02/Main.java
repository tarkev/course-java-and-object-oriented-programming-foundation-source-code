package module07.lesson14.example02;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        CourseRepository repository = new CourseRepository();
        repository.save(new Course("JAVA", "Java Foundation", 300_000));

        System.out.println(repository.findByCode("JAVA").map(Course::title).orElse("Not found"));
        System.out.println(repository.findByCode("RUST").map(Course::title).orElse("Not found"));
    }

    record Course(String code, String title, long priceInPaisa) {
    }

    static final class CourseRepository {

        private final Map<String, Course> courses = new HashMap<>();

        void save(Course course) {
            courses.put(course.code(), course);
        }

        Optional<Course> findByCode(String code) {
            return Optional.ofNullable(courses.get(code));
        }
    }
}
