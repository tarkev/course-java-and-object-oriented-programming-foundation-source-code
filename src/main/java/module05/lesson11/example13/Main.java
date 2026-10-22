package module05.lesson11.example13;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CourseModule module = new CourseModule("Collections");
        System.out.println(module.addLesson(new Lesson(1L, "List")));
        System.out.println(module.addLesson(new Lesson(1L, "Set")));
        System.out.println(module.addLesson(null));
        module.publish();
        System.out.println(module.addLesson(new Lesson(2L, "Map")));
    }
}

enum AddLessonResult {
    ADDED, COURSE_PUBLISHED, INVALID_LESSON, DUPLICATE_ID, LIMIT_REACHED
}

final class CourseModule {
    private static final int MAX_LESSON_COUNT = 20;

    private final String title;
    private final List<Lesson> lessons = new ArrayList<>();
    private boolean published;

    CourseModule(String title) {
        this.title = title;
    }

    void publish() {
        published = true;
    }

    AddLessonResult addLesson(Lesson lesson) {
        if (published) {
            return AddLessonResult.COURSE_PUBLISHED;
        }
        if (lesson == null) {
            return AddLessonResult.INVALID_LESSON;
        }
        if (lessons.size() >= MAX_LESSON_COUNT) {
            return AddLessonResult.LIMIT_REACHED;
        }
        for (Lesson existing : lessons) {
            if (existing.getId() == lesson.getId()) {
                return AddLessonResult.DUPLICATE_ID;
            }
        }
        lessons.add(lesson);
        return AddLessonResult.ADDED;
    }
}

final class Lesson {
    private final long id;
    private final String title;

    Lesson(long id, String title) {
        this.id = id;
        this.title = title;
    }

    long getId() {
        return id;
    }
}
