package module02.lesson11.example06;

public class Main {
    public static void main(String[] args) {
        int[][] values = new int[3][];
        values[0] = new int[2];
        values[1] = new int[4];
        values[2] = new int[1];

        for (int row = 0; row < values.length; row++) {
            System.out.println("Row " + row + ": " + values[row].length);
        }
    }
}
