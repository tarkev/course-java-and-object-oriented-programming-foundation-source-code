package module01.lesson23.example22;

public class Main {

    public static void main(String[] args) {
        int dayNumber = 6;

        String dayType = switch (dayNumber) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };
        System.out.println(dayType);
    }
}
