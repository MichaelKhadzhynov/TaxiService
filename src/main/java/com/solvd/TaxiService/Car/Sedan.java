package com.solvd.TaxiService.Car;

import com.solvd.TaxiService.enums.CarModel;

public final class Sedan extends Car {

    // Constructors creating
    public Sedan() {
    }

    public Sedan(int seatPlaceNumber, String carNumber, int maxSpeed, int carWidth,
                 int carLength, int carHeight, CarModel model) {
        super(seatPlaceNumber, carNumber, maxSpeed, carWidth, carLength, carHeight, model);
    }

}
