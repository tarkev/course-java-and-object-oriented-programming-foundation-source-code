// Generated from modules/03-object-oriented-programming-foundations/08-composition-and-object-relationships.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson08.example01;

public class Main {

    public static void main(String[] args) {
        Learner jalisa = new Learner(1L, "Jalisa", "jalisa@example.com");

        Course javaCourse = new Course("JAVA", "Java and OOP Foundation", 20);

        javaCourse.publish();

        Enrollment enrollment = new Enrollment(jalisa, javaCourse);

        enrollment.completeLessons(8);

        System.out.println("Learner: " + enrollment.getLearner().getName());

        System.out.println("Course: " + enrollment.getCourse().getTitle());

        System.out.println(
                "Progress: " + enrollment.calculateProgress() + "%");

        System.out.println(
                "Remaining lessons: " + enrollment.calculateRemainingLessons());
    }
}
