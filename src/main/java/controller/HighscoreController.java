package controller;

import model.HighscoreModel;
import observe.HighscoreObserver;

public class HighscoreController {

    private final HighscoreModel model;

    public HighscoreController(HighscoreObserver observer) {
        model = new HighscoreModel();
        model.addObserver(observer);
    }

    public void addEntry(String name, int score) {
        model.addEntry(name, score);
        model.save();
    }

    /**
     * Requests the HighscoreModel to send you the current list of HighscoreEntries
     */
    public void requestUpdate() {
        model.requestUpdate();
    }
}
