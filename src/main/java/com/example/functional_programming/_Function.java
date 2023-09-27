package com.example.functional_programming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    private static final Function<Integer, Integer> incrementByOneFunction = number -> ++number;

    private static final Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    private static final BiFunction<Integer, Integer, Integer> incrementByOneThenMultiplyBy10 = (number1,
            number2) -> (number1 + 1) * number2;

    public static void main(String[] args) {
        int initialValue = 0;

        System.out.println("Function Interface...");
        System.out.println("Initial Value :" + initialValue);

        int finalValue = multiplyBy10Function.apply(incrementByOneFunction.apply(initialValue));
        System.out.println("Final Value :" + finalValue);

        System.out.println("---------------------------------------------------------------------------------");

        System.out.println("BiFunction Interface...");
        System.out.println(incrementByOneThenMultiplyBy10.apply(4, 100));
    }

}
