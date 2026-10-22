package module10.lesson04.example01.content;

public class ArrayRecordDemo {

    record Attachment(String name, byte[] data) {
    }

    public static void main(String[] args) {
        Attachment first = new Attachment("notes.txt", new byte[] {1, 2, 3});
        Attachment second = new Attachment("notes.txt", new byte[] {1, 2, 3});

        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());
    }
}
