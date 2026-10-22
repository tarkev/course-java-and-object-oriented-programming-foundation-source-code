// Generated from modules/01-programming-and-java-fundamentals/19-break-continue-and-loop-control.md by tools/extract_code.py. Edit the lesson, not this file.
package module01.lesson19.example01;

public class Main {

    public static void main(String[] args) {
        String text = "Production Java";

        char target = 'J';

        int foundIndex = -1;

        for (int index = 0; index < text.length(); index++) {
            if (text.charAt(index) != target) {
                continue;
            }

            foundIndex = index;

            break;
        }

        if (foundIndex >= 0) {
            System.out.println("Found at index: " + foundIndex);
        } else {
            System.out.println("Character not found");
        }
    }
}
