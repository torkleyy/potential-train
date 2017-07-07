package model;

public class HighscoreEntry {
    
    private String name;
    private int score;
    
    HighscoreEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    
    @Override
    public String toString() {
        return (name+": "+score);
    }
}
