package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector implements AutoCloseable {
    private Connection con;

    public DatabaseConnector() {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            con = DriverManager.getConnection("jdbc:hsqldb:question_library");
        } catch (SQLException | InstantiationException | IllegalAccessException |
                ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (!con.isClosed()) {
            con.close();
        }
    }
}
