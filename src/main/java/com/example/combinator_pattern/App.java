package com.example.combinator_pattern;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        Customer customer = new Customer("xyz@gmail.com", "97xxxxxxxx", LocalDate.of(2002, 3, 16));

        ValidationResult result = CustomerValidatorInterface.isEmailValid()
                .and(CustomerValidatorInterface.isPhoneNumberValid())
                .and(CustomerValidatorInterface.isAgeValid())
                .apply(customer);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException("Customer not validated because " + result);
        } else {
            System.out.println(result);
        }
    }

}
