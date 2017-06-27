package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import question.Answer;
import question.Question;

public class DatabaseConnector implements AutoCloseable {

	private final String DEFAULT_TABLE_NAME = "questions";

	private final String FILE_LOCATION = "database"+File.separator;

	private final String COLUMN_QUESTION = "Question";
	private final String[] COLUMN_ANSWER = new String[] { "Answer1", "Answer2", "Answer3" };

	private Connection con;

	public DatabaseConnector() {
		establishConnection();
	}

	public void setupTable(Statement stmt) throws SQLException {
		System.out.println("Creating database table!");
		String create_str;
		create_str = "CREATE TABLE "+DEFAULT_TABLE_NAME+" ( " +
				"Question_Key INTEGER NOT NULL PRIMARY KEY IDENTITY, " +
				COLUMN_QUESTION + " VARCHAR(255), "  +
				COLUMN_ANSWER[0] + " VARCHAR(255), "  +
				COLUMN_ANSWER[1] + " VARCHAR(255), "  +
				COLUMN_ANSWER[2] + " VARCHAR(255))";
		stmt.executeUpdate(create_str);
	}

	/**
	 * Establishes a Connection to the Database
	 *
	 * @param databasename The Name of the database to connect to
	 * @return true, if the connection was successfully established
	 * or false, if an Exception occurred
	 */
	private void establishConnection() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}

			Class.forName("org.hsqldb.jdbcDriver").newInstance();

			con = DriverManager.getConnection("jdbc:hsqldb:file:"+FILE_LOCATION+DEFAULT_TABLE_NAME);

		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads all the question elements in the database
	 * and returns them as an array
	 *
	 * @return An array containing all of the questions stored in the database
	 * or null if an exception occurred
	 */
	public Question[] getAllQuestions() {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM " + DEFAULT_TABLE_NAME);

			List<Question> questions = new ArrayList<>();
			while (rs.next()) {
				List<String> answers = new ArrayList<>();
				for (int i = 0; i < 3; i++) {
					answers.add(rs.getString(COLUMN_ANSWER[i]));
				}
				questions.add(new Question(
						rs.getString(COLUMN_QUESTION),
						answers));

			}
			rs.close();
			stmt.close();

			return questions.toArray(new Question[questions.size()]);
		} catch (SQLException e) {
			onSQLException(e);
			return null;
		}
	}

	/**
	 * Removes a question from the database
	 *
	 * @param q The question to be removed
	 */
	public void removeQuestion(Question q) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"DELETE FROM " + DEFAULT_TABLE_NAME
					+ "WHERE "
					+ "(" + COLUMN_QUESTION + "='" + q.getQuestion() + "');");
			stmt.close();
		} catch (SQLException e) {
			onSQLException(e);
		}
	}

	/**
	 * Inserts a new question into the database
	 *
	 * @param q The new question
	 */
	public void addQuestion(Question q) {
		try {
			Statement stmt = con.createStatement();

			//The correct answer is set as the first element in the array
			Answer[] answer = q.getAnswers();
			int correct = -1;
			for (int i = 0; i < answer.length; i++) {
				if (q.isCorrectAnswer(answer[i].getId())) {
					correct = i;
					break;
				}
			}
			if (correct != 0) {
				Answer correctanswer = answer[correct];
				answer[correct] = answer[0];
				answer[0] = correctanswer;
			}

			stmt.executeUpdate(
					"INSERT INTO " + DEFAULT_TABLE_NAME
					+ "(" + COLUMN_QUESTION + ", " + COLUMN_ANSWER[0] + ", " + COLUMN_ANSWER[1] + ", " + COLUMN_ANSWER[2] + ")"
					+ "VALUES "
					+ "('" + q.getQuestion() + "', '" + answer[0] + "', '" + answer[1] + "', '" + answer[2] + "');");
			stmt.close();
		} catch (SQLException e) {
			onSQLException(e);
		}
	}

	@Override
	public void close() throws Exception {
		if (!con.isClosed()) {
			con.close();
		}
	}

	private void onSQLException(SQLException e) {
		e.printStackTrace();//TODO uncool
	}

}