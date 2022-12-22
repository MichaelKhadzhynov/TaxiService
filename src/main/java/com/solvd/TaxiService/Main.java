package com.solvd.TaxiService;


import com.solvd.TaxiService.Car.Car;
import com.solvd.TaxiService.Interfaces.ICheck;
import com.solvd.TaxiService.Lists.CarList;
import com.solvd.TaxiService.Lists.DriverList;
import com.solvd.TaxiService.Lists.LicenseList;
import com.solvd.TaxiService.Person.License;
import com.solvd.TaxiService.Taxi.*;
import com.solvd.TaxiService.enums.DrivingCategory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);


    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {


//        // Order creation
//        Order order = new Order();
//        order.orderParametersInput();
//
//        // New client
//        Client client = new Client();
//        client.setOrder(order);
//
//        // New dispatcher
//        Dispatcher dispatcher = new Dispatcher();
//        dispatcher.setClient(client);
//        order.getTaxi().getDriversAndCars().getDriver().setDispatcher(dispatcher);
//
//        // Get order confirmed result and recording order history
//        order.confirmedOrderResult();
//        order.orderHistoryRecording();




//        TaxiSimpleGUI app = new TaxiSimpleGUI();
//        app.setVisible(true);





//         FileReaderWriter.fileReaderWriter();
//
         LambdaExercise.lambdaExercise();
//
//         Reflection.refMethod("Driver");
//
//         Reflection.refChengMethod();


    }

}


