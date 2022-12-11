package com.solvd.TaxiService.Lists;

import com.solvd.TaxiService.Person.Dispatcher;
import com.solvd.TaxiService.Person.Driver;
import com.solvd.TaxiService.Person.Person;
import com.solvd.TaxiService.enums.Gender;
import com.solvd.TaxiService.enums.Level;
import com.solvd.TaxiService.exception.ChoiceException;
import org.apache.log4j.Logger;

import java.util.LinkedList;

public class GenericLinkedList {
    private static final Logger LOGGER = Logger.getLogger(GenericLinkedList.class);


    public static LinkedList<? extends Person> employeeList(String category) {

        try {
            switch (category) {

                case ("Driver"):
                    LinkedList<Driver> drivers = new LinkedList<>();

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

                case ("Dispatcher"):

                    LinkedList<Dispatcher> dispatchers = new LinkedList<>();

                    Dispatcher Ban = new Dispatcher("1990-05-12", "Ban", "Banson",
                            "Dispatcher", 973903953, Gender.MALE, "Bachelor", Level.MEDIUM);


                    Dispatcher Sofi = new Dispatcher("1990-06-07", "Sofi", "Banson",
                            "Dispatcher", 973934968, Gender.FEMALE, "Bachelor", Level.HEIGHT);

                    dispatchers.add(Ban);
                    dispatchers.add(Sofi);

                    return dispatchers;

                default:
                    throw new ChoiceException("Make correct choice");

            }
        } catch (ChoiceException e) {
            LOGGER.error(e);
            return null;
        }
    }
}
