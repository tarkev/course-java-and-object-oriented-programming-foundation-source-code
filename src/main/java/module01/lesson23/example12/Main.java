package module01.lesson23.example12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine().strip();
        System.out.print("Enter unit price: ");
        double unitPrice = Double.parseDouble(scanner.nextLine().strip());
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine().strip());

        double subtotal = unitPrice * quantity;

        System.out.println();
        System.out.println("Product: " + productName);
        System.out.println("Unit price: " + unitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Subtotal: " + subtotal);

        scanner.close();
    }
}
