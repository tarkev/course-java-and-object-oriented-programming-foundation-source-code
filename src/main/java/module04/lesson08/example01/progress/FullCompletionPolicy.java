package module04.lesson08.example01.progress;

public final class FullCompletionPolicy implements CompletionPolicy {

    @Override
    public boolean isCompleted(int progressPercentage) {
        return progressPercentage == 100;
    }

    @Override
    public String getDescription() {
        return "Requires 100% progress";
    }
}
