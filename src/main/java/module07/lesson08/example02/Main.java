package module07.lesson08.example02;

public class Main {

    sealed interface PaymentResult permits PaymentSucceeded, PaymentFailed {
    }

    record PaymentSucceeded(String paymentId, long amountInPaisa) implements PaymentResult {
    }

    record PaymentFailed(String reason) implements PaymentResult {
    }

    static String describe(PaymentResult result) {
        return switch (result) {
            case PaymentSucceeded success ->
                    "Paid " + success.amountInPaisa() + " paisa: " + success.paymentId();
            case PaymentFailed failure -> "Payment failed: " + failure.reason();
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(new PaymentSucceeded("PAY-1001", 499900)));
        System.out.println(describe(new PaymentFailed("Card declined")));
    }
}
