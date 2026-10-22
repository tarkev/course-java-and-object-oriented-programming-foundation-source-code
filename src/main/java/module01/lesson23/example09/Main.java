package module01.lesson23.example09;

public class Main {

    public static void main(String[] args) {
        String rawName = "   md sakib   ";
        String normalizedName = rawName.strip().toUpperCase();

        System.out.println(normalizedName);
    }
}
