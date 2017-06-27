package view;

import controller.GameController;
import observe.GameObserver;
import question.Question;

public class GameView implements GameObserver {

    @Override
    public void onError(String message) {

    }

    @Override
    public void onRetrieveQuestion(Question q) {

    }

    @Override
    public void onAnswerCorrect() {

    }

    @Override
    public void onAnswerWrong() {

    }
}
