package module07.lesson14.example08;

public class Main {

    public static void main(String[] args) {
        System.out.println(new VideoLesson().accessNote());
    }
}

interface Downloadable {

    default String accessNote() {
        return "Available offline";
    }
}

interface Streamable {

    default String accessNote() {
        return "Streams in the browser";
    }
}

class VideoLesson implements Downloadable, Streamable {

    @Override
    public String accessNote() {
        return Downloadable.super.accessNote() + " and " + Streamable.super.accessNote();
    }
}
