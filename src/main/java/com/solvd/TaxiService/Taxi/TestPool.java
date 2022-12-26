package com.solvd.TaxiService.Taxi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPool {

    public static void testPool() {

        String dbUrl = "jdbc:mysql://localhost:3306/myDB";
        String dbUser = "root";
        String dbPass = "12345678";

        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPass, 5);
        Connection conn = null;



        try {
            conn = pool.getConnection();
            try (Statement statement = conn.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM taxi_clients WHERE client_name = 'Mia'");
                while (resultSet.next()) {
                    System.out.print(resultSet.getString(1));
                    System.out.print(" | ");
                    System.out.print(resultSet.getString(2));
                    System.out.print(" | ");
                    System.out.print(resultSet.getString(3));
                    System.out.println();

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