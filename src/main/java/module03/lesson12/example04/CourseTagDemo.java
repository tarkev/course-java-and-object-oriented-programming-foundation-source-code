package module03.lesson12.example04;

class CourseTag {

    private final String name;

    CourseTag(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CourseTag tag = (CourseTag) other;
        return name.equals(tag.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "#" + name;
    }
}

public class CourseTagDemo {

    public static void main(String[] args) {
        CourseTag first = new CourseTag("java");
        CourseTag second = new CourseTag("java");
        System.out.println(first == second);
        System.out.println(first.equals(second));
        System.out.println("Tag: " + first);
    }
}
