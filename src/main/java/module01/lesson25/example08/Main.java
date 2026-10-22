package module01.lesson25.example08;

public class Main {

    public static void main(String[] args) {
        int number = 1;
        while (number <= 5) {
            if (number == 3) {
                number++;
                continue;
            }
            System.out.println(number);
            number++;
        }
    }
}
