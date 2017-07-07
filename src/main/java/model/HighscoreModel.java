package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import observe.HighscoreObserver;
import observe.Observable;

public class HighscoreModel extends Observable<HighscoreObserver> {

    private Map<String, Integer> entries;

    private final String PATH = "highscores.hs";
    private final String SEPARATOR = "::";

    public HighscoreModel() {
        entries = new HashMap<>();
        
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
        if (entries.containsKey(name) && entries.get(name) > score) {
            return;
        } 
        entries.put(name, score);
        save();
    }
    
    /**
     * Writes the current highscores into a file
     */
    private void save() {
        try {
            File f = new File(PATH);
            if (!f.exists()) {
                f.createNewFile();
            }
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            for (String name: entries.keySet()) {
                writer.write(name + SEPARATOR + entries.get(name)+"\n");
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
                    entries.put(name, score);
                            
                } catch (NumberFormatException e) {
                    //TODO Entry could not be read
                }
            }
            reader.close();


        } catch (IOException e) {
            //What here... I still don't fully get your observer schematic
        }
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Scores:\n");
        for (String name: entries.keySet()) {
            sb.append(name + ": "+entries.get(name)+"\n");
        }
        return sb.toString();
    }
}
