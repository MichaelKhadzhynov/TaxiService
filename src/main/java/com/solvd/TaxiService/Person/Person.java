package com.solvd.TaxiService.Person;



import com.solvd.TaxiService.enums.Gender;

import java.util.Objects;

public abstract class Person {
    private String dateOfBirth;
    private String name;
    private String surname;
    private String accessRights;
    private int phoneNumber;
    private Gender gender;

    // Constructors creating
    public Person() {
    }

    public Person(String dateOfBirth, String name, String surname, String accessRights,
                  int phoneNumber, Gender gender) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.surname = surname;
        this.accessRights = accessRights;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    // Getters and Setters creation
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // toString, equals, hashcode overriding
    @Override
    public String toString() {
        return "Person{" +
                "dateOfBirth='" + dateOfBirth + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accessRights='" + accessRights + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return phoneNumber == person.phoneNumber && Objects.equals(dateOfBirth, person.dateOfBirth) && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(accessRights, person.accessRights) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirth, name, surname, accessRights, phoneNumber, gender);
    }
}
