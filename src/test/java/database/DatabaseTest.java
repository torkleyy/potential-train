package database;

import org.junit.Test;

import question.Question;

public class DatabaseTest {
    
    private DatabaseConnector connector = new DatabaseConnector();
    
    @Test
    public void test() {
	Question[] questions = connector.getAllQuestions();
	for (Question q: questions) {
	    System.out.println(q);
	}
    }

}
