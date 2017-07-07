package controller;

import model.HighscoreEntry;
import model.HighscoreModel;

public class HighscoreController {
    
    private HighscoreModel model;
    
    public HighscoreController() {
        model = new HighscoreModel();
    }
    
    public void addEntry(String name, int score) {
        model.addEntry(name, score);
    }
    public HighscoreEntry[] getElements() {
        return model.getElements();
    }
}
