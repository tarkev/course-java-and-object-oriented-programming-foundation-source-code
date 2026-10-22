package module08.lesson06.example01.validation;

public record ValidationError(
        String field, String code, String message) {

    public ValidationError {
        if (field == null || field.isBlank()) {
            throw new IllegalArgumentException("Validation field is required.");
        }

        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Validation code is required.");
        }

        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Validation message is required.");
        }
    }
}
