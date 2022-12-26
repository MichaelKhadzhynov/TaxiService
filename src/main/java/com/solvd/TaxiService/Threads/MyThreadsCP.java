package com.solvd.TaxiService.Threads;

import com.solvd.TaxiService.Taxi.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadsCP {

    public static void myThreadsCP() {

        String dbUrl = "jdbc:mysql://localhost:3306/myDB";
        String dbUser = "root";
        String dbPass = "12345678";

        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPass, 5);
        ThreadPoolExecutor ex = new ThreadPoolExecutor(5, 7, 2,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        Runnable r = () -> {

            Connection conn = null;
            try {
                System.out.println("Start Thread number - " + Thread.currentThread().getId());
                conn = pool.getConnection();
                Thread.sleep(2000);

            } catch (SQLException | InterruptedException e) {
                System.out.println(e);

            } finally {
                if (conn != null) {
                    try {
                        pool.releaseConnection(conn);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Finish Thread number - " + Thread.currentThread().getId());
        };

        for (int i = 0; i < 7; i++) {

            ex.submit(r);

        }
        ex.shutdown();
    }

}

