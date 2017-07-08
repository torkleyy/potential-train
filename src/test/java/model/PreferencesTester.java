package model;

import org.junit.Before;
import org.junit.Test;

public class PreferencesTester {

    private PreferencesModel model;

    @Before
    public void SetUp() {
        model = new PreferencesModel();
    }

    @Test
    public void test1() {
        System.out.println(model.toString());
        model.setMusicEnabled(false);
        model.setSoundsEnabled(true);
        model.save();
        System.out.println(model.toString());

    }

}
