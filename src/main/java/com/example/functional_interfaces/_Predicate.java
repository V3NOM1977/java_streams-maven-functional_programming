package com.example.functional_interfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    private static final Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("91")
            && phoneNumber.length() == 10;

    private static final BiPredicate<Integer, String> isNumberEqualToStringPredicate = (number,
            string) -> number == Integer.parseInt(string) ? true : false;

    public static void main(String[] args) {
        String phoneNumber = "9112345678";
        boolean bool = isPhoneNumberValidPredicate.test(phoneNumber);
        System.out.println("Is number is valid : " + bool);

        System.out.println("---------------------------------------------------------------------------------");

        System.out.println("Is number equal to the string? :" + isNumberEqualToStringPredicate.test(98, "908"));
    }

}
