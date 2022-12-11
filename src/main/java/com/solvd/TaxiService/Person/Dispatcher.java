package com.solvd.TaxiService.Person;


import com.solvd.TaxiService.Interfaces.IConfirmationOrder;
import com.solvd.TaxiService.enums.Gender;
import com.solvd.TaxiService.enums.Level;
import org.apache.log4j.Logger;

import java.util.Objects;

public class Dispatcher extends Person implements IConfirmationOrder {
    private static final Logger LOGGER = Logger.getLogger(Dispatcher.class);
    private String education;
    private Level driverManagementExperience;
    private String categoryManagement;
    private Client client;


    // Constructors creating
    public Dispatcher() {
    }

    public Dispatcher(String dateOfBirth, String name, String surname, String accessRights,
                      int phoneNumber, Gender gender, String education,
                      Level driverManagementExperience) {
        super(dateOfBirth, name, surname, accessRights, phoneNumber, gender);
        this.education = education;
        this.driverManagementExperience = driverManagementExperience;


    }

    // Interfaces overriding

    @Override
    public Boolean confirmationOrder() {

        if (client.createOrder()) {
            LOGGER.info("Order confirmed");
            return true;
        } else {
            LOGGER.info("Order not confirmed, try again");
            return false;
        }
    }


    // Getters and Setters creation

    public void setClient(Client client) {
        this.client = client;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Level getDriverManagementExperience() {
        return driverManagementExperience;
    }

    public void setDriverManagementExperience(Level driverManagementExperience) {
        this.driverManagementExperience = driverManagementExperience;
    }

    public String getCategoryManagement() {
        return categoryManagement;
    }

    public void setCategoryManagement(String categoryManagement) {
        this.categoryManagement = categoryManagement;
    }

    // toString, equals, hashcode overriding

    @Override
    public String toString() {
        return "Dispatcher{" +
                "education='" + education + '\'' +
                ", driverManagementExperience='" + driverManagementExperience + '\'' +
                ", categoryManagement='" + categoryManagement + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dispatcher that = (Dispatcher) o;
        return Objects.equals(education, that.education) && Objects.equals(driverManagementExperience, that.driverManagementExperience) && Objects.equals(categoryManagement, that.categoryManagement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), education, driverManagementExperience, categoryManagement);
    }


}
