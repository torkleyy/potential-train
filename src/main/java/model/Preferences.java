package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Preferences {

    private boolean musicEnabled  = true;
    private boolean soundsEnabled = true;

    public Preferences() {

    }

    @XmlElement
    public boolean isMusicEnabled() {
        return musicEnabled;
    }
    @XmlElement
    public boolean isSoundsEnabled() {
        return soundsEnabled;
    }

    public void setMusicEnabled(boolean enabled) {
        musicEnabled = enabled;
    }
    public void setSoundsEnabled(boolean enabled) {
        soundsEnabled = enabled;
    }

    @Override
    public String toString() {
        return "Preferences{" +
                "musicEnabled=" + musicEnabled +
                ", soundsEnabled=" + soundsEnabled +
                '}';
    }
}
