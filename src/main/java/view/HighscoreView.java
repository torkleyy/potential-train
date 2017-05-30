package view;

import controller.HighscoreController;
import observe.HighscoreObserver;

public class HighscoreView implements HighscoreObserver {
    private final HighscoreController controller;

    public HighscoreView(HighscoreController controller) {
        this.controller = controller;
    }
}
