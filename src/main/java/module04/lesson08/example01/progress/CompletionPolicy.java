package module04.lesson08.example01.progress;

public interface CompletionPolicy {

    boolean isCompleted(int progressPercentage);

    String getDescription();
}
