package com.solvd.TaxiService.Taxi;


import com.solvd.TaxiService.Person.Client;
import com.solvd.TaxiService.Person.Dispatcher;
import com.solvd.TaxiService.Person.Driver;
import com.solvd.TaxiService.enums.TaxiCars;
import com.solvd.TaxiService.exception.ChoiceException;
import com.solvd.TaxiService.exception.IncorrectChoiceException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class Order {
    private static final Logger LOGGER = Logger.getLogger(Order.class);
    private TaxiCars taxi;
    private int price;
    private int distanceOfDriving;
    private int passengerNumber;
    private String internetInCar;
    private String animalTransportation;
    private String conditioner;
    private String silenceInCar;
    private String LuggageInCabin;
    private Client client;
    private Dispatcher dispatcher;
    private Driver driver;


    // Constructors creating
    public Order() {
    }

    public Order(TaxiCars taxi, int distanceOfDriving, int passengerNumber, String internetInCar, String animalTransportation,
                 String conditioner, String silenceInCar, String luggageInCabin) {
        this.taxi = taxi;
        this.distanceOfDriving = distanceOfDriving;
        this.passengerNumber = passengerNumber;
        this.internetInCar = internetInCar;
        this.animalTransportation = animalTransportation;
        this.conditioner = conditioner;
        this.silenceInCar = silenceInCar;
        this.LuggageInCabin = luggageInCabin;
    }

    public int getPrice() {

        price = passengerNumber + distanceOfDriving;

        ArrayList<String> services = new ArrayList<>();
        services.add(internetInCar);
        services.add(animalTransportation);
        services.add(conditioner);
        services.add(LuggageInCabin);

        try {
            for (String i : services) {
                switch (i) {
                    case "Yes":
                        price += 5;
                        break;
                    case "No":
                        price *= 1;
                        break;
                    default:
                        price = 0;
                        throw new IncorrectChoiceException("Incorrect Choice" + services);
                }
            }
        } catch (IncorrectChoiceException e) {
            LOGGER.error(e);
        }

        return price;

    }


    public boolean orderConfirm() {
        boolean i = false;
        try {
            if (getDistanceOfDriving() > 0 && getPassengerNumber() > 0)
                i = true;
            else {
                i = false;
                throw new ChoiceException("Not correct choice " + "distance of driving " + getDistanceOfDriving() + " or " +
                        "passenger number " + getPassengerNumber() + ". Try again.");
            }

        } catch (ChoiceException e) {
            LOGGER.error(e);
        }
        return i;
    }


    // Getters and Setters creation

    public void setTaxi(TaxiCars taxi) {
        this.taxi = taxi;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public TaxiCars getTaxi() {
        return taxi;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDistanceOfDriving() {
        return distanceOfDriving;
    }

    public void setDistanceOfDriving(int distanceOfDriving) {
        this.distanceOfDriving = distanceOfDriving;
    }

    public String getInternetInCar() {
        return internetInCar;
    }

    public void setInternetInCar(String internetInCar) {
        this.internetInCar = internetInCar;
    }

    public String getAnimalTransportation() {
        return animalTransportation;
    }

    public void setAnimalTransportation(String animalTransportation) {
        this.animalTransportation = animalTransportation;
    }

    public String getConditioner() {
        return conditioner;
    }

    public void setConditioner(String conditioner) {
        this.conditioner = conditioner;
    }

    public String getSilenceInCar() {
        return silenceInCar;
    }

    public void setSilenceInCar(String silenceInCar) {
        this.silenceInCar = silenceInCar;
    }

    public String getLuggageInCabin() {
        return LuggageInCabin;
    }

    public void setLuggageInCabin(String luggageInCabin) {
        LuggageInCabin = luggageInCabin;
    }

    @Override
    public String toString() {
        return "stuff.Order{" +
                "price=" + price +
                ", distanceOfDriving=" + distanceOfDriving +
                ", internetInCar='" + internetInCar + '\'' +
                ", animalTransportation='" + animalTransportation + '\'' +
                ", conditioner='" + conditioner + '\'' +
                ", silenceInCar='" + silenceInCar + '\'' +
                ", LuggageInCabin='" + LuggageInCabin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return price == order.price && distanceOfDriving == order.distanceOfDriving && Objects.equals(internetInCar, order.internetInCar) && Objects.equals(animalTransportation, order.animalTransportation) && Objects.equals(conditioner, order.conditioner) && Objects.equals(silenceInCar, order.silenceInCar) && Objects.equals(LuggageInCabin, order.LuggageInCabin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, distanceOfDriving, internetInCar, animalTransportation, conditioner, silenceInCar, LuggageInCabin);
    }
}
