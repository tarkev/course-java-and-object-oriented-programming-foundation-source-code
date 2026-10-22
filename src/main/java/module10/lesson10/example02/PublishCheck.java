package module10.lesson10.example02;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class PublishCheck {

    public static void main(String[] args) {
        Instant now = Instant.parse("2026-08-08T12:00:00Z");
        Clock fixedClock = Clock.fixed(now, ZoneOffset.UTC);
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        CourseService service =
                new CourseService(repository, course -> { }, fixedClock);

        Course course = new Course(new CourseCode("JAVA-OOP"), "Java and OOP");
        repository.save(course);
        service.publish(course.getCode());

        if (!now.equals(course.getPublishedAt())) {
            throw new AssertionError("Unexpected time: " + course.getPublishedAt());
        }

        System.out.println("Published at " + course.getPublishedAt());
    }
}

record CourseCode(String value) {
}

final class Course {

    private final CourseCode code;
    private final String title;
    private Instant publishedAt;

    Course(CourseCode code, String title) {
        this.code = code;
        this.title = title;
    }

    void publish(Instant time) {
        publishedAt = Objects.requireNonNull(time);
    }

    CourseCode getCode() {
        return code;
    }

    String getTitle() {
        return title;
    }

    Instant getPublishedAt() {
        return publishedAt;
    }
}

interface CourseRepository {

    Optional<Course> findByCode(CourseCode code);

    void save(Course course);
}

final class InMemoryCourseRepository implements CourseRepository {

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

interface CourseNotifier {

    void coursePublished(Course course);
}

final class CourseService {

    private final CourseRepository repository;
    private final CourseNotifier notifier;
    private final Clock clock;

    CourseService(CourseRepository repository, CourseNotifier notifier, Clock clock) {
        this.repository = Objects.requireNonNull(repository);
        this.notifier = Objects.requireNonNull(notifier);
        this.clock = Objects.requireNonNull(clock);
    }

    void publish(CourseCode code) {
        Course course = repository.findByCode(code)
                .orElseThrow(() -> new IllegalStateException(
                        "Course not found: " + code.value()));

        course.publish(Instant.now(clock));
        repository.save(course);
        notifier.coursePublished(course);
    }
}
