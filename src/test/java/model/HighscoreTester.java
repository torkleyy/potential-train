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
        model.addEntry("Jürgen", 12);
        model.addEntry("Dieter", 8);
        model.addEntry("Bauer", 677);
        
        System.out.println(model.toString());
        
        //assert (model.toString().equals("Scores:\nBauer: 677\nJürgen: 12\nHans: 10\nDieter: 8\n"));
    }
    
    /*@Test
    public void fileTest() {
        model.addEntry("Hans", 10);
        model.addEntry("Jürgen", 12);
        model.addEntry("Dieter", 8);
        
        model.load();
        
        assert (model.toString().equals("Scores:\nHans: 10\nJürgen: 12\nDieter: 8\n"));
    }
    *Removed because HighscoreModel.load() is not public any more.
    */

}
