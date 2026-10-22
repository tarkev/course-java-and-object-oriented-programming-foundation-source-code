// Generated from modules/02-methods-arrays-and-program-structure/03-scope-static-methods-and-method-overloading.md by tools/extract_code.py. Edit the lesson, not this file.
package module02.lesson03.example05;

public class Main {

    public static void main(String[] args) {
        show();
        show();
    }

    static void show() {
        int number = 5;

        number++;

        System.out.println(number);
    }
}
