package module04.lesson09.example03;

class Badge {

    String name = "badge";

    String label() {
        return "Badge " + name;
    }
}

class GoldBadge extends Badge {

    String name = "gold";

    @Override
    String label() {
        return "Gold " + name;
    }
}

public class FieldDemo {

    public static void main(String[] args) {
        Badge badge = new GoldBadge();
        System.out.println(badge.name);
        System.out.println(badge.label());
    }
}
