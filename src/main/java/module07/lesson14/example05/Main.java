package module07.lesson14.example05;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        Function<Course, String> title = Course::title;
        UnaryOperator<String> strip = String::strip;
        UnaryOperator<String> upperCase = String::toUpperCase;

        Function<Course, String> withAndThen = title.andThen(strip).andThen(upperCase);
        Function<Course, String> withCompose = upperCase.compose(strip).compose(title);

        Course course = new Course("  Java Foundation ", 300_000, true);
        System.out.println("[" + withAndThen.apply(course) + "]");
        System.out.println("[" + withCompose.apply(course) + "]");
    }

    record Course(String title, long priceInPaisa, boolean published) {
    }
}
