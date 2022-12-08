package com.solvd.TaxiService.Car;



import com.solvd.TaxiService.enums.CarModel;

import java.util.Objects;

public abstract class Car {

    private int seatPlaceNumber;
    private String carNumber;
    private int maxSpeed;
    private int carWidth;
    private int carLength;
    private int carHeight;
    private CarModel model;

    // Constructors creating
    public Car() {

    }

    public Car(int seatPlaceNumber, String carNumber, int maxSpeed, int carWidth,
               int carLength, int carHeight, CarModel model) {
        this.seatPlaceNumber = seatPlaceNumber;
        this.carNumber = carNumber;
        this.maxSpeed = maxSpeed;
        this.carWidth = carWidth;
        this.carLength = carLength;
        this.carHeight = carHeight;
        this.model = model;
    }

    // Getters and Setters creation
    public int getCarWidth() {
        return carWidth;
    }

    public void setCarWidth(int carWidth) {
        this.carWidth = carWidth;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public int getSeatPlaceNumber() {
        return seatPlaceNumber;
    }

    public void setSeatPlaceNumber(int seatPlaceNumber) {
        this.seatPlaceNumber = seatPlaceNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCarWight() {
        return carWidth;
    }

    public void setCarWight(int carWight) {
        this.carWidth = carWight;
    }

    public int getCarLength() {
        return carLength;
    }

    public void setCarLength(int carLength) {
        this.carLength = carLength;
    }

    public int getCarHeight() {
        return carHeight;
    }

    public void setCarHeight(int carHeight) {
        this.carHeight = carHeight;
    }

    // toString, equals, hashcode overriding
    @Override
    public String toString() {
        return "Car{" +
                "seatPlaceNumber=" + seatPlaceNumber +
                ", carNumber='" + carNumber + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", carWight=" + carWidth +
                ", carLength=" + carLength +
                ", carHeight=" + carHeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return seatPlaceNumber == car.seatPlaceNumber && maxSpeed == car.maxSpeed && carWidth == car.carWidth && carLength == car.carLength && carHeight == car.carHeight && Objects.equals(carNumber, car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatPlaceNumber, carNumber, maxSpeed, carWidth, carLength, carHeight);
    }
}


