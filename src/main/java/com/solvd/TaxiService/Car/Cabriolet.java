package com.solvd.TaxiService.Car;



import com.solvd.TaxiService.enums.CarModel;

import java.util.Objects;

public final class Cabriolet extends Car{
    private String openRoof;

    // Constructors creating
    public Cabriolet() {
    }

    public Cabriolet(int seatPlaceNumber, String carNumber, int maxSpeed, int carWidth, int carLength,
                     int carHeight, CarModel model, String openRoof) {
        super(seatPlaceNumber, carNumber, maxSpeed, carWidth, carLength, carHeight, model);
        this.openRoof = openRoof;
    }

    // Getters and Setters creation
    public String getOpenRoof() {
        return openRoof;
    }

    public void setOpenRoof(String openRoof) {
        this.openRoof = openRoof;
    }

    // toString, equals, hashcode overriding
    @Override
    public String toString() {
        return "Cabriolet{" +
                "OpenRoof='" + openRoof + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cabriolet cabriolet = (Cabriolet) o;
        return Objects.equals(openRoof, cabriolet.openRoof);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), openRoof);
    }
}
