// Generated from modules/07-modern-java/08-modern-java-language-features.md by tools/extract_code.py. Edit the lesson, not this file.
package module07.lesson08.example01;

public class Main {

    public static void main(
            String[] args
    ) {
        CourseStatus status =
                CourseStatus.PUBLISHED;

        String message =
                description(
                        status
                );

        System.out.println(
                message
        );
    }

    static String description(
            CourseStatus status
    ) {
        return switch (status) {
            case DRAFT ->
                    "Course is being prepared.";

            case PUBLISHED ->
                    "Course is available.";

            case ARCHIVED ->
                    "Course is no longer active.";
        };
    }

    enum CourseStatus {
        DRAFT,
        PUBLISHED,
        ARCHIVED
    }
}
