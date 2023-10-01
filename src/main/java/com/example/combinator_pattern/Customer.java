package com.example.combinator_pattern;

import java.time.LocalDate;

public class Customer {

    private final String email;

    private final String phoneNumber;

    private final LocalDate dob;

    public Customer(String email, String phoneNumber, LocalDate dob) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public LocalDate getDOB() {
        return this.dob;
    }

}
