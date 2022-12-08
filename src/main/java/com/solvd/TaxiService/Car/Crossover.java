package com.solvd.TaxiService.Car;

import com.solvd.TaxiService.enums.CarModel;
import com.solvd.TaxiService.enums.Level;


import java.util.Objects;

public final class Crossover extends Car{
    private Level passability;

    // Constructors creating
    public Crossover() {
    }

    public Crossover(int seatPlaceNumber, String carNumber, int maxSpeed, int carWidth,
                     int carLength, int carHeight, CarModel model, Level passability) {
        super(seatPlaceNumber, carNumber, maxSpeed, carWidth, carLength, carHeight, model);
        this.passability = passability;
    }

    // Getters and Setters creation
    public Level getPassability() {
        return passability;
    }

    public void setPassability(Level passability) {
        this.passability = passability;
    }

    // toString, equals, hashcode overriding
    @Override
    public String toString() {
        return "Crossover{" +
                "passability=" + passability +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Crossover crossover = (Crossover) o;
        return passability == crossover.passability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passability);
    }
}
