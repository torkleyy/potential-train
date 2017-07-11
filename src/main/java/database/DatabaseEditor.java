package database;

import question.Question;

import java.util.ArrayList;

public final class DatabaseEditor {

    private static DatabaseConnector con = DatabaseConnector.getInstance();

    public static void main(String[] args) {
        /*
				"Herr Kroegers lieblings Fortbewegungsmittel ist, dass...",
				"Fahrrad",
				"Auto",
				"Skateboard");*/
    }


    public static void addQuestion(String question, String a1, String a2, String a3) {
        ArrayList<String> list = new ArrayList<>(3);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        con.addQuestion(new Question(question, list));
    }
}
