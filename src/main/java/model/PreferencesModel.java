package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import observe.Observable;
import observe.PreferencesObserver;

public class PreferencesModel extends Observable<PreferencesObserver> {

    public boolean musicEnabled;
    public boolean soundsEnabled;

    private final String PATH = "preferences.pf";
    
    public PreferencesModel() {
        musicEnabled = true;
        soundsEnabled = true;
        
        load();
    }
    
    public boolean getMusicEnabled() {
        return musicEnabled;
    }
    public boolean getSoundsEnabled() {
        return soundsEnabled;
    }
    
    public void setMusicEnabled(boolean enabled) {
        musicEnabled = enabled;
        save();
    }
    public void setSoundsEnabled(boolean enabled) {
        soundsEnabled = enabled;
        save();
    }
    
    private void load() {
        try {
            File f = new File(PATH);
            if (!f.exists()) {
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(f));
            String s = reader.readLine();
            
            if (s != null && s.length() > 1) {
                if (s.charAt(0) == 'f') {
                    musicEnabled = false;
                }
                if (s.charAt(1) == 'f') {
                    soundsEnabled = false;
                }
            }
            
            reader.close();


        } catch (IOException e) {
            //TODO What here... I still don't fully get your observer schematic
        }
    }
    
    private void save() {
        try {
            File f = new File(PATH);
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            
            if (musicEnabled) {
                writer.write("t");
            } else {
                writer.write("f");
            }
            if (soundsEnabled) {
                writer.write("t");
            } else {
                writer.write("f");
            }
            
            writer.close();
            
        } catch (IOException e) {
            //What here... I still don't fully get your observer schematic
        }
    }

}
