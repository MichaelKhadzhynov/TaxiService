package com.solvd.TaxiService;


import com.solvd.TaxiService.Person.Client;
import com.solvd.TaxiService.Person.Dispatcher;
import com.solvd.TaxiService.Taxi.Order;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);


    public static void main(String[] args) throws IOException {


        // Order creation
        Order order = new Order();
        order.orderParametersInput();

        // New client
        Client client = new Client();
        client.setOrder(order);

        // New dispatcher
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setClient(client);
        order.getTaxi().getDriversAndCars().getDriver().setDispatcher(dispatcher);

        // Get order confirmed result and recording order history
        order.confirmedOrderResult();
        order.orderHistoryRecording();


    }
}


//        Order order = new Order(TaxiCars.CROSSOVER, 15, 2, "yes",
//                "yes", "no", "no", "no");