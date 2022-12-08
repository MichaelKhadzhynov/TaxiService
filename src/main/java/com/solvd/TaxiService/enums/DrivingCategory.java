package com.solvd.TaxiService.enums;

public enum DrivingCategory {
    A("Motorcycles"),
    B("Lite cars"),
    C("Cargo"),
    D("Bus");

    private final String category;

    DrivingCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
