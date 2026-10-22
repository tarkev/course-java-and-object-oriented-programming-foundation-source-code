package module06.lesson04.example02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        int index = Collections.binarySearch(numbers, 30);
        System.out.println(index);
    }
}
