package model;

import observe.Notifier;
import observe.Observable;
import observe.PreferencesObserver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;

public class PreferencesModel extends Observable<PreferencesObserver> {

    private Preferences prefs;
    private final String PATH = "preferences.xml";


    public PreferencesModel() {
        try {
            File file = new File(PATH);

            if (file.exists()) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Preferences.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                prefs = (Preferences) jaxbUnmarshaller.unmarshal(file);


            } else {
                prefs = new Preferences();
                save();
            }
        } catch (Exception e) {
            onException(e);
        }
    }

    public boolean isMusicEnabled() {
        return prefs.isMusicEnabled();
    }

    public boolean isSoundsEnabled() {
        return prefs.isSoundsEnabled();
    }

    public void setMusicEnabled(boolean enabled) {
        prefs.setMusicEnabled(enabled);
    }

    public void setSoundsEnabled(boolean enabled) {
        prefs.setSoundsEnabled(enabled);
    }


    public void save() {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(Preferences.class);
            Marshaller marshallerObj = contextObj.createMarshaller();

            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(prefs, new FileOutputStream(PATH));

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
                "prefs=" + prefs +
                '}';
    }
}
