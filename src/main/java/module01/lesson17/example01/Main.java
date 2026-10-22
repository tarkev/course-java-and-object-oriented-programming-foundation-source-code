// Generated from modules/01-programming-and-java-fundamentals/17-for-loops.md by tools/extract_code.py. Edit the lesson, not this file.
package module01.lesson17.example01;

public class Main {

    public static void main(String[] args) {
        int total = 0;
        int evenCount = 0;

        for (int number = 1; number <= 10; number++) {
            total += number;

            if (number % 2 == 0) {
                evenCount++;
            }
        }

        double average = total / 10.0;

        System.out.println("Total: " + total);

        System.out.println("Average: " + average);

        System.out.println("Even numbers: " + evenCount);
    }
}
