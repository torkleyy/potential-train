package controller;

import model.PreferencesModel;

public class PreferencesController {
    
    private final PreferencesModel model;
    
    public PreferencesController() {
        model = new PreferencesModel();
    }
    
    public boolean getMusicEnabled() {
        return model.getMusicEnabled();
    }
    public boolean getSoundsEnabled() {
        return model.getSoundsEnabled();
    }
    
    public void setMusicEnabled(boolean enabled) {
        model.setMusicEnabled(enabled);
    }
    public void setSoundsEnabled(boolean enabled) {
        model.setSoundsEnabled(enabled);
    }
    
}
