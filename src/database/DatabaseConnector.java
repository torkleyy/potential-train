package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector implements AutoCloseable {
	
	private final String DEFAULT_DATABASE = "question_library";
	
	private Connection con;

	public DatabaseConnector() {
	    establishConnection();
	}

	/**
	 * Establishes a Connection to the Database
	 * @param databasename The Name of the database to connect to
	 * @return true, if the connection was successfully established
	 * or false, if an Exception occurred
	 */
	private void establishConnection() {
	    try {
		if (con != null && !con.isClosed()) {
		    con.close();
		}

		Class.forName ("org.hsqldb.jdbcDriver").newInstance();

		con = DriverManager. getConnection("jdbc:hsqldb:"+DEFAULT_DATABASE);
	    } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		e.printStackTrace();
	    }
	}

	@Override
	public void close() throws Exception {
	    if (con != null && !con.isClosed()) {
		con.close();
	    }
	}

}
