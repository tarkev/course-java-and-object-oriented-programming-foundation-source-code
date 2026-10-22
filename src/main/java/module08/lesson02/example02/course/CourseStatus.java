package module08.lesson02.example02.course;

public enum CourseStatus {

    DRAFT, REVIEW, PUBLISHED, ARCHIVED;

    public boolean isEditable() {
        return this == DRAFT || this == REVIEW;
    }
}
