package com.example.functional_programming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionInterfaceExample {

    private static final Function<Integer, Integer> incrementByOne = number -> ++number;

    private static final Function<Integer, Integer> multiplyBy10 = number -> number * 10;

    private static final BiFunction<Integer, Integer, Integer> incrementByOneThenMultiplyBy10 = (number1,
            number2) -> (number1 + 1) * number2;

    public static void main(String[] args) {
        int initialValue = 0;
        System.out.println("Function Interface...");
        System.out.println("Initial Value :" + initialValue);
        int finalValue = multiplyBy10.apply(incrementByOne.apply(initialValue));
        System.out.println("Final VAlue :" + finalValue);

        System.out.println("---------------------------------------------------------------------------------");

        System.out.println("BiFunction Interface...");
        System.out.println(incrementByOneThenMultiplyBy10.apply(4, 100));
    }

}
