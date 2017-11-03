package com.company;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private String name;
    private String surename;
    private LocalDate birthday;
    private int phoneNumber;

    @Override
    public String toString() {
        return "Name = '" + name + '\'' +
                ", Surename = '" + surename + '\'' +
                ", Age = " + this.getAge() +
                ", Phone Number = " + phoneNumber;
    }

    public User() {
    }

    public User(String name, String surename, LocalDate birthday, int phoneNumber) {
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();

        Period age = Period.between(this.birthday, today);
        return age.getYears();
    }
}
