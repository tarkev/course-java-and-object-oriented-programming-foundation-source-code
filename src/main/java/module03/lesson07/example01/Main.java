// Generated from modules/03-object-oriented-programming-foundations/07-object-references-null-identity-equality-and-tostring.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson07.example01;

public class Main {

    public static void main(String[] args) {
        Course first = new Course("java", "Java Foundation");

        Course second = new Course("JAVA", "Java and OOP Foundation");

        Course third = first;

        System.out.println(first == second);

        System.out.println(first.equals(second));

        System.out.println(first == third);

        first.publish();

        System.out.println(first);

        System.out.println(second);
    }
}
