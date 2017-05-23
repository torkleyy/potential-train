package database;

import java.sql.*;

public class DatabaseConnector {
	
	private final String DEFAULT_DATABASE = "question_library";
	
	private DatabaseErrorHandler errorhandler;
	
	private Connection con;

	public DatabaseConnector() {
		errorhandler = new DatabaseErrorHandler();
	}

	/**
	 * Establishes a Connection to the Database
	 * @param databasename The Name of the database to connect to
	 * @return true, if the connection was successfully established
	 * or false, if an Exception occurred
	 */
	public boolean establishConnection(String databasename) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
			
			Class.forName ("org.hsqldb.jdbcDriver").newInstance();

			con = DriverManager. getConnection("jdbc:hsqldb:"+databasename);

			return true;
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Establishes a Connection to the default Question-Database
	 * @return true, if the connection was successfully established
	 * or false, if an Exception occurred
	 */
	public boolean connectToDefaultDatabase() {
		return establishConnection(DEFAULT_DATABASE);
	}
	
	/**
	 * Closes the Connection to the Database
	 */
	public void closeConnection() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
