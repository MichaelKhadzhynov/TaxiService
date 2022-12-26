package com.solvd.TaxiService.Threads;

import com.solvd.TaxiService.Lists.CarList;
import com.solvd.TaxiService.Lists.DispatcherList;
import com.solvd.TaxiService.Main;
import org.apache.log4j.Logger;

public class MyRunnable implements Runnable{
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    @Override
    public void run() {
        try {
            LOGGER.info(DispatcherList.dispatcherLinkedList().stream().findFirst() + " " + Thread.currentThread().getId());
            Thread.sleep(4000);
            LOGGER.info(CarList.carList().stream().count() + " " + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
