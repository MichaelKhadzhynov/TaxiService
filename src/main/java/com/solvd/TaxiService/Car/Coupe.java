package com.solvd.TaxiService.Car;

import com.solvd.TaxiService.enums.CarModel;


public final class Coupe extends Car {

    // Constructors creating
    public Coupe() {
    }

    public Coupe(int seatPlaceNumber, String carNumber, int maxSpeed, int carWidth, int carLength,
                 int carHeight, CarModel model) {
        super(seatPlaceNumber, carNumber, maxSpeed, carWidth, carLength, carHeight, model);
    }


}
