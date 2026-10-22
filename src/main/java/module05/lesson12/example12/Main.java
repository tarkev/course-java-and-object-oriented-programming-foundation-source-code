package module05.lesson12.example12;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CourseModule module = new CourseModule("Collections");
        System.out.println(module.addLesson(new Lesson(1L, "List")));
        System.out.println(module.addLesson(new Lesson(2L, "Set")));
        System.out.println(module.addLesson(new Lesson(1L, "Map")));
        System.out.println(module.addLesson(null));
        System.out.println(module.getLessons());
    }
}

final class CourseModule {
    private static final int MAX_LESSON_COUNT = 20;

    private final String title;
    private final List<Lesson> lessons = new ArrayList<>();

    CourseModule(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Module title is required.");
        }
        this.title = title.strip();
    }

    boolean addLesson(Lesson lesson) {
        if (lesson == null) {
            return false;
        }
        if (lessons.size() >= MAX_LESSON_COUNT) {
            return false;
        }
        if (containsLessonId(lesson.getId())) {
            return false;
        }
        lessons.add(lesson);
        return true;
    }

    List<Lesson> getLessons() {
        return List.copyOf(lessons);
    }

    String getTitle() {
        return title;
    }

    private boolean containsLessonId(long lessonId) {
        for (Lesson lesson : lessons) {
            if (lesson.getId() == lessonId) {
                return true;
            }
        }
        return false;
    }
}

final class Lesson {
    private final long id;
    private final String title;

    Lesson(long id, String title) {
        if (id <= 0) {
            throw new IllegalArgumentException("Lesson ID must be positive.");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Lesson title is required.");
        }
        this.id = id;
        this.title = title.strip();
    }

    long getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return id + ": " + title;
    }
}
