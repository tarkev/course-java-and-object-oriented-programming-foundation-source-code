// Generated from modules/02-methods-arrays-and-program-structure/02-parameters-arguments-and-return-values.md by tools/extract_code.py. Edit the lesson, not this file.
package module02.lesson02.example01;

public class Main {

    public static void main(String[] args) {
        greet("Sakib");
        greet("Subu");
        greet("Sumu");
    }

    static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
