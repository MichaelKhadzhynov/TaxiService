package com.solvd.TaxiService.enums;

public enum CarModel {
    FORD("Ford"),
    BMW("BMW"),
    MITSUBISHI("Mitsubishi"),
    VOLKSWAGEN("Volkswagen"),
    TOYOTA("Toyota");

    public final String model;

    CarModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
