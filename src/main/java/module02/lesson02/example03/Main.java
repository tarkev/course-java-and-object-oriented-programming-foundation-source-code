// Generated from modules/02-methods-arrays-and-program-structure/02-parameters-arguments-and-return-values.md by tools/extract_code.py. Edit the lesson, not this file.
package module02.lesson02.example03;

public class Main {

    public static void main(String[] args) {
        int value = multiply(add(2, 3), 4);

        System.out.println(value);
    }

    static int add(int first, int second) {
        return first + second;
    }

    static int multiply(int first, int second) {
        return first * second;
    }
}
