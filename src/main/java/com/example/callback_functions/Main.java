package com.example.callback_functions;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        fun1("Rishabh", "Rawat", value -> {
            System.out.println("There is no second name for " + value);
        });

        fun2("Rishabh", null, () -> {
            System.out.println("There is no second name");
        });
    }

    static void fun1(String firstName, String secondName, Consumer<String> callback) {
        System.out.println(firstName);
        if (secondName != null) {
            System.out.println(secondName);
        } else {
            callback.accept(firstName);
        }
    }

    static void fun2(String firstName, String secondName, Runnable callback) {
        System.out.println(firstName);
        if (secondName != null) {
            System.out.println(secondName);
        } else {
            callback.run();
        }
    }

}
