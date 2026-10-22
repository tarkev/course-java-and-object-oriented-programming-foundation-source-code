package module07.lesson09.example01;

public class Main {

    public static void main(String[] args) {
        CourseSummary first = new CourseSummary("JAVA", "Java Foundation", 300_000);
        CourseSummary second = new CourseSummary("JAVA", "Java Foundation", 300_000);

        System.out.println(first.equals(second));
        System.out.println(first == second);
        System.out.println(first.hashCode() == second.hashCode());
        System.out.println(first);
    }

    record CourseSummary(String code, String title, long priceInPaisa) {
    }
}
