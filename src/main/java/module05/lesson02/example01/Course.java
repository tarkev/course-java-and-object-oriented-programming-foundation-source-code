package module05.lesson02.example01;

import java.util.ArrayList;
import java.util.List;

public final class Course {

    private final long id;
    private final String title;
    private final List<String> lessonTitles;

    private boolean published;

    public Course(long id, String title) {
        if (id <= 0) {
            throw new IllegalArgumentException("Course ID must be positive.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title is required.");
        }

        this.id = id;
        this.title = title.strip();
        this.lessonTitles = new ArrayList<>();
        this.published = false;
    }

    public boolean addLesson(String lessonTitle) {
        if (published) {
            return false;
        }

        if (lessonTitle == null || lessonTitle.isBlank()) {
            return false;
        }

        String normalizedTitle = lessonTitle.strip();

        if (lessonTitles.contains(normalizedTitle)) {
            return false;
        }

        lessonTitles.add(normalizedTitle);

        return true;
    }

    public boolean renameLesson(int index, String newTitle) {
        if (published) {
            return false;
        }

        if (index < 0 || index >= lessonTitles.size()) {
            return false;
        }

        if (newTitle == null || newTitle.isBlank()) {
            return false;
        }

        String normalizedTitle = newTitle.strip();

        if (lessonTitles.contains(normalizedTitle)) {
            return false;
        }

        lessonTitles.set(index, normalizedTitle);

        return true;
    }

    public boolean removeLesson(String lessonTitle) {
        if (published) {
            return false;
        }

        if (lessonTitle == null || lessonTitle.isBlank()) {
            return false;
        }

        return lessonTitles.remove(lessonTitle.strip());
    }

    public boolean publish() {
        if (published) {
            return false;
        }

        if (lessonTitles.isEmpty()) {
            return false;
        }

        published = true;

        return true;
    }

    public void printLessons() {
        for (int index = 0; index < lessonTitles.size(); index++) {
            System.out.println((index + 1) + ". " + lessonTitles.get(index));
        }
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

    public int getLessonCount() {
        return lessonTitles.size();
    }

    public List<String> getLessonTitles() {
        return List.copyOf(lessonTitles);
    }
}
