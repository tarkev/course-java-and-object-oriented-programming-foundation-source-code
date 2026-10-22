// Generated from modules/08-enums-exceptions-and-robust-error-handling/04-checked-vs-unchecked-exceptions.md by tools/extract_code.py. Edit the lesson, not this file.
package module08.lesson04.example01.content;

public final class CourseContentLoadException
        extends RuntimeException {

    public CourseContentLoadException(
            String message
    ) {
        super(
                message
        );
    }

    public CourseContentLoadException(
            String message,
            Throwable cause
    ) {
        super(
                message,
                cause
        );
    }
}
