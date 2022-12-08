package com.solvd.TaxiService.Lists;

import com.solvd.TaxiService.Person.License;
import com.solvd.TaxiService.enums.DrivingCategory;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class LicenseList {
    private static final Logger LOGGER = Logger.getLogger(LicenseList.class);

    public static ArrayList<License> licensesList() {
        ArrayList<License> licenses = new ArrayList<>();

        License Jack = new License("Jack", "Jonson", "NewYork", "20/07/1990",
                "2020-08-11", "2025-08-11", DrivingCategory.B);

        License John = new License("John", "Jackson", "LA", "14/05/1989",
                "2021-04-23", "2026-04-23", DrivingCategory.B);

        License Ann = new License("Ann", "Annieson", "Taxes", "08/08/2000",
                "2018-03-16", "2020-03-16", DrivingCategory.B);

        licenses.add(Jack);
        licenses.add(John);
        licenses.add(Ann);

        return licenses;
    }


}
