package controller;

import model.GameModel;
import observe.GameObserver;

public class GameController {

    private GameModel model;

    public GameController(GameObserver observer) {
        model = new GameModel();
        model.addObserver(observer);
    }

    /**
     * Requests the GameModel to send you the next Quesiton.
     * When the method registerAnswer is called with the correct answer index, the
     * next Question will automatically be sent.
     */
    public void requestQuestion() {
        model.requestQuestion();
    }

    public int getScore() {
        return model.getScore();
    }

    public void registerAnswer(int id) {
        model.registerAnswer(id);
    }

    public void addObserver(GameObserver observer) {
        model.addObserver(observer);
    }
}
