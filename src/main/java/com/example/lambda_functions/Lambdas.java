package com.example.lambda_functions;

import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Function<String, String> upperCaseName1 = name -> {
            if(name.isBlank()) throw new IllegalStateException("Name cant blank");
            return name.toUpperCase();
        };

        Function<String, String> upperCaseName2 = String::toUpperCase;

        System.out.println(upperCaseName1.apply("rishabh rawat"));
        System.out.println(upperCaseName2.apply("rishabh rawat"));
    }

}
