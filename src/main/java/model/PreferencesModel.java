package model;

import java.io.*;

import observe.Notifier;
import observe.Observable;
import observe.PreferencesObserver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PreferencesModel extends Observable<PreferencesObserver> {

    private boolean musicEnabled  = true;
    private boolean soundsEnabled = true;

    private final String PATH = "preferences.xml";

    /**
     * This variable has to prevent the algorithm to enter an infite loop as during the loading process
     * a temporal PreferencesModel-instance will be created which would itself call the loading process again.
     * Which means, the first PreferencesModel sets this variable to 'true' in order to prevent the other Models
     * from loading the file again.
     */
    private static boolean objectcreating = false;
    
    public PreferencesModel() {

        if (!objectcreating) {

            objectcreating = true;
            try {

                File file = new File(PATH);

                if (file.exists()) {

                    JAXBContext jaxbContext = JAXBContext.newInstance(PreferencesModel.class);

                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    PreferencesModel obj = (PreferencesModel) jaxbUnmarshaller.unmarshal(file);

                    musicEnabled = obj.isMusicEnabled();
                    soundsEnabled = obj.isSoundsEnabled();
                } else {
                    save();
                }

            } catch (Exception e) {
                onException(e);
            }
            objectcreating = false;
        }


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
        save();
    }
    public void setSoundsEnabled(boolean enabled) {
        soundsEnabled = enabled;
        save();
    }

    
    private void save() {
        try {
            JAXBContext  contextObj = JAXBContext.newInstance(PreferencesModel.class);
            Marshaller marshallerObj = contextObj.createMarshaller();

            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(this, new FileOutputStream(PATH));

        } catch (Exception e) {
            onException(e);
        }
    }

    private void onException(Exception e) {
        e.printStackTrace();
        notifyObservers(new Notifier<PreferencesObserver>() {
            @Override
            public void notifyObject(PreferencesObserver obj) {
                obj.onError("Es ist ein Fehler beim Laden oder Speichern der Einstellungen aufgetreten.");
            }
        });
    }

    @Override
    public String toString() {
        return "PreferencesModel{" +
                "musicEnabled=" + musicEnabled +
                ", soundsEnabled=" + soundsEnabled +
                '}';
    }
}
