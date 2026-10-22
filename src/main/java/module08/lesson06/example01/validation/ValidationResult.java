package module08.lesson06.example01.validation;

import java.util.ArrayList;
import java.util.List;

public final class ValidationResult {

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
