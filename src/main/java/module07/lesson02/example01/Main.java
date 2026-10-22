package module07.lesson02.example01;

public class Main {

    public static void main(String[] args) {
        CourseRule published = Course::published;
        CourseRule featured = published.and(CourseRule.priceAtLeast(500_000L));

        System.out.println(featured.explain(new Course("Java Foundation", 300_000L, true)));
        System.out.println(featured.explain(new Course("System Design", 800_000L, true)));
    }

    @FunctionalInterface
    interface CourseRule {

        boolean test(Course course);

        default CourseRule and(CourseRule other) {
            return course -> test(course) && other.test(course);
        }

        default String explain(Course course) {
            return course.title() + ": " + verdict(test(course));
        }

        static CourseRule priceAtLeast(long minimumInPaisa) {
            return course -> course.priceInPaisa() >= minimumInPaisa;
        }

        private String verdict(boolean passed) {
            return passed ? "yes" : "no";
        }
    }

    record Course(String title, long priceInPaisa, boolean published) {
    }
}
