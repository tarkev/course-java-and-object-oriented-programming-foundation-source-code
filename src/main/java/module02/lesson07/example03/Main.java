// Generated from modules/02-methods-arrays-and-program-structure/07-the-arrays-utility-class-and-common-array-operations.md by tools/extract_code.py. Edit the lesson, not this file.
package module02.lesson07.example03;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] first = {"JAVA", "BACKEND"};

        String[] second = {"JAVA", "BACKEND"};

        System.out.println(first == second);

        System.out.println(Arrays.equals(first, second));
    }
}
