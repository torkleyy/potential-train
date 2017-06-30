package model;

import java.util.Random;

import observe.GameObserver;
import observe.Observable;
import question.Question;
import database.DatabaseConnector;

public class GameModel extends Observable<GameObserver> {

    private final DatabaseConnector connector;

    private Question[] questionlist;
    private int currentquestion;

    private int score;
    private final int POINTS_PER_QUESTION = 1;

    public GameModel() {
        this.connector = new DatabaseConnector();
        currentquestion = -1;
        score = 0;
        Question[] all = connector.getAllQuestions();
        questionlist = new Question[all.length];

        // Shuffle the Questions
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
        // Shuffle complete.

    }

    /**
     * @return The next question in the list or null,
     * if there are no more questions available
     */
    public Question getNextQuestion() {
        currentquestion++;
        if (currentquestion >= questionlist.length) {
            return null;
        }
        return questionlist[currentquestion];
    }

    /**
     * Registers the given answer. The id represents the index of the given
     * answer in the question instance, which means the allowed range is 0-2.
     * 
     * @return true, if the given index is the index of the correct answer,
     *         false otherwise.
     */
    public boolean registerAnswer(int index) {
        if (questionlist[currentquestion].isCorrectAnswer(index)) {
            //TODO Possibly do other things...
            score += POINTS_PER_QUESTION;
            return true;
        }
        return false;
    }
}
