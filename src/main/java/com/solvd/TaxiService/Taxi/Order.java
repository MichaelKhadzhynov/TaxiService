package com.solvd.TaxiService.Taxi;


import History.RecordingResults;
import com.solvd.TaxiService.Lists.DispatcherList;
import com.solvd.TaxiService.Person.Client;
import com.solvd.TaxiService.Person.Dispatcher;
import com.solvd.TaxiService.Person.Driver;
import com.solvd.TaxiService.enums.TaxiCars;
import com.solvd.TaxiService.exception.ChoiceException;
import com.solvd.TaxiService.exception.IncorrectChoiceException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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
                    case "yes":
                        price += 5;
                        break;
                    case "no":
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

    public void orderHistoryRecording()  {

        try {
            RecordingResults.recording("Price - " + getPrice() + "\n"
                    + "Car model - " + getTaxi().getDriversAndCars().getCar().getModel() + "\n"
                    + "Car number - " + getTaxi().getDriversAndCars().getCar().getCarNumber() + "\n"
                    + "Driver name - " + getTaxi().getDriversAndCars().getDriver().getName() + "\n"
                    + "Driver phone number - +380" + getTaxi().getDriversAndCars().getDriver().getPhoneNumber() + "\n"
                    + "Driver knowledge of city Level - " + getTaxi().getDriversAndCars().getDriver().getKnowledgeOfCity() + "\n"
                    + "Driver license expired date - " + getTaxi().getDriversAndCars().getDriver().getLicense().getDateOfExpired() + "\n"
                    + "Order creation time - " + LocalDateTime.now());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void orderParametersInput() {

        Scanner in = new Scanner(System.in);
        LOGGER.info("Input car type ('Pickup', 'Limousine', 'Crossover'): ");
        String car = in.nextLine();
        switch (car) {
            case "Pickup":
                this.taxi = TaxiCars.PICKUP;
                break;
            case "Limousine":
                this.taxi = TaxiCars.LIMOUSINE;
                break;
            case "Crossover":
                this.taxi = TaxiCars.CROSSOVER;
                break;
            default:
                System.out.println("Make correct choice of car type");
        }
        LOGGER.info(car);

        LOGGER.info("Input distance of driving: ");
        this.distanceOfDriving = Integer.parseInt(in.nextLine());
        LOGGER.info(distanceOfDriving);

        LOGGER.info("Input passenger number: ");
        this.passengerNumber = Integer.parseInt(in.nextLine());
        LOGGER.info(passengerNumber);

        LOGGER.info("Input 'yes' or 'no' animal transportation: ");
        this.animalTransportation = in.nextLine();
        LOGGER.info(animalTransportation);

        LOGGER.info("Input 'yes' or 'no' conditioner in car: ");
        this.conditioner = in.nextLine();
        LOGGER.info(conditioner);

        LOGGER.info("Input 'yes' or 'no' silence in car : ");
        this.silenceInCar = in.nextLine();
        LOGGER.info(silenceInCar);

        LOGGER.info("Input 'yes' or 'no' luggage in cabin: ");
        this.LuggageInCabin = in.nextLine();
        LOGGER.info(LuggageInCabin);

        LOGGER.info("Input 'yes' or 'no' internet in car: ");
        this.internetInCar = in.nextLine();
        LOGGER.info(internetInCar);
    }

    public void confirmedOrderResult(){

        if (getPrice() > 0 && orderConfirm()) {
            getTaxi().getDriversAndCars().getDriver().driverStatus();
            LOGGER.info("Price - " + getPrice());
            LOGGER.info("Car model - " + getTaxi().getDriversAndCars().getCar().getModel());
            LOGGER.info("Car number - " + getTaxi().getDriversAndCars().getCar().getCarNumber());
            LOGGER.info("Driver name - " + getTaxi().getDriversAndCars().getDriver().getName());
            LOGGER.info("Driver phone number - +380" + getTaxi().getDriversAndCars()
                    .getDriver().getPhoneNumber());
            LOGGER.info("Driver knowledge of city Level - " + getTaxi().getDriversAndCars()
                    .getDriver().getKnowledgeOfCity());
            LOGGER.info("Driver license expired date - " + getTaxi().getDriversAndCars().getDriver()
                    .getLicense().getDateOfExpired());
            Driver.licenseValidityPeriod(getTaxi().getDriversAndCars().getDriver().getName());
            LOGGER.info("Dispatcher - " + DispatcherList.dispatcherLinkedList()
                    .get((int) Math.floor(Math.random() * DispatcherList.dispatcherLinkedList().size()))
                    .getName());
        } else LOGGER.info("Try again");
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
