// Generated from modules/02-methods-arrays-and-program-structure/04-introduction-to-arrays.md by tools/extract_code.py. Edit the lesson, not this file.
package module02.lesson04.example02;

public class Main {

    public static void main(String[] args) {
        String[] courses = {
                "Java and OOP Foundation", "Backend Development", "System Design"
        };

        System.out.println("Number of courses: " + courses.length);

        System.out.println("First course: " + courses[0]);

        System.out.println("Last course: " + courses[courses.length - 1]);

        courses[2] = "Advanced System Design";

        System.out.println("Updated course: " + courses[2]);
    }
}
