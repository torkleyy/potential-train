package observe;

import question.Question;

public interface GameObserver extends ErrorHandler {
    void onRetrieveQuestion(Question q);

    void onAnswerCorrect();

    void onAnswerWrong();
}
