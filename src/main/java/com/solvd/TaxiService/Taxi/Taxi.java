package com.solvd.TaxiService.Taxi;



import com.solvd.TaxiService.Car.Car;
import com.solvd.TaxiService.Person.Driver;

import java.util.Objects;

public class Taxi {
    private Car car;
    private Driver driver;

    public Taxi(Car car, Driver driver) {
        this.car = car;
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "stuff.Taxi{" +
                "car=" + car +
                ", driver=" + driver +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taxi taxi = (Taxi) o;
        return Objects.equals(car, taxi.car) && Objects.equals(driver, taxi.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, driver);
    }
}
