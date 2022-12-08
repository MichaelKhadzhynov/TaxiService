package com.solvd.TaxiService.enums;

import com.solvd.TaxiService.Lists.TaxiList;
import com.solvd.TaxiService.Taxi.Taxi;

public enum TaxiCars {
    PICKUP(TaxiList.taxiList().get(0)),
    CROSSOVER(TaxiList.taxiList().get(1)),
    LIMOUSINE(TaxiList.taxiList().get(2));


    public final Taxi DriversAndCars;

    TaxiCars(Taxi DriversAndCars) {
        this.DriversAndCars = DriversAndCars;
    }

    public Taxi getDriversAndCars() {
        return DriversAndCars;
    }
}
