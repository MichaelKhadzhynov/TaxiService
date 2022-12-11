package com.solvd.TaxiService.Lists;

import com.solvd.TaxiService.Person.Dispatcher;
import com.solvd.TaxiService.Person.Person;
import com.solvd.TaxiService.enums.Gender;
import com.solvd.TaxiService.enums.Level;


import java.util.LinkedList;

public class DispatcherList {
    public static LinkedList<Dispatcher> dispatcherLinkedList() {
        LinkedList<Dispatcher> dispatchers = new LinkedList<>();

        Dispatcher Ban = new Dispatcher("1990-05-12", "Ban", "Banson",
                "Dispatcher", 973903953, Gender.MALE, "Bachelor", Level.MEDIUM);


        Dispatcher Sofi = new Dispatcher("1990-06-07", "Sofi", "Banson",
                "Dispatcher", 973934968, Gender.FEMALE, "Bachelor", Level.HEIGHT);

        dispatchers.add(Ban);
        dispatchers.add(Sofi);

        return dispatchers;
    }
}
