package module08.lesson06.example01.course;

import module08.lesson06.example01.validation.ValidationResult;

public final class CreateCourseRequestValidator {

    public ValidationResult validate(CreateCourseRequest request) {
        ValidationResult result = new ValidationResult();

        if (request == null) {
            result.add("request", "REQUEST_REQUIRED", "Request is required.");
            return result;
        }

        if (request.code() == null || request.code().isBlank()) {
            result.add(
                    "code", "COURSE_CODE_REQUIRED", "Course code is required.");
        }

        if (request.title() == null || request.title().isBlank()) {
            result.add(
                    "title", "COURSE_TITLE_REQUIRED", "Course title is required.");
        }

        if (request.priceInPaisa() == null) {
            result.add(
                    "priceInPaisa",
                    "COURSE_PRICE_REQUIRED", "Course price is required.");
        } else if (request.priceInPaisa() < 0) {
            result.add(
                    "priceInPaisa",
                    "COURSE_PRICE_NEGATIVE", "Course price cannot be negative.");
        }

        return result;
    }
}
