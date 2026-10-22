// Generated from modules/08-enums-exceptions-and-robust-error-handling/01-enums-and-domain-states.md by tools/extract_code.py. Edit the lesson, not this file.
package module08.lesson01.example01.course;

public enum CourseStatus {

    DRAFT(
            "Draft"
    ),

    REVIEW(
            "In Review"
    ),

    PUBLISHED(
            "Published"
    ),

    ARCHIVED(
            "Archived"
    );

    private final String displayName;

    CourseStatus(
            String displayName
    ) {
        this.displayName =
                displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isEditable() {
        return this
                == DRAFT
                || this
                == REVIEW;
    }

    public boolean isPubliclyVisible() {
        return this
                == PUBLISHED;
    }

    public boolean isTerminal() {
        return this
                == ARCHIVED;
    }

    public static CourseStatus fromText(
            String value
    ) {
        if (
                value == null
                || value.isBlank()
        ) {
            return null;
        }

        String normalizedValue =
                value.strip()
                        .toUpperCase();

        for (
                CourseStatus status
                : values()
        ) {
            if (
                    status.name()
                            .equals(
                                    normalizedValue
                            )
            ) {
                return status;
            }
        }

        return null;
    }
}
