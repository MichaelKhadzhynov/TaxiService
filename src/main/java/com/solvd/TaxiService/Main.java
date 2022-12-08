package com.solvd.TaxiService;


import com.solvd.TaxiService.Lists.DispatcherList;
import com.solvd.TaxiService.Person.Client;
import com.solvd.TaxiService.Person.Dispatcher;
import com.solvd.TaxiService.Person.Driver;
import com.solvd.TaxiService.Taxi.Order;
import com.solvd.TaxiService.enums.TaxiCars;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);


    public static void main(String[] args) {


        Order order = new Order(TaxiCars.LIMOUSINE, 15, 2, "Yes",
                "Yes", "No", "No", "No");

        Client client = new Client();
        client.setOrder(order);

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setClient(client);

        order.getTaxi().getDriversAndCars().getDriver().setDispatcher(dispatcher);


        if (order.getPrice() > 0 && order.orderConfirm()) {
            order.getTaxi().getDriversAndCars().getDriver().orderStatus();
            LOGGER.info("Price - " + order.getPrice());
            LOGGER.info("Car model - " + order.getTaxi().getDriversAndCars().getCar().getModel());
            LOGGER.info("Car number - " + order.getTaxi().getDriversAndCars().getCar().getCarNumber());
            LOGGER.info("Driver name - " + order.getTaxi().getDriversAndCars().getDriver().getName());
            LOGGER.info("Driver phone number - +380" + order.getTaxi().getDriversAndCars()
                    .getDriver().getPhoneNumber());
            LOGGER.info("Driver knowledge of city Level - " + order.getTaxi().getDriversAndCars()
                    .getDriver().getKnowledgeOfCity());
            LOGGER.info("Driver license expired date - " + order.getTaxi().getDriversAndCars().getDriver()
                    .getLicense().getDateOfExpired());
            Driver.licenseValidityPeriod(order.getTaxi().getDriversAndCars().getDriver().getName());
            LOGGER.info("Dispatcher - " + DispatcherList.dispatcherLinkedList()
                    .get((int) Math.floor(Math.random() * DispatcherList.dispatcherLinkedList().size()))
                    .getName());
        }



    }
}
