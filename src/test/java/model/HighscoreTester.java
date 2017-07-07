package model;

import org.junit.Before;
import org.junit.Test;

public class HighscoreTester {
    
    private HighscoreModel model;
    
    @Before
    public void SetUp() {
        model = new HighscoreModel();
    }
    
    @Test
    public void test1() {
        model.addEntry("Hans", 10);
        model.addEntry("J�rgen", 12);
        model.addEntry("Dieter", 8);

        assert (model.toString().equals("Scores:\nHans: 10\nJ�rgen: 12\nDieter: 8\n"));
    }
    
    /*@Test
    public void fileTest() {
        model.addEntry("Hans", 10);
        model.addEntry("J�rgen", 12);
        model.addEntry("Dieter", 8);
        
        model.load();
        
        assert (model.toString().equals("Scores:\nHans: 10\nJ�rgen: 12\nDieter: 8\n"));
    }
    *Removed because HighscoreModel.load() is not public any more.
    */

}
