package module04.lesson02.example01;

public class Main {

    public static void main(String[] args) {
        VideoLesson videoLesson = new VideoLesson(1L, "Parent Construction",
                        "https://cdn.tarkev.com/videos/super",
                        15);

        videoLesson.publish();

        System.out.println(videoLesson.getId());
        System.out.println(videoLesson.getTitle());
        System.out.println(videoLesson.isPublished());
        System.out.println(videoLesson.getVideoUrl());
    }
}
