package module06.lesson04.example03;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] courseCodes = {
                "ALGORITHMS", "BACKEND", "JAVA", "SYSTEM-DESIGN"
        };
        String target = "JAVA";

        int index = Arrays.binarySearch(courseCodes, target);

        if (index >= 0) {
            System.out.println(target + " found at index " + index);
        } else {
            System.out.println(target + " not found");
        }
    }
}
