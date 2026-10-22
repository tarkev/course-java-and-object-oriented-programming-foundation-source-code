package module10.lesson04.example02.content;

public class AttachmentDemo {

    public static void main(String[] args) {
        byte[] bytes = {1, 2, 3};
        Attachment first = new Attachment("notes.txt", bytes);
        Attachment second = new Attachment("notes.txt", new byte[] {1, 2, 3});

        bytes[0] = 99;
        first.data()[1] = 99;

        System.out.println(first);
        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());
    }
}
