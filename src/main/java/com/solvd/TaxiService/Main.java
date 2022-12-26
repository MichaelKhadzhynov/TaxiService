package com.solvd.TaxiService;


import com.solvd.TaxiService.Taxi.ConnectionPool;
import com.solvd.TaxiService.Threads.MyThreadsCP;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
//
//
//        TaxiSimpleGUI app = new TaxiSimpleGUI();
//        app.setVisible(true);
//
//
//        FileReaderWriter.fileReaderWriter();
//
//        LambdaExercise.lambdaExercise();
//
//        Reflection.refMethod("Driver");
//
//        Reflection.refChengMethod();


//            TestPool.testPool();

//        for (int i = 0; i < 2; i++) {
//            MyThreads myThreads = new MyThreads();
//            myThreads.start();
//        }
//
//        for (int i = 0; i < 2; i++) {
//            MyRunnable myRunnable = new MyRunnable();
//            Thread thread = new Thread(myRunnable);
//            thread.start();
//        }

//        MyThreadsCP.myThreadsCP();

    }
}


