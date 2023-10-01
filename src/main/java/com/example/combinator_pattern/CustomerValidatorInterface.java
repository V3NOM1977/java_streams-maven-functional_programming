package com.example.combinator_pattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

enum ValidationResult {
    SUCCESS,
    PHONE_NUMBER_NOT_VALID,
    EMAIL_NOT_VALID,
    IS_NOT_AN_ADULT
}

public interface CustomerValidatorInterface extends Function<Customer, ValidationResult> {

    static CustomerValidatorInterface isEmailValid() {
        return customer -> customer.getEmail().contains("@") ? ValidationResult.SUCCESS
                : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerValidatorInterface isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("97") ? ValidationResult.SUCCESS
                : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerValidatorInterface isAgeValid() {
        return customer -> Period.between(customer.getDOB(), LocalDate.now()).getYears() > 18 ? ValidationResult.SUCCESS
                : ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerValidatorInterface and(CustomerValidatorInterface other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

}
