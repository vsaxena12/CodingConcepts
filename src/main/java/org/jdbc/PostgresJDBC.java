package org.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class.forName("org.postgresql.Driver");
 * JDBC 4.0 introduced Service Provider Mechanism (SPI), which allows JDBC drivers to auto-register themselves.
 * Gradle downloads the driver and makes it available at runtime, ensuring that the JDBC Driver is discovered without needing manual class loading.
 * Modern JDBC drivers include a file in META-INF/services/java.sql.Driver that automatically registers them
 * If manually managing drivers, then we need Class.forName();
 */
public class PostgresJDBC {
    public static void main(String[] args) {
        DatabaseUtil.createDatabaseIfNotExists("my_db_1");

        try {
            Connection conn = DatabaseUtil.getConnection();
            DatabaseUtil.createDatabaseIfNotExists("my_db_1");
            DatabaseUtil.createTableIfNotExists(conn.createStatement(), "users1");
            DatabaseUtil.displayAllUsers(conn.createStatement(), "users1");

            DatabaseUtil.listOfDatabases();

            //DatabaseUtil.dropDatabase("my_db_1");
            DatabaseUtil.listOfDatabases();
        } catch ( SQLException e) {
            throw new RuntimeException("");
        }

    }
}