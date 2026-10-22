package module04.lesson10.example06;

public class Main {

    public static void main(String[] args) {
        CardPayment card = new CardPayment(150_000, "4242");
        BankTransfer transfer = new BankTransfer(250_000, "REF-77");

        printProcess(card);
        printProcess(transfer);
        printProcess(card);
    }

    static void printProcess(Payment payment) {
        System.out.println(payment.process());
    }
}

abstract class Payment {

    private final long amountInPaisa;
    private boolean processed;

    protected Payment(long amountInPaisa) {
        if (amountInPaisa <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }

        this.amountInPaisa = amountInPaisa;
    }

    public abstract String getMethod();

    protected abstract String authorize();

    public final String process() {
        if (processed) {
            return getMethod() + ": already processed";
        }

        processed = true;
        return getMethod() + " " + amountInPaisa + " paisa: " + authorize();
    }
}

class CardPayment extends Payment {

    private final String lastFourDigits;

    public CardPayment(long amountInPaisa, String lastFourDigits) {
        super(amountInPaisa);
        this.lastFourDigits = lastFourDigits;
    }

    @Override
    public String getMethod() {
        return "CARD";
    }

    @Override
    protected String authorize() {
        return "card ending " + lastFourDigits + " approved";
    }
}

class BankTransfer extends Payment {

    private final String reference;

    public BankTransfer(long amountInPaisa, String reference) {
        super(amountInPaisa);
        this.reference = reference;
    }

    @Override
    public String getMethod() {
        return "BANK";
    }

    @Override
    protected String authorize() {
        return "transfer " + reference + " queued";
    }
}
