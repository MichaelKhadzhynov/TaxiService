package com.solvd.TaxiService.Taxi;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPool {

    private static final Logger LOGGER = Logger.getLogger(TestPool.class);

    public static void testPool() {

        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();
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
                    ConnectionPool.getInstance().releaseConnection(conn);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}