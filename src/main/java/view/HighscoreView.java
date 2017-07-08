package view;

import controller.HighscoreController;
import model.HighscoreEntry;
import observe.HighscoreObserver;

public class HighscoreView implements HighscoreObserver {
    private final HighscoreController controller;

    public HighscoreView(HighscoreController controller) {
        this.controller = controller;
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onRetrieveScores(HighscoreEntry[] entries) {

    }
}
