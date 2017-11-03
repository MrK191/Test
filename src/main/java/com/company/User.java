package com.company;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private String name;
    private String surename;
    private LocalDate birthday;
    private String phoneNumber;

    @Override
    public String toString() {

        return "Name = '" + name + '\'' +
                ", Surename = '" + surename + '\'' +
                ", Age = " + this.getAge() +
                ", Phone Number = " + phoneNumber;

    }

    public User() {

    }

    public User(String name, String surename, LocalDate birthday) {
        this.name = name;
        this.surename = surename;
        this.birthday = birthday;
        this.phoneNumber = "NONE";
    }

    public User(String name, String surename, LocalDate birthday, String phoneNumber) {
        this.name = name;
        this.surename = surename;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {

        return Period.between(birthday, LocalDate.now()).getYears();
    }

}
