package module10.lesson08.example01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        CourseService service = new CourseService(new InMemoryCourseRepository());
        CourseCode code = new CourseCode(" java-foundation ");

        service.create(code, "Java Foundation");
        service.addLesson(code, new Lesson(1, "Introduction to Java"));
        service.publish(code);

        System.out.println(service.summaryOf(code));
    }

    record CourseCode(String value) {

        CourseCode {
            Objects.requireNonNull(value, "Course code is required.");
            value = value.strip().toUpperCase(Locale.ROOT);

            if (value.isBlank()) {
                throw new IllegalArgumentException("Course code is required.");
            }
        }

        @Override
        public String toString() {
            return value;
        }
    }

    record Lesson(long id, String title) {
    }

    enum CourseStatus {
        DRAFT, PUBLISHED, ARCHIVED
    }

    static final class Course {

        private final CourseCode code;
        private final String title;
        private CourseStatus status = CourseStatus.DRAFT;
        private final List<Lesson> lessons = new ArrayList<>();

        Course(CourseCode code, String title) {
            this.code = Objects.requireNonNull(code);
            this.title = Objects.requireNonNull(title);
        }

        CourseCode code() {
            return code;
        }

        String title() {
            return title;
        }

        CourseStatus status() {
            return status;
        }

        List<Lesson> lessons() {
            return List.copyOf(lessons);
        }

        void addLesson(Lesson lesson) {
            requireDraft();
            lessons.add(Objects.requireNonNull(lesson));
        }

        void publish() {
            requireDraft();

            if (lessons.isEmpty()) {
                throw new IllegalStateException(
                        "Course must contain at least one lesson.");
            }

            status = CourseStatus.PUBLISHED;
        }

        private void requireDraft() {
            if (status != CourseStatus.DRAFT) {
                throw new IllegalStateException("Course must be in DRAFT status.");
            }
        }
    }

    record CourseSummary(
            CourseCode code, String title, CourseStatus status, int lessonCount) {
    }

    interface CourseRepository {

        void save(Course course);

        Optional<Course> findByCode(CourseCode code);
    }

    static final class InMemoryCourseRepository implements CourseRepository {

        private final List<Course> courses = new ArrayList<>();

        @Override
        public void save(Course course) {
            if (findByCode(course.code()).isEmpty()) {
                courses.add(course);
            }
        }

        @Override
        public Optional<Course> findByCode(CourseCode code) {
            return courses.stream()
                    .filter(course -> course.code().equals(code))
                    .findFirst();
        }
    }

    static final class CourseService {

        private final CourseRepository repository;

        CourseService(CourseRepository repository) {
            this.repository = Objects.requireNonNull(repository);
        }

        void create(CourseCode code, String title) {
            if (repository.findByCode(code).isPresent()) {
                throw new IllegalArgumentException("Course already exists: " + code);
            }

            repository.save(new Course(code, title));
        }

        void addLesson(CourseCode code, Lesson lesson) {
            Course course = requireCourse(code);
            course.addLesson(lesson);
            repository.save(course);
        }

        void publish(CourseCode code) {
            Course course = requireCourse(code);
            course.publish();
            repository.save(course);
        }

        CourseSummary summaryOf(CourseCode code) {
            Course course = requireCourse(code);

            return new CourseSummary(
                    course.code(), course.title(), course.status(),
                    course.lessons().size());
        }

        private Course requireCourse(CourseCode code) {
            return repository.findByCode(code)
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Course not found: " + code));
        }
    }
}
