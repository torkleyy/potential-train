package potentialtrain;

import java.util.ArrayList;
import java.util.List;

import question.Question;

public class Main {
    public static void main(String[] args) {
    	String question = "Frage?";
    	List<String> answers = new ArrayList<>(3);
    	
    	answers.set(0, "Antwort1. Richtige");
    	answers.set(1, "Antwort2");
    	answers.set(2, "Antwort3");
    	
    	for (int i = 0; i < 10; i++) {
    		Question q = new Question(question, answers);
    		System.out.println(q.toString());
    	}
    }
}
