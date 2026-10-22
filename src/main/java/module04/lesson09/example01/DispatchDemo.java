package module04.lesson09.example01;

class Lesson {

    String describe() {
        return "Lesson: " + label();
    }

    String label() {
        return "basic";
    }
}

class VideoClip extends Lesson {

    @Override
    String label() {
        return "video";
    }
}

public class DispatchDemo {

    public static void main(String[] args) {
        Lesson lesson = new VideoClip();
        System.out.println(lesson.describe());
    }
}
