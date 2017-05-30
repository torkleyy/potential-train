package view;

import controller.PreferencesController;
import observe.PreferencesObserver;

public class PreferencesView implements PreferencesObserver {
    private final PreferencesController controller;

    public PreferencesView(PreferencesController controller) {
        this.controller = controller;
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onVolumeChanged(int volume) {

    }
}
