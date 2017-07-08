package observe;

public interface GameObserver extends ErrorHandler {
    void onRetrieveQuestion();
    void onAnswerCorrect();
    void onAnswerWrong();
}
