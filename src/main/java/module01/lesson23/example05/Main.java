package module01.lesson23.example05;

public class Main {

    public static void main(String[] args) {
        String quantityText = "   5   ";

        int quantity = Integer.parseInt(quantityText.strip());
        System.out.println(quantity * 2);
    }
}
