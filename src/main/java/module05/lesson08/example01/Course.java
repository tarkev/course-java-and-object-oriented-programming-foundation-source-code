// Generated from modules/05-generics-collections-and-core-data-structures/08-designing-classes-that-own-collections.md by tools/extract_code.py. Edit the lesson, not this file.
package module05.lesson08.example01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Course {

    private static final int MAX_LESSON_COUNT = 100;

    private final long id;
    private final String title;
    private final List<Lesson> lessons;

    private boolean published;

    public Course(long id, String title) {
        this(id, title, List.of());
    }

    public Course(long id, String title, List<Lesson> initialLessons) {
        if (id <= 0) {
            throw new IllegalArgumentException("Course ID must be positive.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        if (initialLessons == null) {
            throw new IllegalArgumentException("Initial lessons are required.");
        }

        if (initialLessons.size() > MAX_LESSON_COUNT) {
            throw new IllegalArgumentException(
                    "Course cannot contain more than " + MAX_LESSON_COUNT + " lessons.");
        }

        validateLessons(initialLessons);

        this.id = id;

        this.title = title.strip();

        this.lessons = new ArrayList<>(initialLessons);

        this.published = false;
    }

    public boolean addLesson(Lesson lesson) {
        return addLessonAt(lessons.size(), lesson);
    }

    public boolean addLessonAt(int index, Lesson lesson) {
        if (published) {
            return false;
        }

        if (lesson == null) {
            return false;
        }

        if (index < 0 || index > lessons.size()) {
            return false;
        }

        if (lessons.size() >= MAX_LESSON_COUNT) {
            return false;
        }

        if (containsLessonId(lesson.getId())) {
            return false;
        }

        lessons.add(index, lesson);

        return true;
    }

    public boolean removeLesson(long lessonId) {
        if (published) {
            return false;
        }

        int index = findLessonIndex(lessonId);

        if (index < 0) {
            return false;
        }

        lessons.remove(index);

        return true;
    }

    public boolean renameLesson(long lessonId, String newTitle) {
        if (published) {
            return false;
        }

        if (newTitle == null || newTitle.isBlank()) {
            return false;
        }

        int index = findLessonIndex(lessonId);

        if (index < 0) {
            return false;
        }

        Lesson currentLesson = lessons.get(index);

        lessons.set(index, currentLesson.rename(newTitle));

        return true;
    }

    public boolean moveLesson(long lessonId, int targetIndex) {
        if (published) {
            return false;
        }

        if (targetIndex < 0 || targetIndex >= lessons.size()) {
            return false;
        }

        int currentIndex = findLessonIndex(lessonId);

        if (currentIndex < 0 || currentIndex == targetIndex) {
            return false;
        }

        Lesson lesson = lessons.remove(currentIndex);

        lessons.add(targetIndex, lesson);

        return true;
    }

    public Lesson findLessonById(long lessonId) {
        int index = findLessonIndex(lessonId);

        if (index < 0) {
            return null;
        }

        return lessons.get(index);
    }

    public boolean publish() {
        if (published) {
            return false;
        }

        if (lessons.isEmpty()) {
            return false;
        }

        published = true;

        return true;
    }

    public List<Lesson> getLessons() {
        return List.copyOf(lessons);
    }

    public int getLessonCount() {
        return lessons.size();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPublished() {
        return published;
    }

    private boolean containsLessonId(long lessonId) {
        return findLessonIndex(lessonId) >= 0;
    }

    private int findLessonIndex(long lessonId) {
        for (int index = 0; index < lessons.size(); index++) {
            if (lessons.get(index).getId() == lessonId) {
                return index;
            }
        }

        return -1;
    }

    private static void validateLessons(List<Lesson> lessons) {
        Set<Long> lessonIds = new HashSet<>();

        for (Lesson lesson : lessons) {
            if (lesson == null) {
                throw new IllegalArgumentException("Lessons cannot contain null.");
            }

            if (!lessonIds.add(lesson.getId())) {
                throw new IllegalArgumentException(
                        "Duplicate lesson ID: " + lesson.getId());
            }
        }
    }
}
