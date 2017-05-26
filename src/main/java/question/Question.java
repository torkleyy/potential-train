package question;

import java.util.List;
import java.util.Random;

public class Question {

    /**
     * All applicable answers for this question.
     */
    private Answer[] answers;
    /**
     * The id of the correct answer.
     * It matched the index of this answer in the array
     */
    private int correctAnswer;
    private String question;

    /**
     * @param answers The first element in this list is considered as the correct answer
     */
    public Question(String question, List<String> answers) {
        this.question = question;
        this.answers = new Answer[answers.size()];

        // sort the answers in random order
        int[] values = new int[answers.size()];
        Random r = new Random();
        for (int i = 0; i < answers.size(); i++) {
            values[i] = r.nextInt(10000);
        }

        for (int i = 0; i < answers.size(); i++) {
            int smallest = values[0];
            int index = 0;
            for (int j = 1; j < values.length; j++) {
                if (values[j] < smallest) {
                    smallest = values[j];
                    index = j;
                }
            }
            values[index] = Integer.MAX_VALUE;
            if (index == 0) correctAnswer = i;
            this.answers[i] = new Answer(answers.get(index), i);
        }
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public boolean isCorrectAnswer(int id) {
        return id == correctAnswer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Question: " + question);
        for (Answer a : answers) {
            sb.append("\n  Answer: ").append(a.toString());
        }
        return sb.toString();
    }
}
