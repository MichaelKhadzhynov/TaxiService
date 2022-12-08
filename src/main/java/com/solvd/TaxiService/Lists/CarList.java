package com.solvd.TaxiService.Lists;

import com.solvd.TaxiService.Car.*;
import com.solvd.TaxiService.enums.CarModel;
import com.solvd.TaxiService.enums.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class CarList {
    private static final Logger LOGGER = Logger.getLogger(Pickup.class);

    public static ArrayList<Car> carList() {
        ArrayList<Car> cars = new ArrayList<>();

        Pickup pickup = new Pickup(5, "1234", 170, 2,
                4, 2, CarModel.FORD, 400,
                2, 2, 1);

        Crossover crossover = new Crossover(4, "2552", 210, 2,
                2, 3, CarModel.FORD, Level.MEDIUM);

        Limousine limousine = new Limousine(8, "0000", 70, 2, 6,
                2, CarModel.BMW, "Yes");

        Cabriolet cabriolet = new Cabriolet(4, "1434",
                180, 2, 3, 1, CarModel.MITSUBISHI, "Yes");

        Sedan sedan = new Sedan(4, "1234", 110,
                2, 3, 2, CarModel.TOYOTA);

        cars.add(pickup);
        cars.add(crossover);
        cars.add(limousine);
        cars.add(cabriolet);
        cars.add(sedan);


        return cars;

    }

}
