package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DatabaseUtil {

    private static final Logger logger = Logger.getLogger(DatabaseUtil.class.getName());

    private static final String checkDBExists = "SELECT 1 FROM pg_database WHERE datname = ?"; //? → a placeholder for a parameter
    private static final String createDatabase = "CREATE DATABASE ";
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String USER = "svarun1";
    private static final String PASSWORD = "vsaxena1"; // Should be stored securely
    private static final String DEFAULT_DB = "postgres";

    public static void createDatabaseIfNotExists(String dbName) {
        try {
            Connection connection = DriverManager.getConnection(URL+DEFAULT_DB, USER, PASSWORD); //Create Connection


            PreparedStatement preparedStatement = connection.prepareStatement(checkDBExists); //setString(1, "my_database") → replaces the first ? with the string "my_database"
            // Prevents SQL injection and handles proper escaping
            preparedStatement.setString(1, dbName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(createDatabase+dbName);
//                System.out.println("New database is created");
                logger.info("New DB is created!");
            } else {
                logger.info("Database already exists");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL+DEFAULT_DB, USER, PASSWORD);
    }

    /**
     * Creates the users table if it does not exist.
     */
    public static void createTableIfNotExists(Statement stmt, String tableName) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS "+tableName+" (id SERIAL PRIMARY KEY, name VARCHAR(100))";
        stmt.executeUpdate(createTableSQL);
        System.out.println("Table 'users' created or already exists.");
    }

    /**
     * Displays all users in the database.
     */
    public static void displayAllUsers(Statement stmt,  String tableName) throws SQLException {
        String selectSQL = "SELECT * FROM "+tableName;
        try (ResultSet rs = stmt.executeQuery(selectSQL)) {
            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        }
    }

    public static void dropTable() {

    }

    public static List<String> listOfDatabases() {
        List<String> databases = new ArrayList<>();
        String selectAllDB = "SELECT datname FROM pg_database WHERE datistemplate = false";

        try{
            Connection connection = DriverManager.getConnection(URL+DEFAULT_DB, USER, PASSWORD);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectAllDB);

            while(rs.next()) {
                databases.add(rs.getString("datname"));
            }
            logger.info("Retrieved " + databases.size() + " databases.");
            logger.info("Retrieved " + databases + " databases.");


        } catch (SQLException e) {
            logger.severe("Database doesn't exists or already deleted");
            throw new RuntimeException(e);
        }
        return databases;
    }

    public static void dropDatabase(String dbname) {

        String selectedDB = "DROP DATABASE "+dbname;

        String terminateQuery = "SELECT pg_terminate_backend(pid) " +
                "FROM pg_stat_activity " +
                "WHERE datname = ? AND pid <> pg_backend_pid()";

        try{
            Connection connection = DriverManager.getConnection(URL+DEFAULT_DB, USER, PASSWORD);

            // Disconnect the DB which is in use
            PreparedStatement preparedStatement = connection.prepareStatement(terminateQuery);
            preparedStatement.setString(1, dbname);
            preparedStatement.execute();

            // Drop the same DB
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(selectedDB);
            PreparedStatement dropStatement = connection.prepareStatement(selectedDB);
            //dropStatement.setString(1, dbname);
            dropStatement.executeUpdate();
            logger.info("Database '" + dbname + "' dropped successfully.");

        } catch (SQLException e) {
            logger.severe("Database doesn't exists or already deleted");
            throw new RuntimeException(e);
        }
    }
}
