package module08.lesson06.example01.course;

import module08.lesson06.example01.validation.ValidationError;
import module08.lesson06.example01.validation.ValidationResult;

public class Main {

    public static void main(String[] args) {
        CreateCourseRequest request =
                new CreateCourseRequest("JAVA-OOP", " ", -500L);

        ValidationResult result =
                new CreateCourseRequestValidator().validate(request);

        System.out.println("Valid: " + result.isValid());

        for (ValidationError error : result.getErrors()) {
            System.out.println(error.field() + " → " + error.code());
        }
    }
}
