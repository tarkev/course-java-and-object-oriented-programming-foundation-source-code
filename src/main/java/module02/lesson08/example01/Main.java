// Generated from modules/02-methods-arrays-and-program-structure/08-introduction-to-recursion.md by tools/extract_code.py. Edit the lesson, not this file.
package module02.lesson08.example01;

public class Main {

    public static void main(String[] args) {
        countDown(5);
    }

    static void countDown(int number) {
        if (number == 0) {
            return;
        }

        System.out.println(number);

        countDown(number - 1);
    }
}
