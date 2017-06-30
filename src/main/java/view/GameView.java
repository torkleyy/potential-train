package view;

import controller.GameController;
import observe.GameObserver;

public class GameView implements GameObserver {

    private final GameController controller;

    public GameView(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onAnswerCorrect() {

    }

    @Override
    public void onAnswerWrong() {

    }
}
