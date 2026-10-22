package module05.lesson11.example02;

public class Main {
    public static void main(String[] args) {
        KeyValue<Long, String> learner = new KeyValue<>(1L, "Nur");
        Long learnerId = learner.getKey();
        String learnerName = learner.getValue();
        System.out.println(learnerId + " -> " + learnerName);

        KeyValue<String, Course> entry = new KeyValue<>("JAVA-101", new Course("Java Basics"));
        String code = entry.getKey();
        Course course = entry.getValue();
        System.out.println(code + " -> " + course.getTitle());
    }
}

final class KeyValue<K, V> {
    private final K key;
    private final V value;

    KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }
}

final class Course {
    private final String title;

    Course(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }
}
