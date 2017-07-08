package database;

import org.junit.Before;
import org.junit.Test;

import question.Question;

public class DatabaseTester {

    private DatabaseConnector c = DatabaseConnector.getInstance();

    @Test
    public void testGetQuestions() {
        for (Question q: c.getAllQuestions()) {
            System.out.println(q.toString());
        }
    }

}
