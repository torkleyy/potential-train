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
import observe.Observable;

public class HighscoreModel extends Observable<HighscoreObserver> {

    private List<HighscoreEntry> entries;

    private final String PATH = "highscores.hs";
    private final String SEPARATOR = "::";
    private final int MAX_ENTRIES = 20;

    public HighscoreModel() {
        entries = new ArrayList<>();
        
        load();
    }
    
    /**
     * You cannot add Entries that contain the CharSequence "::"
     * If an entry 
     * @param name The name of the participant
     * @param score The score of the participant
     */
    public void addEntry(String name, int score) {
        if (name.contains(SEPARATOR)) {
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

        save();
    }
    
    /**
     * Returns an Array of all HighscoreEntries in this list.
     */
    public HighscoreEntry[] getElements() {
        HighscoreEntry[] list = new HighscoreEntry[entries.size()];
        return list = entries.toArray(list);
    }
    
    /**
     * Writes the current highscores into a file
     */
    private void save() {
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
            //What here... I still don't fully get your observer schematic
        }
    }

    private void load() {
        try {
            File f = new File(PATH);
            if (!f.exists()) {
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(f));
            String s;
            while ((s = reader.readLine()) != null) {
                int si = s.indexOf(SEPARATOR);
                String name = s.substring(0, si);
                String value = s.substring(si+SEPARATOR.length(), s.length());
                try {
                    
                    int score = Integer.parseInt(value);
                    entries.add(new HighscoreEntry(name, score));
                            
                } catch (NumberFormatException e) {
                    //TODO Entry could not be read
                }
            }
            reader.close();


        } catch (IOException e) {
            //TODO What here... I still don't fully get your observer schematic
        }
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Scores:\n");
        for (HighscoreEntry entry: entries) {
            sb.append(entry.toString()+"\n");
        }
        return sb.toString();
    }
}
