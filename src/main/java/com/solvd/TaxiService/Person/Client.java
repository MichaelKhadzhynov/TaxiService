package com.solvd.TaxiService.Person;

import com.solvd.TaxiService.Interfaces.IOrderCancel;
import com.solvd.TaxiService.Interfaces.IOrderCreation;
import com.solvd.TaxiService.Taxi.Order;
import com.solvd.TaxiService.enums.Gender;
import org.apache.log4j.Logger;

import java.util.Objects;

public class Client extends Person implements IOrderCreation, IOrderCancel {
    private static final Logger LOG = Logger.getLogger(Client.class);
    private int location;
    private String luggage;
    private int passengerNumber;
    private String promoCode;
    private Order order;


    // Constructors creating
    public Client() {
    }

    public Client(String dateOfBirth, String name, String surname, String accessRights,
                  int phoneNumber, Gender gender, int location, String luggage,
                  int passengerNumber, String promoCode) {
        super(dateOfBirth, name, surname, accessRights, phoneNumber, gender);
        this.location = location;
        this.luggage = luggage;
        this.passengerNumber = passengerNumber;
        this.promoCode = promoCode;
    }

    // Interfaces overriding
    @Override
    public Boolean orderCreate() {

        if (order.getPrice() > 0) {
            LOG.info("Order created");
            return true;
        } else return false;

    }

    @Override
    public void orderCancel() {

    }


    // Getters and Setters creation

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    // toString, equals, hashcode overriding


    @Override
    public String toString() {
        return "Client{" +
                "location=" + location +
                ", luggage='" + luggage + '\'' +
                ", passengerNumber=" + passengerNumber +
                ", promoCode='" + promoCode + '\'' +
                ", order=" + order +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return location == client.location && passengerNumber == client.passengerNumber && Objects.equals(luggage, client.luggage) && Objects.equals(promoCode, client.promoCode) && Objects.equals(order, client.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location, luggage, passengerNumber, promoCode, order);
    }
}
