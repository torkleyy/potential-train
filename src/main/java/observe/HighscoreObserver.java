package observe;

import model.HighscoreEntry;

public interface HighscoreObserver extends ErrorHandler {

    public void onRetrieveScores(HighscoreEntry[] entries);

    public void onReceiveMessage(String message);

}
