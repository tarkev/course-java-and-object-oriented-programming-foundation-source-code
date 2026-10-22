package module08.lesson08.example06;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        for (PaymentStatus status : PaymentStatus.values()) {
            System.out.println(status + " is stored as " + status.getCode());
        }

        System.out.println(PaymentStatus.fromCode("paid"));
        System.out.println(PaymentStatus.fromCode("unknown"));
    }
}

enum PaymentStatus {

    PENDING("pending"),
    PAID("paid"),
    FAILED("failed"),
    REFUNDED("refunded");

    private final String code;

    PaymentStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Optional<PaymentStatus> fromCode(String code) {
        for (PaymentStatus status : values()) {
            if (status.code.equals(code)) {
                return Optional.of(status);
            }
        }

        return Optional.empty();
    }
}
