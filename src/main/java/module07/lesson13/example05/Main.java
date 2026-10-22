package module07.lesson13.example05;

public class Main {

    sealed interface Pass permits Basic, Premium {
    }

    record Basic() implements Pass {
    }

    record Premium(int months) implements Pass {
    }

    static String describe(Pass pass) {
        return switch (pass) {
            case Premium premium when premium.months() >= 12 -> "Yearly premium";
            case Premium premium -> premium.months() + "-month premium";
            case Basic basic -> "Basic";
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(new Premium(12)));
        System.out.println(describe(new Premium(3)));
        System.out.println(describe(new Basic()));
    }
}
