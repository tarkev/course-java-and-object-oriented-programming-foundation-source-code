// Generated from modules/06-algorithms-and-problem-solving-with-java/04-linear-search-and-binary-search.md by tools/extract_code.py. Edit the lesson, not this file.
package module06.lesson04.example01;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        int index = Arrays.binarySearch(numbers, 30);

        System.out.println(index);
    }
}
