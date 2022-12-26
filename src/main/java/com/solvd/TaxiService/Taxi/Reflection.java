package com.solvd.TaxiService.Taxi;

import com.solvd.TaxiService.Person.Client;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {
    private static final Logger LOGGER = Logger.getLogger(Reflection.class);

    public static void refMethod(String className) throws ClassNotFoundException {

        Class<?> pClass = Class.forName("com.solvd.TaxiService.Person." + className);

        Constructor<?>[] constructors = pClass.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            LOGGER.info("\n Constructors ");
            LOGGER.info("Name - " + c.getName());
            LOGGER.info("Modifiers - " + c.getModifiers());
            LOGGER.info("Parameters - " + Arrays.toString(c.getParameters()));


        }
        Method[] methods = pClass.getDeclaredMethods();
        for (Method m : methods) {
            LOGGER.info("\n Methods");
            LOGGER.info("Name - " + m.getName());
            LOGGER.info("Modifiers - " + m.getModifiers());
            LOGGER.info("ReturnType - " + m.getReturnType());
            LOGGER.info("Parameters - " + Arrays.toString(m.getParameters()));
            LOGGER.info("ParameterCount - " + m.getParameterCount());
            LOGGER.info("ParameterTypes - " + Arrays.toString(m.getParameterTypes()));

        }
        Field[] field = pClass.getDeclaredFields();
        for (Field f : field) {
            LOGGER.info("\n Fields");
            LOGGER.info("Name - " + f.getName());
            LOGGER.info("Type - " + f.getType());
            LOGGER.info("Modifiers - " + f.getModifiers());
        }
        Class<?>[] interfaces = pClass.getInterfaces();
        for (Class<?> d : interfaces) {
            LOGGER.info("\n Interfaces");
            LOGGER.info("name - " + d.getName());
        }

    }

    public static void refChengMethod() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> aClass =  Class.forName("com.solvd.TaxiService.Person.Client");
        Constructor<?> cns = aClass.getDeclaredConstructor();
        Client client = (Client) cns.newInstance();

        Field[] fields = client.getClass().getDeclaredFields();

        for (Field fl : fields) {
            LOGGER.info(fl.getType() + " " + fl.getName());
        }

        for (Field f : fields) {

            if (f.getName().equals("location")) {
                LOGGER.info("Before changing - " + client.getLocation());
                f.setAccessible(true);
                f.set(client, 2);
                f.setAccessible(false);
                LOGGER.info("After changing - " + client.getLocation());
            }

            if (f.getName().equals("luggage")) {
                LOGGER.info("Before changing - " + client.getLuggage());
                f.setAccessible(true);
                f.set(client, "Yes");
                f.setAccessible(false);
                LOGGER.info("After changing - " + client.getLuggage());
            }

            if (f.getName().equals("passengerNumber")) {
                LOGGER.info("Before changing - " + client.getPassengerNumber());
                f.setAccessible(true);
                f.set(client, 2);
                f.setAccessible(false);
                LOGGER.info("After changing - " + client.getPassengerNumber());
            }
        }

        Method luggage = aClass.getDeclaredMethod("getLuggage");
        LOGGER.info(luggage.invoke(client));
    }
}
