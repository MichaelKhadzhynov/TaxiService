package com.solvd.TaxiService.Lists;

import com.solvd.TaxiService.Car.Car;
import com.solvd.TaxiService.Person.Driver;
import com.solvd.TaxiService.Taxi.Taxi;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class TaxiList {
    private static final Logger LOGGER = Logger.getLogger(Taxi.class);

    public static ArrayList<Taxi> taxiList() {

        ArrayList<Taxi> taxis = new ArrayList<>();

        Driver driver1 = DriverList.drivers().get(0);
        Driver driver2 = DriverList.drivers().get(1);
        Driver driver3 = DriverList.drivers().get(2);


        Car car1 = CarList.carList().get(0);
        Car car2 = CarList.carList().get(1);
        Car car3 = CarList.carList().get(2);

        Taxi taxi1 = new Taxi(car1, driver1);
        Taxi taxi2 = new Taxi(car2, driver2);
        Taxi taxi3 = new Taxi(car3, driver3);


        taxis.add(taxi1);
        taxis.add(taxi2);
        taxis.add(taxi3);


        return taxis;
    }
}
