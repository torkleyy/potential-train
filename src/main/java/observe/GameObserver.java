package observe;

public interface GameObserver extends ErrorHandler {
    void onAnswerCorrect();
    void onAnswerWrong();
}
