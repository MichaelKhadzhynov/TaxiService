package com.solvd.TaxiService.Taxi;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPool {

    private static final Logger LOGGER = Logger.getLogger(TestPool.class);

    public static void testPool() {

        String dbUrl = "jdbc:mysql://localhost:3306/myDB";
        String dbUser = "root";
        String dbPass = "12345678";

        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPass, 5);
        Connection conn = null;

        try {
            conn = pool.getConnection();
            try (Statement statement = conn.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM taxi_clients ");
                while (resultSet.next()) {
                    LOGGER.info(resultSet.getString(1) + " | "
                            + resultSet.getString(2) + " | "
                            + resultSet.getString(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    pool.releaseConnection(conn);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}