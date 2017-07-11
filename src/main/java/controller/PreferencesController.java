package controller;

import model.PreferencesModel;
import observe.PreferencesObserver;

public class PreferencesController {

    private final PreferencesModel model;

    public PreferencesController(PreferencesObserver observer) {
        model = new PreferencesModel();
        model.addObserver(observer);
    }

    public boolean isMusicEnabled() {
        return model.isMusicEnabled();
    }

    public boolean isSoundsEnabled() {
        return model.isSoundsEnabled();
    }

    public void setMusicEnabled(boolean enabled) {
        model.setMusicEnabled(enabled);
        model.save();
    }

    public void setSoundsEnabled(boolean enabled) {
        model.setSoundsEnabled(enabled);
        model.save();
    }

}
