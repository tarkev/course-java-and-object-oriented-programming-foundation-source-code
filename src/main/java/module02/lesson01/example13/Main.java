// Generated from modules/02-methods-arrays-and-program-structure/01-introduction-to-methods.md by tools/extract_code.py. Edit the lesson, not this file.
package module02.lesson01.example13;

public class Main {

    public static void main(String[] args) {
        System.out.println("1");

        first();

        System.out.println("4");
    }

    static void first() {
        System.out.println("2");

        second();
    }

    static void second() {
        System.out.println("3");
    }
}
