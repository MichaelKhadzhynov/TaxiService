package com.solvd.TaxiService.Taxi;

import com.solvd.TaxiService.Car.Car;
import com.solvd.TaxiService.Interfaces.ICheck;
import com.solvd.TaxiService.Interfaces.IGetLength;
import com.solvd.TaxiService.Interfaces.IGetMaxSpeed;
import com.solvd.TaxiService.Person.License;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class LambdaMethods {
    private static final Logger LOGGER = Logger.getLogger(LambdaMethods.class);

    public static void check(ArrayList<License> license, ICheck<License> c) {
        for (License l : license) {
            if (c.check(l)) {
                LOGGER.info(l);
            }
        }
    }

    public static void length(ArrayList<Car> cars, IGetLength<Car> c) {
        for (Car i : cars) {
            if (c.getLength(i)) {
                LOGGER.info(i);
            }
        }
    }

    public static void speed(ArrayList<Car> cars, IGetMaxSpeed<Car> m) {
        for (Car c : cars) {
            if (m.getMaxSpeed(c)) {
                LOGGER.info(c.getModel() + " - " + c.getMaxSpeed());
            }
        }
    }
}
