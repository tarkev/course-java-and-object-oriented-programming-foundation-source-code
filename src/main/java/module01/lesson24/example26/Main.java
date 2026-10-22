package module01.lesson24.example26;

public class Main {

    public static void main(String[] args) {
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 3; column++) {
                if (column == 2) {
                    break;
                }
                System.out.println(row + ", " + column);
            }
        }
    }
}
