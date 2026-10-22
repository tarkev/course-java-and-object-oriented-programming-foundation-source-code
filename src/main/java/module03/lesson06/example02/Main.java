// Generated from modules/03-object-oriented-programming-foundations/06-static-and-instance-members.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson06.example02;

public class Main {

    public static void main(String[] args) {
        Course javaCourse = new Course("Java and OOP Foundation", 20, 0);

        Course backendCourse =
                new Course("Backend Development", 30, 799_000L);

        backendCourse.publish();

        long discountedPrice = backendCourse.calculateDiscountedPrice(20);

        System.out.println(
                "Created courses: " + Course.getTotalCoursesCreated());

        System.out.println(
                "Maximum title length: " + Course.MAX_TITLE_LENGTH);

        System.out.println("Java price: " + javaCourse.getPriceInPaisa());

        System.out.println("Backend discounted price: " + discountedPrice);

        System.out.println(
                "Backend published: " + backendCourse.isPublished());
    }
}
