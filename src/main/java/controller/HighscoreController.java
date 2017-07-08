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

    /**
     * Requests the HighscoreModel to send you the current list of HighscoreEntries
     */
    public void requestUpdate() {
        model.requestUpdate();
    }
}
