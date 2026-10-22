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
