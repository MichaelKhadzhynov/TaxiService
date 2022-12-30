package com.solvd.TaxiService.Threads;

import com.solvd.TaxiService.Taxi.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class MyThreadsCP {
    private static final Logger LOGGER = Logger.getLogger(MyThreadsCP.class);

    public static void myThreadsCP() {


        ThreadPoolExecutor ex = new ThreadPoolExecutor(5, 7, 2,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(2));
        Runnable runnable = () -> {

            Connection conn = null;
            try {

                conn = ConnectionPool.getInstance().getConnection();
                Thread.sleep(2000);

            } catch (SQLException | InterruptedException e) {
                LOGGER.error(e);

            } finally {
                if (conn != null) {
                    try {
                        ConnectionPool.getInstance().releaseConnection(conn);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            LOGGER.info("Finish Thread number - " + Thread.currentThread().getId());
        };

        for (int i = 0; i < 7; i++) {

            ex.submit(runnable);

        }
        ex.shutdown();
    }

}

