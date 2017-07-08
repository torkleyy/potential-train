package controller;

import model.PreferencesModel;

public class PreferencesController {
    
    private final PreferencesModel model;
    
    public PreferencesController() {
        model = new PreferencesModel();
    }
    
    public boolean isMusicEnabled() {
        return model.isMusicEnabled();
    }
    public boolean isSoundsEnabled() {
        return model.isSoundsEnabled();
    }
    
    public void setMusicEnabled(boolean enabled) {
        model.setMusicEnabled(enabled);
    }
    public void setSoundsEnabled(boolean enabled) {
        model.setSoundsEnabled(enabled);
    }
    
}
