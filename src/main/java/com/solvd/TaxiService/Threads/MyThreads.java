package com.solvd.TaxiService.Threads;

import com.solvd.TaxiService.Lists.CarList;
import com.solvd.TaxiService.Main;
import org.apache.log4j.Logger;

public class MyThreads extends Thread{

    private static final Logger LOGGER = Logger.getLogger(MyThreads.class);

    @Override
    public void run() {

        try {
            LOGGER.info(CarList.carList().stream().allMatch(e -> e.getMaxSpeed() > 50) + " " + getId());
            Thread.sleep(5000);
            LOGGER.info(CarList.carList().stream().noneMatch(e -> e.getCarLength() < 10) + " " + getId());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
