package observe;

public interface PreferencesObserver extends ErrorHandler {
    void onVolumeChanged(int volume);
}
