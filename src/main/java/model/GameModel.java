package model;

import java.util.Random;

import observe.GameObserver;
import observe.Observable;
import question.Question;
import database.DatabaseConnector;

public class GameModel extends Observable<GameObserver> {
	
    private final DatabaseConnector connector;
    
    private Question[] questionlist;
    

    public GameModel() {
        this.connector = new DatabaseConnector();
        Question[] all = connector.getAllQuestions();
        questionlist = new Question[all.length];
        
        
        //Shuffle the Questions
        int[] values = new int[all.length];
        Random r = new Random();
        for (int i = 0; i < all.length; i++) {
            values[i] = r.nextInt(10000);
        }

        for (int i = 0; i < all.length; i++) {
            int smallest = values[0];
            int index = 0;
            for (int j = 1; j < values.length; j++) {
                if (values[j] < smallest) {
                    smallest = values[j];
                    index = j;
                }
            }
            values[index] = Integer.MAX_VALUE;
            questionlist[i] = all[index];
        }
        //Shuffle complete.
        
    }
}
