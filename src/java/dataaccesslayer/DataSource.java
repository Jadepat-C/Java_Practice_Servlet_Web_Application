package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
Student Name: Jadepat Chernsonthi
Student Number: 041074866
Course & Section #: 23S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
 */
/**
 * The DataSource class provides a connection to the database. It reads the
 * database properties from a configuration file and creates a connection using
 * JDBC. Only one connection is used for the entire application to prevent
 * memory leaks.
 *
 * This class is responsible for creating a connection to the database and
 * returning the connection object.
 *
 * Usage: DataSource dataSource = new DataSource(); 
 * Connection connection = dataSource.createConnection(); 
 * // Use the connection for database operations
 * // ... 
 * // Close the connection when done 
 * connection.close();
 *
 * Note: The variables must be properly configured with the correct database
 * URL, username, and password.
 *
 * @author Jadepat
 */
public class DataSource {

    private Connection connection = null;
    // TODO:  Initialize the url string variable properly.  No need to load the
    //        JDBC URL, username, and password from a properties file.
    private final String url = "jdbc:mysql://localhost:3306/peertutor?useSSL=false&allowPublicKeyRetrieval=true";
    private String username = "CST8288";
    private String password = "@Admin1234";

    /**
     * Default constructor for the DataSource class.
     */
    public DataSource() {
    }

    /**
     * Creates a connection to the database using the variables (url, username, password).
     * Only use one connection for this application, prevent memory leaks.
     * 
     * @return the database connection
     */
    public Connection createConnection() {
        // TODO:  Add your code here.  Make sure to use try-catch statement.
        //        Make sure there is only one connection for this application
        //        to prevent memory leaks.
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
