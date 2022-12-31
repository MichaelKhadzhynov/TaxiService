package com.solvd.TaxiService.Threads;

import com.solvd.TaxiService.Main;
import org.apache.log4j.Logger;

public class DeadLock {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void lock() {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            LOGGER.info(Thread.currentThread().getName() + " start");

            synchronized (lock1){

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock2){

                }
            }
            LOGGER.info(Thread.currentThread().getName() + " finish");
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            LOGGER.info(Thread.currentThread().getName() + " start");

            synchronized (lock2){
                synchronized (lock1){

                }
            }
            LOGGER.info(Thread.currentThread().getName() + " finish");
        }, "Thread2");

        thread1.start();
        thread2.start();
    }
}
