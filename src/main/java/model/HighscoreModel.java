package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import observe.HighscoreObserver;
import observe.Notifier;
import observe.Observable;

public class HighscoreModel extends Observable<HighscoreObserver> {

    private final List<HighscoreEntry> entries;

    private final String PATH = "highscores.hs";
    private final String SEPARATOR = "::";
    private final int MAX_ENTRIES = 20;

    public HighscoreModel() {
        entries = new ArrayList<>();

        try {
            File f = new File(PATH);
            if (!f.exists()) {
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(f));
            String s;
            while ((s = reader.readLine()) != null) {
                String[] parts = s.split(SEPARATOR);
                String name = parts[0];
                String value = parts[1];
                try {

                    int score = Integer.parseInt(value);
                    entries.add(new HighscoreEntry(name, score));

                } catch (NumberFormatException e) {
                    notifyObservers(new Notifier<HighscoreObserver>() {
                        @Override
                        public void notifyObject(HighscoreObserver obj) {
                            obj.onReceiveMessage("Ein Eintrag in der Highscoreliste konnte nicht gelesen werden.");
                        }
                    });
                }
            }
            reader.close();


        } catch (IOException e) {
            onException(e);
        }
    }
    
    /**
     * You cannot add Entries that contain the CharSequence "::"
<<<<<<< HEAD
     * If you attempt to add an entry which contains this sequence,
     * a message will be sent to the view.
=======
     * If an entry 
>>>>>>> HighscoreModel updated and tested.
     * @param name The name of the participant
     * @param score The score of the participant
     */
    public void addEntry(String name, int score) {
        if (name.contains(SEPARATOR)) {
            notifyObservers(new Notifier<HighscoreObserver>() {
                @Override
                public void notifyObject(HighscoreObserver obj) {
                    obj.onReceiveMessage("Der Name darf die Zeichenfolge \""+SEPARATOR+"\" nicht enthalten.");
                }
            });
            return;
        }

        HighscoreEntry entry = new HighscoreEntry(name, score);
        if (entries.size() == 0) {
            entries.add(entry);
        } else {
            for (int i = 0; i < entries.size()+1; i++) {
                
                if (i == entries.size()) {
                    if (i < MAX_ENTRIES) {
                        entries.add(entry);
                    }
                    break;
                }
                
                if (entries.get(i).getScore() < score) {
                    entries.add(i, entry);
                    break;
                }
            }
            
            if (entries.size() > MAX_ENTRIES) {
                entries.remove(MAX_ENTRIES);
            }
        }
    }
    
    /**
     * Returns an Array of all HighscoreEntries in this list.
     */
    private HighscoreEntry[] getElements() {
        HighscoreEntry[] list = new HighscoreEntry[entries.size()];
        return entries.toArray(list);
    }
    
    /**
     * Writes the current highscores into a file
     */
    public void save() {
        try {
            File f = new File(PATH);
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            for (HighscoreEntry entry: entries) {
                writer.write(entry.getName() + SEPARATOR + entry.getScore()+"\n");
            }
            writer.close();

        } catch (IOException e) {
            onException(e);
        }
    }

    private void onException(Exception e) {
        e.printStackTrace();
        notifyObservers(new Notifier<HighscoreObserver>() {
            @Override
            public void notifyObject(HighscoreObserver obj) {
                obj.onError("Es ist ein Fehler beim Laden oder Speichern der Highscores aufgetreten.");
            }
        });
    }

    public void requestUpdate() {
        final HighscoreEntry[] elements = getElements();
        notifyObservers(new Notifier<HighscoreObserver>() {
            @Override
            public void notifyObject(HighscoreObserver obj) {
                obj.onRetrieveScores(elements);
            }
        });
    }

    @Override
    public String toString() {
        return "HighscoreModel{" +
                "entries=" + entries.toString() +
                '}';
    }
}
