package com.solvd.TaxiService.Taxi;

import com.solvd.TaxiService.Car.Car;
import com.solvd.TaxiService.Lists.CarList;
import com.solvd.TaxiService.Lists.DriverList;
import com.solvd.TaxiService.Lists.LicenseList;
import com.solvd.TaxiService.Main;
import com.solvd.TaxiService.Person.License;
import com.solvd.TaxiService.enums.DrivingCategory;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExercise {
    private static final Logger LOGGER = Logger.getLogger(LambdaMethods.class);

    public static void lambdaExercise(){

        LambdaMethods.check(LicenseList.licensesList(), (License t) -> t.getCategory().equals(DrivingCategory.C));
        LOGGER.info("----");
        LambdaMethods.check(LicenseList.licensesList(), t -> LocalDate.parse(t.getDateOfExpired()).isAfter(LocalDate.now()));
        LOGGER.info("----");
        LambdaMethods.length(CarList.carList(), t -> t.getCarLength() > 3);
        LOGGER.info("----");
        LambdaMethods.speed(CarList.carList(), t -> t.getMaxSpeed() > 150);
        LOGGER.info("----");
        DriverList.nameNotEmpty();
        LOGGER.info("----");
        CarList.seatPlace();
        LOGGER.info("----");
        Order.doublePrice(20);
        LOGGER.info("----");
        Order.actionPrice(55, 15);
        LOGGER.info("----");

        LicenseList.licensesList().forEach(e ->
                LOGGER.info(e.getName() + " " + e.getCategory().equals(DrivingCategory.B)));
        LOGGER.info("----");

        LicenseList.licensesList().forEach(e -> LOGGER.info(e.getName().toUpperCase()));
        LOGGER.info("----");

        List<Car> list = CarList.carList().stream().filter(e ->
                e.getSeatPlaceNumber() > 4).collect(Collectors.toList());
        list.forEach(e -> LOGGER.info(e.getModel() + " - " + e.getSeatPlaceNumber()));
        LOGGER.info("----");

        List<License> list1 = LicenseList.licensesList().stream().filter(e ->
                LocalDate.parse(e.getDateOfExpired()).isAfter(LocalDate.now())).collect(Collectors.toList());
        list1.forEach(e -> LOGGER.info(e.getName() + " - " + e.getDateOfExpired()));
        LOGGER.info("----");


    }
}
