package com.solvd.TaxiService.Lists;


import com.solvd.TaxiService.Main;
import com.solvd.TaxiService.Person.Driver;
import com.solvd.TaxiService.enums.Gender;
import com.solvd.TaxiService.enums.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.function.Predicate;


public class DriverList {
    private static final Logger LOGGER = Logger.getLogger(DriverList.class);
    public static ArrayList<Driver> drivers() {
        ArrayList<Driver> drivers = new ArrayList<>();


        Driver Jack = new Driver("1990-07-20", "Jack", "Jonson", "Driver",
                960909090, Gender.MALE, LicenseList.licensesList().get(0), Level.MEDIUM, Level.MEDIUM);

        Driver John = new Driver("1989-05-14", "John", "Jackson", "Driver",
                970756443, Gender.MALE, LicenseList.licensesList().get(1), Level.HEIGHT, Level.MEDIUM);

        Driver Ann = new Driver("2000-08-08", "Ann", "Annieson", "Driver",
                670023456, Gender.FEMALE, LicenseList.licensesList().get(2), Level.MEDIUM, Level.HEIGHT);


        drivers.add(Jack);
        drivers.add(John);
        drivers.add(Ann);
        return drivers;
    }

    public static void nameNotEmpty() {
        for(int i=0; i< drivers().size(); i++) {
            Predicate<Integer> nameIsNotEmpty = x -> x > 0;
            LOGGER.info(nameIsNotEmpty.test(drivers().get(i).getName().length()));
        }
    }
}
