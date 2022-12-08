package com.solvd.TaxiService.Car;

import com.solvd.TaxiService.enums.CarModel;
import com.solvd.TaxiService.exception.CargoOverloadingException;
import org.apache.log4j.Logger;

import java.util.Objects;

public final class Pickup extends Car {
    private static final Logger LOG = Logger.getLogger(Pickup.class);

    private int cargoCarryMass;
    private int cargoPlaceWidth;
    private int cargoPlaceLength;
    private int cargoPlaceHeight;

    // Constructors creating
    public Pickup() {
    }

    public Pickup(int seatPlaceNumber, String carNumber, int maxSpeed, int carWidth,
                  int carLength, int carHeight, CarModel model, int cargoCarryMass,
                  int cargoPlaceWidth, int cargoPlaceLength, int cargoPlaceHeight) {
        super(seatPlaceNumber, carNumber, maxSpeed, carWidth, carLength, carHeight, model);
        this.cargoCarryMass = cargoCarryMass;
        this.cargoPlaceWidth = cargoPlaceWidth;
        this.cargoPlaceLength = cargoPlaceLength;
        this.cargoPlaceHeight = cargoPlaceHeight;
    }


    // Getters and Setters creation
    public int getCargoCarryMass() {
        return cargoCarryMass;
    }

    public void setCargoCarryMass(int cargoCarryMass) {

        try {
            if (cargoCarryMass > 500) {
                throw new CargoOverloadingException("Too much cargo");
            } else LOG.info("Cargo mass acceptable");
        } catch (CargoOverloadingException e) {
            LOG.info(e);
        }

        this.cargoCarryMass = cargoCarryMass;
    }

    public int getCargoPlaceWidth() {
        return cargoPlaceWidth;
    }

    public void setCargoPlaceWidth(int cargoPlaceWidth) {
        this.cargoPlaceWidth = cargoPlaceWidth;
    }

    public int getCargoPlaceLength() {
        return cargoPlaceLength;
    }

    public void setCargoPlaceLength(int cargoPlaceLength) {
        this.cargoPlaceLength = cargoPlaceLength;
    }

    public int getCargoPlaceHeight() {
        return cargoPlaceHeight;
    }

    public void setCargoPlaceHeight(int cargoPlaceHeight) {
        this.cargoPlaceHeight = cargoPlaceHeight;
    }

    // toString, equals, hashcode overriding
    @Override
    public String toString() {
        return "Pickup{" +
                "cargoCarryMass=" + cargoCarryMass +
                ", cargoPlaceWidth=" + cargoPlaceWidth +
                ", cargoPlaceLength=" + cargoPlaceLength +
                ", cargoPlaceHeight=" + cargoPlaceHeight +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pickup pickup = (Pickup) o;
        return cargoCarryMass == pickup.cargoCarryMass && cargoPlaceWidth == pickup.cargoPlaceWidth && cargoPlaceLength == pickup.cargoPlaceLength && cargoPlaceHeight == pickup.cargoPlaceHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoCarryMass, cargoPlaceWidth, cargoPlaceLength, cargoPlaceHeight);
    }
}
