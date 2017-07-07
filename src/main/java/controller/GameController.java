package controller;

import model.GameModel;
import observe.GameObserver;
import question.Question;

public class GameController {
    
    private GameModel model;
    
    public GameController() {
        model = new GameModel();
    }
    
    public Question getNextQuestion() {
        return model.getNextQuestion();
    }
    
    public boolean registerAnswer (int id) {
        return model.registerAnswer(id);
    }
    
    public void addObserver(GameObserver observer) {
        model.addObserver(observer);
    }
}
