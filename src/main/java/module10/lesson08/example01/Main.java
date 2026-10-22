// Generated from modules/10-professional-java-practices/08-designing-clear-apis-and-boundaries.md by tools/extract_code.py. Edit the lesson, not this file.
package module10.lesson08.example01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

public class Main {

    public static void main(
            String[] args
    ) {
        CourseRepository repository =
                new InMemoryCourseRepository();

        CourseService service =
                new CourseService(
                        repository
                );

        CourseCode code =
                new CourseCode(
                        " java-foundation "
                );

        service.create(
                code,
                "Java Foundation"
        );

        service.addLesson(
                code,
                new Lesson(
                        1,
                        "Introduction to Java"
                )
        );

        service.publish(
                code
        );

        CourseSummary summary =
                service.find(
                        code
                );

        System.out.println(
                summary
        );
    }

    record CourseCode(
            String value
    ) {

        CourseCode {
            value =
                    Objects.requireNonNull(
                            value,
                            "Course code is required."
                    )
                    .strip()
                    .toUpperCase(
                            Locale.ROOT
                    );

            if (
                    value.isBlank()
            ) {
                throw new IllegalArgumentException(
                        "Course code is required."
                );
            }
        }

        @Override
        public String toString() {
            return value;
        }
    }

    record Lesson(
            long id,
            String title
    ) {

        Lesson {
            if (
                    id <= 0
            ) {
                throw new IllegalArgumentException(
                        "Lesson ID must be positive."
                );
            }

            title =
                    Objects.requireNonNull(
                            title,
                            "Lesson title is required."
                    ).strip();

            if (
                    title.isBlank()
            ) {
                throw new IllegalArgumentException(
                        "Lesson title is required."
                );
            }
        }
    }

    enum CourseStatus {
        DRAFT,
        PUBLISHED,
        ARCHIVED
    }

    static final class Course {

        private final CourseCode code;
        private String title;

        private CourseStatus status =
                CourseStatus.DRAFT;

        private final List<Lesson> lessons =
                new ArrayList<>();

        Course(
                CourseCode code,
                String title
        ) {
            this.code =
                    Objects.requireNonNull(
                            code
                    );

            changeTitle(
                    title
            );
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
            return List.copyOf(
                    lessons
            );
        }

        void changeTitle(
                String title
        ) {
            if (
                    status
                    != CourseStatus.DRAFT
            ) {
                throw new IllegalStateException(
                        "Only draft courses can be edited."
                );
            }

            title =
                    Objects.requireNonNull(
                            title,
                            "Title is required."
                    ).strip();

            if (
                    title.isBlank()
            ) {
                throw new IllegalArgumentException(
                        "Title is required."
                );
            }

            this.title =
                    title;
        }

        void addLesson(
                Lesson lesson
        ) {
            requireDraft();

            Objects.requireNonNull(
                    lesson
            );

            boolean duplicate =
                    lessons.stream()
                            .anyMatch(
                                    existing ->
                                            existing.id()
                                            == lesson.id()
                            );

            if (
                    duplicate
            ) {
                throw new IllegalArgumentException(
                        "Duplicate lesson ID: "
                                + lesson.id()
                );
            }

            lessons.add(
                    lesson
            );
        }

        void publish() {
            requireDraft();

            if (
                    lessons.isEmpty()
            ) {
                throw new IllegalStateException(
                        "Course must contain at least one lesson."
                );
            }

            status =
                    CourseStatus.PUBLISHED;
        }

        private void requireDraft() {
            if (
                    status
                    != CourseStatus.DRAFT
            ) {
                throw new IllegalStateException(
                        "Course must be in DRAFT status."
                );
            }
        }
    }

    record CourseSummary(
            CourseCode code,
            String title,
            CourseStatus status,
            int lessonCount
    ) {
    }

    interface CourseRepository {

        void save(
                Course course
        );

        Optional<Course> findByCode(
                CourseCode code
        );
    }

    static final class InMemoryCourseRepository
            implements CourseRepository {

        private final List<Course> courses =
                new ArrayList<>();

        @Override
        public void save(
                Course course
        ) {
            Optional<Course> existing =
                    findByCode(
                            course.code()
                    );

            if (
                    existing.isEmpty()
            ) {
                courses.add(
                        course
                );
            }
        }

        @Override
        public Optional<Course> findByCode(
                CourseCode code
        ) {
            return courses.stream()
                    .filter(
                            course ->
                                    course.code()
                                            .equals(
                                                    code
                                            )
                    )
                    .findFirst();
        }
    }

    static final class CourseService {

        private final CourseRepository repository;

        CourseService(
                CourseRepository repository
        ) {
            this.repository =
                    Objects.requireNonNull(
                            repository
                    );
        }

        void create(
                CourseCode code,
                String title
        ) {
            if (
                    repository.findByCode(
                            code
                    ).isPresent()
            ) {
                throw new IllegalArgumentException(
                        "Course already exists: "
                                + code
                );
            }

            repository.save(
                    new Course(
                            code,
                            title
                    )
            );
        }

        void addLesson(
                CourseCode code,
                Lesson lesson
        ) {
            Course course =
                    requireCourse(
                            code
                    );

            course.addLesson(
                    lesson
            );

            repository.save(
                    course
            );
        }

        void publish(
                CourseCode code
        ) {
            Course course =
                    requireCourse(
                            code
                    );

            course.publish();

            repository.save(
                    course
            );
        }

        CourseSummary find(
                CourseCode code
        ) {
            Course course =
                    requireCourse(
                            code
                    );

            return new CourseSummary(
                    course.code(),
                    course.title(),
                    course.status(),
                    course.lessons()
                            .size()
            );
        }

        private Course requireCourse(
                CourseCode code
        ) {
            return repository.findByCode(
                    code
            ).orElseThrow(
                    () ->
                            new IllegalArgumentException(
                                    "Course not found: "
                                            + code
                            )
            );
        }
    }
}
