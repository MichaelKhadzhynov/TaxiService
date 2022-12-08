package com.solvd.TaxiService.Person;

import com.solvd.TaxiService.Interfaces.IOrderCancel;
import com.solvd.TaxiService.Interfaces.IOrderStatus;
import com.solvd.TaxiService.Lists.LicenseList;
import com.solvd.TaxiService.enums.Gender;
import com.solvd.TaxiService.enums.Level;
import com.solvd.TaxiService.exception.PeriodException;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Objects;

public class Driver extends Person implements IOrderStatus, IOrderCancel {
    private static final Logger LOGGER = Logger.getLogger(Driver.class);
    private License licensesList;
    private Level drivingExperience;
    private Level knowledgeOfCity;
    private Dispatcher dispatcher;


    // Constructors creating
    public Driver() {
    }


    public Driver(String dateOfBirth, String name, String surname, String accessRights, int phoneNumber,
                  Gender gender, License license, Level drivingExperience, Level knowledgeOfCity) {
        super(dateOfBirth, name, surname, accessRights, phoneNumber, gender);
        this.licensesList = license;
        this.drivingExperience = drivingExperience;
        this.knowledgeOfCity = knowledgeOfCity;
    }

    @Override
    public void orderStatus() {

        if (dispatcher.orderConfirmation()) {
            LOGGER.info("Driver on the way");
        }
    }

    @Override
    public void orderCancel() {

    }


    public static void expiredLicenseList() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (int i = 0; i < LicenseList.licensesList().size(); i++) {

                Date dateLocal = simpleDateFormat.parse(String.valueOf(LocalDate.now()));
                int result = dateLocal.compareTo(simpleDateFormat.parse(LicenseList.licensesList().get(i).getDateOfExpired()));
                if (result < 0) {
                    LOGGER.info(LicenseList.licensesList().get(i).getName() + " License is valid ");
                } else LOGGER.info(LicenseList.licensesList().get(i).getName() + " License is invalid");
                LOGGER.info(result);

            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void licenseValidityPeriod(String driverName) {

        for (int i = 0; i < LicenseList.licensesList().size(); i++) {

            LocalDate localDate = LocalDate.now();
            LocalDate localDate1 = LocalDate.parse(LicenseList.licensesList().get(i).getDateOfExpired());
            Period period = Period.between(localDate, localDate1);

            if (driverName == LicenseList.licensesList().get(i).getName()) {
                LOGGER.info("Driver license validity period - " +
                        period.getYears() + " year(s), " +
                        period.getMonths() + " month(s), " +
                        period.getDays() + " day(s)");
            }

            try {
                if (period.getDays() < 0) throw new PeriodException("License period expired");
            } catch (PeriodException e) {
                LOGGER.error(e);
            }

        }

    }


    // Getters and Setters creation

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public License getLicense() {
        return licensesList;
    }

    public void setLicense(License license) {
        this.licensesList = license;
    }

    public Level getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(Level drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public Level getKnowledgeOfCity() {
        return knowledgeOfCity;
    }

    public void setKnowledgeOfCity(Level knowledgeOfCity) {
        this.knowledgeOfCity = knowledgeOfCity;
    }


    @Override
    public String toString() {
        return "Driver{" +
                "licensesList=" + licensesList +
                ", drivingExperience=" + drivingExperience +
                ", knowledgeOfCity=" + knowledgeOfCity +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return Objects.equals(licensesList, driver.licensesList) && drivingExperience == driver.drivingExperience && knowledgeOfCity == driver.knowledgeOfCity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), licensesList, drivingExperience, knowledgeOfCity);
    }
}
