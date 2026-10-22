package module02.lesson10.example05;

public class Main {
    public static void main(String[] args) {
        int[][] values = {{1, 2, 3}, {10, 20, 30}};

        int total = 0;
        for (int value : values[1]) {
            total += value;
        }

        System.out.println(total);
    }
}
