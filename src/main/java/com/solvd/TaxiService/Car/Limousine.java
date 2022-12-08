package com.solvd.TaxiService.Car;

import com.solvd.TaxiService.enums.CarModel;

import java.util.Objects;

public final class Limousine extends Car {

    private String alcoholBar;
    private int limousineLength;

    // Constructors creating
    public Limousine() {
    }

    public Limousine(int seatPlaceNumber, String carNumber, int maxSpeed, int carWidth,
                     int carLength, int carHeight, CarModel model, String alcoholBar) {
        super(seatPlaceNumber, carNumber, maxSpeed, carWidth, carLength, carHeight, model);
        this.alcoholBar = alcoholBar;
        this.limousineLength = carLength;
    }

    public String getAlcoholBar() {
        return alcoholBar;
    }

    public void setAlcoholBar(String alcoholBar) {
        this.alcoholBar = alcoholBar;
    }

    public int getLimousineLength() {
        int s = limousineLength;
        if (s > 7) System.out.println("Car is not available");
        return limousineLength;
    }

    public void setLimousineLength(int limousineLength) {
        this.limousineLength = limousineLength;
    }

    @Override
    public String toString() {
        return "Limousine{" +
                "alcoholBar='" + alcoholBar + '\'' +
                ", limousineLength=" + limousineLength +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Limousine limousine = (Limousine) o;
        return limousineLength == limousine.limousineLength && Objects.equals(alcoholBar, limousine.alcoholBar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), alcoholBar, limousineLength);
    }
}
