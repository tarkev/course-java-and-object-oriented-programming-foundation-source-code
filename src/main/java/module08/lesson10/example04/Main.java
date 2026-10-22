package module08.lesson10.example04;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RegisterLearnerRequestValidator validator =
                new RegisterLearnerRequestValidator();
        print(validator.validate(new RegisterLearnerRequest(" ", "nur.example.com", 12)));
        print(validator.validate(new RegisterLearnerRequest("Nur", "nur@example.com", 20)));
    }

    static void print(ValidationResult result) {
        System.out.println("Valid: " + result.isValid());

        for (ValidationError error : result.getErrors()) {
            System.out.println("  " + error.field() + " → " + error.code());
        }
    }
}

record RegisterLearnerRequest(String name, String email, int age) {
}

record ValidationError(String field, String code, String message) {
}

final class ValidationResult {

    private final List<ValidationError> errors = new ArrayList<>();

    public void add(String field, String code, String message) {
        errors.add(new ValidationError(field, code, message));
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    public List<ValidationError> getErrors() {
        return List.copyOf(errors);
    }
}

final class RegisterLearnerRequestValidator {

    public ValidationResult validate(RegisterLearnerRequest request) {
        ValidationResult result = new ValidationResult();

        if (request == null) {
            result.add("request", "REQUEST_REQUIRED", "Request is required.");
            return result;
        }

        if (request.name() == null || request.name().isBlank()) {
            result.add("name", "NAME_REQUIRED", "Name is required.");
        }

        if (request.email() == null || request.email().isBlank()) {
            result.add("email", "EMAIL_REQUIRED", "Email is required.");
        } else if (!request.email().contains("@")) {
            result.add("email", "EMAIL_INVALID", "Email must contain @.");
        }

        if (request.age() < 13) {
            result.add("age", "AGE_TOO_LOW", "Learner must be at least 13.");
        }

        return result;
    }
}
