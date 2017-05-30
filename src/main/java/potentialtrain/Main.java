package potentialtrain;

import java.util.ArrayList;
import java.util.List;

import question.Question;

public class Main {
    public static void main(String[] args) {
        String question = "Frage?";
        List<String> answers = new ArrayList<>(3);

        answers.add("Antwort1. Richtige");
        answers.add("Antwort2");
        answers.add("Antwort3");

        for (int i = 0; i < 10; i++) {
            Question q = new Question(question, answers);
            System.out.println(q.toString());
        }
    }
}
