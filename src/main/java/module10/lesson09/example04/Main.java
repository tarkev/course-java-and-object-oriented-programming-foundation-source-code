package module10.lesson09.example04;

public class Main {

    public static void main(String[] args) {
        LessonId x = new LessonId(7);
        LessonId y = new LessonId(7);
        LessonId z = new LessonId(7);

        System.out.println("Reflexive: " + x.equals(x));
        System.out.println("Symmetric: " + (x.equals(y) && y.equals(x)));
        System.out.println("Transitive: "
                + (x.equals(y) && y.equals(z) && x.equals(z)));
        System.out.println("Consistent: " + (x.equals(y) && x.equals(y)));
        System.out.println("Not null: " + !x.equals(null));
        System.out.println("Same hash: " + (x.hashCode() == y.hashCode()));
        System.out.println(x);
    }
}

final class LessonId {

    private final long value;

    LessonId(long value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Lesson id must be positive.");
        }

        this.value = value;
    }

    long value() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        return other instanceof LessonId id && value == id.value;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(value);
    }

    @Override
    public String toString() {
        return "LessonId[" + value + "]";
    }
}
