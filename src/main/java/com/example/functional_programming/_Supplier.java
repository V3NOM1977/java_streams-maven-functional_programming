package com.example.functional_programming;

import java.util.function.Supplier;

public class _Supplier {

    // DOES NOT TAKE ANY INPUT
    private static final Supplier<String> databaseURLSupplier = () -> "jdbc://localhost:3306/example";

    public static void main(String[] args) {
        String databaseURL = databaseURLSupplier.get();
        System.out.println("Your database url is "+databaseURL);
    }

}
