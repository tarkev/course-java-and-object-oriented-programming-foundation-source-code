package module10.lesson09.example08;

public class Main {

    public static void main(String[] args) {
        CreateCourseRequest request =
                new CreateCourseRequest("java-oop", "Java and OOP", 499_000);
        System.out.println(request);

        CourseSummary summary = new CourseSummary(
                new CourseCode("JAVA-OOP"), "Java and OOP", CourseStatus.DRAFT);
        System.out.println(CourseResponse.from(summary));

        try {
            new CreateCourseRequest(" ", "Java", 0);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

record CreateCourseRequest(String code, String title, long priceInPaisa) {

    CreateCourseRequest {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Code is required.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required.");
        }

        if (priceInPaisa < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
    }
}

record CourseCode(String value) {
}

enum CourseStatus {
    DRAFT,
    PUBLISHED
}

record CourseSummary(CourseCode code, String title, CourseStatus status) {
}

record CourseResponse(String code, String title, String status) {

    static CourseResponse from(CourseSummary summary) {
        return new CourseResponse(summary.code().value(), summary.title(),
                summary.status().name());
    }
}
