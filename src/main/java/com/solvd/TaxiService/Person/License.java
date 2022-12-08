package com.solvd.TaxiService.Person;

import com.solvd.TaxiService.enums.DrivingCategory;

import java.util.Objects;


public class License {

    private String name;
    private String surname;
    private String placeOfBirth;
    private String dateOfBirth;
    private String dateOfIssue;
    private String dateOfExpired;
    private DrivingCategory category;

    public License(String name, String surname, String placeOfBirth, String dateOfBirth,
                   String dateOfIssue, String dateOfExpired, DrivingCategory category) {

        this.name = name;
        this.surname = surname;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpired = dateOfExpired;
        this.category = category;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfExpired() {


        return dateOfExpired;
    }

    public void setDateOfExpired(String dateOfExpired) {
        this.dateOfExpired = dateOfExpired;
    }

    public DrivingCategory getCategory() {
        return category;
    }

    public void setCategory(DrivingCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "License{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfIssue=" + dateOfIssue +
                ", dateOfExpired=" + dateOfExpired +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        License license = (License) o;
        return Objects.equals(name, license.name) && Objects.equals(surname, license.surname)
                && Objects.equals(placeOfBirth, license.placeOfBirth)
                && Objects.equals(dateOfBirth, license.dateOfBirth)
                && Objects.equals(dateOfIssue, license.dateOfIssue)
                && Objects.equals(dateOfExpired, license.dateOfExpired)
                && category == license.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, placeOfBirth, dateOfBirth, dateOfIssue, dateOfExpired, category);
    }
}
