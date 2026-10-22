package module01.lesson25.example09;

public class Main {

    public static void main(String[] args) {
        outer:
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 3; column++) {
                if (row == 2 && column == 3) {
                    System.out.println("Found: " + row + ", " + column);
                    break outer;
                }
                System.out.println(row + ", " + column);
            }
        }
        System.out.println("Search finished");
    }
}
